package dk.youtec.drchannels.ui.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.net.Uri
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.view.isVisible
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.ui.view.AspectImageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.program_item.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*

class ProgramAdapter(
        val context: Context,
        val schedule: Schedule,
        val api: DrMuReactiveRepository
) : RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {

    private var colorMatrixColorFilter: ColorMatrixColorFilter
    private var resources: Resources

    init {
        val matrix = ColorMatrix().apply {
            setSaturation(0f)
        }
        colorMatrixColorFilter = ColorMatrixColorFilter(matrix)
        resources = context.resources
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val program = schedule.Broadcasts[position]

        //Title and description
        holder.title.text = program.Title
        holder.nowDescription.text = program.Description

        //Time
        val localDateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
        val startDate = localDateFormat.format(program.StartTime)

        val localTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val startTime = localTimeFormat.format(program.StartTime)
        val endTime = localTimeFormat.format(program.EndTime)

        holder.time.text = buildString {
            append(startDate)
            append(" ")
            append(startTime)
            append(" - ")
            append(endTime)
        }

        //Header color
        if (program.StartTime.time < System.currentTimeMillis() && System.currentTimeMillis() <= program.EndTime.time) {
            holder.live.visibility = View.VISIBLE
            //holder.header.setBackgroundColor(mResources.getColor(R.color.liveProgramHeaderBackground))
        } else {
            holder.live.visibility = View.GONE
            //holder.header.setBackgroundColor(mResources.getColor(R.color.channelHeaderBackground))
        }

        holder.image.apply {
            if (!program.ProgramCard.PrimaryImageUri.isEmpty()) {
                visibility = View.VISIBLE
                Glide.with(context)
                        .load(program.ProgramCard.PrimaryImageUri)
                        .apply(RequestOptions()
                                .placeholder(R.drawable.image_placeholder))
                        .into(this)
            } else {
                visibility = View.GONE
                image = null
            }
        }

        //Set view enabled state
        holder.enabled = program.ProgramCard.PrimaryAsset?.Uri?.isNotEmpty() ?: false
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.program_item))
    }

    override fun getItemCount(): Int {
        return schedule.Broadcasts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header: View = itemView.programHeader
        val title: TextView = itemView.title
        val nowDescription: TextView = itemView.nowDescription
        val image: ImageView = itemView.image
        val time: TextView = itemView.time
        val genre: ImageView = itemView.genre
        val live: TextView = itemView.live
        var enabled: Boolean = false
            set(value) {
                field = value
                itemView.isClickable = value
                itemView.isFocusable = value
                itemView.isEnabled = value
                title.isEnabled = value
                nowDescription.isVisible = value
                image.isVisible = value
                time.isEnabled = value
                image.colorFilter = if (value) null else colorMatrixColorFilter
            }

        init {
            itemView.setOnClickListener {
                handleClick(it)
            }

            (image as AspectImageView).setAspectRatio(292, 189)
        }

        private fun handleClick(it: View) {
            val program = schedule.Broadcasts[adapterPosition]

            when {
                program.StartTime.time < System.currentTimeMillis() -> playProgram(program)
                program.ProgramCard.PrimaryAsset?.Uri?.isNotEmpty() == true -> playProgram(program)
                else -> it.context.toast(it.context.getString(R.string.upcomingTransmission))
            }
        }

        private fun playProgram(program: MuScheduleBroadcast) {

            val uri = program.ProgramCard.PrimaryAsset?.Uri
            if (uri != null) {
                api.getManifestObservable(uri)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onNext = { manifest ->
                                    val playbackUri = manifest.Links.firstOrNull { it.Target == "HLS" }?.Uri
                                    if (playbackUri != null) {
                                        val intent = buildIntent(context, playbackUri)
                                        context.startActivity(intent)
                                    } else {
                                        context.toast("No HLS stream")
                                    }
                                },
                                onError = { e ->
                                    context.toast(
                                            if (e.message != null
                                                    && e.message != "Success") e.message!!
                                            else context.getString(R.string.cantChangeChannel))
                                }
                        )
            } else {
                context.toast("No stream")
            }
        }
    }

    fun buildIntent(context: Context, uri: String): Intent {
        val preferExtensionDecoders = false

        return Intent(context, PlayerActivity::class.java).apply {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS, preferExtensionDecoders)
            data = Uri.parse(uri)
        }
    }
}