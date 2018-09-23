package dk.youtec.drchannels.ui.adapter

import android.content.Context
import android.content.Intent
import android.content.res.Resources
import android.graphics.ColorMatrix
import android.graphics.ColorMatrixColorFilter
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drapi.Schedule
import dk.youtec.drchannels.R
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.ui.view.AspectImageView
import dk.youtec.drchannels.util.calendar
import dk.youtec.drchannels.util.load
import dk.youtec.drchannels.util.serverDateFormat
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.program_item.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.toast

class ProgramAdapter(
        private val context: Context,
        private val schedule: Schedule,
        private val api: DrMuReactiveRepository
) : RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {

    private var colorMatrixColorFilter: ColorMatrixColorFilter
    private var resources: Resources
    private var genreFilter: String = ""
    private val todaysDate: String = serverDateFormat("dd/MM").format(calendar().time)
    var broadcasts: List<MuScheduleBroadcast> = schedule.Broadcasts

    init {
        val matrix = ColorMatrix().apply {
            setSaturation(0f)
        }
        colorMatrixColorFilter = ColorMatrixColorFilter(matrix)
        resources = context.resources
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val program = broadcasts[position]

        //Title and description
        holder.title.text = program.Title
        holder.nowDescription.text = program.Description

        //Time
        val localDateFormat = serverDateFormat("dd/MM")
        val startDate = localDateFormat.format(program.StartTime)

        val localTimeFormat = serverDateFormat("HH:mm")
        val startTime = localTimeFormat.format(program.StartTime)
        val endTime = localTimeFormat.format(program.EndTime)

        holder.time.text = if (startDate == todaysDate)
            "$startTime - $endTime"
        else
            "$startDate $startTime - $endTime"

        //Header color
        holder.live.isVisible = System.currentTimeMillis() in
                ((program.StartTime.time + 1)..program.EndTime.time)

        holder.image.apply {
            if (!program.ProgramCard.PrimaryImageUri.isEmpty()) {
                isVisible = true
                load(program.ProgramCard.PrimaryImageUri)
            } else {
                isVisible = false
                image = null
            }
        }

        //Set view enabled state
        holder.enabled = program.ProgramCard.PrimaryAsset?.Uri?.isNotEmpty() ?: false
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.program_item))
    }

    override fun getItemCount(): Int = broadcasts.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val header: View = itemView.programHeader
        val title: TextView = itemView.title
        val nowDescription: TextView = itemView.nowDescription
        val image: AspectImageView = itemView.image
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

            image.setAspectRatio(292, 189)
        }

        private fun handleClick(it: View) {
            val program = broadcasts[adapterPosition]

            when {
                program.StartTime.time < System.currentTimeMillis() -> playProgram(program)
                program.ProgramCard.PrimaryAsset?.Uri?.isNotEmpty() == true -> playProgram(program)
                else -> it.context.toast(it.context.getString(R.string.upcomingTransmission))
            }
        }

        private fun playProgram(program: MuScheduleBroadcast) {
            val uri = program.ProgramCard.PrimaryAsset?.Uri
            if (uri != null) {
                api.getManifest(uri)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onSuccess = { manifest ->
                                    val playbackUri = manifest.uri
                                    if (playbackUri != null) {
                                        context.startActivity(buildIntent(context, playbackUri))
                                    } else {
                                        context.toast("No stream")
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
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS_EXTRA, preferExtensionDecoders)
            data = uri.toUri()
        }
    }

    fun setGenreFilter(genre: String = "") {
        genreFilter = genre
        broadcasts = if (genreFilter.isNotBlank()) {
            schedule.Broadcasts.filter { it.OnlineGenreText == genreFilter }
        } else {
            schedule.Broadcasts
        }
        notifyDataSetChanged()
    }
}