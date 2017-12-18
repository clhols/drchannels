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
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import dk.youtec.drchannels.R
import org.jetbrains.anko.*
import java.text.SimpleDateFormat
import java.util.*
import dk.youtec.drchannels.ui.PlayerActivity
import dk.youtec.drchannels.ui.view.AspectImageView
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.find
import org.jetbrains.anko.toast
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import dk.youtec.drapi.*


class ProgramAdapter(val context: Context, val channelSID: String, val programs: Schedule, val api: DrMuReactiveRepository) : RecyclerView.Adapter<ProgramAdapter.ViewHolder>() {

    private var mColorMatrixColorFilter: ColorMatrixColorFilter
    private var mResources: Resources


    init {
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)
        mColorMatrixColorFilter = ColorMatrixColorFilter(matrix)
        mResources = context.resources
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val program = programs.Broadcasts.get(position)

        //Title and description
        holder.mTitle.text = program.Title
        holder.mNowDescription.text = program.Description

        //Time
        val localDateFormat = SimpleDateFormat("dd/MM", Locale.getDefault())
        val startDate = localDateFormat.format(program.StartTime)

        val localTimeFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
        val startTime = localTimeFormat.format(program.StartTime)
        val endTime = localTimeFormat.format(program.EndTime)

        holder.mTime.text = buildString {
            append(startDate)
            append(" ")
            append(startTime)
            append(" - ")
            append(endTime)
        }

        //Header color
        if(program.StartTime.time < System.currentTimeMillis() && System.currentTimeMillis() <= program.EndTime.time) {
            holder.mLive.visibility = View.VISIBLE
            //holder.mHeader.setBackgroundColor(mResources.getColor(R.color.liveProgramHeaderBackground))
        } else {
            holder.mLive.visibility = View.GONE
            //holder.mHeader.setBackgroundColor(mResources.getColor(R.color.channelHeaderBackground))
        }

        holder.mImage.apply {
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
        holder.mEnabled = true
        holder.itemView.isClickable = holder.mEnabled
        holder.itemView.isEnabled = holder.mEnabled
        holder.mTitle.isEnabled = holder.mEnabled
        holder.mNowDescription.isEnabled = holder.mEnabled
        holder.mTime.isEnabled = holder.mEnabled
        holder.mImage.colorFilter = if (holder.mEnabled) null else mColorMatrixColorFilter
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
        return programs.Broadcasts.size
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mHeader: View
        var mTitle: TextView
        var mNowDescription: TextView
        var mImage: ImageView
        var mTime: TextView
        var mGenre: ImageView
        var mLive: TextView
        var mEnabled: Boolean = false

        init {
            itemView.setOnClickListener {
                handleClick(it)
            }
            mHeader = itemView.findViewById(R.id.programHeader)
            mTitle = itemView.findViewById(R.id.title)
            mNowDescription = itemView.findViewById(R.id.nowDescription)
            mImage = itemView.findViewById(R.id.image)
            mTime = itemView.find(R.id.time)
            mGenre = itemView.find(R.id.genre)
            mLive = itemView.find(R.id.live)

            (mImage as AspectImageView).setAspectRatio(292, 189)
        }

        private fun handleClick(it: View) {
            val program = programs.Broadcasts[adapterPosition]

            when {
                program.StartTime.time < System.currentTimeMillis() -> playProgram(program)
                program.IsRerun -> playProgram(program)
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

        val intent = Intent(context, PlayerActivity::class.java)
        with(intent) {
            action = PlayerActivity.ACTION_VIEW
            putExtra(PlayerActivity.PREFER_EXTENSION_DECODERS, preferExtensionDecoders)
            setData(Uri.parse(uri))
        }
        return intent
    }



}