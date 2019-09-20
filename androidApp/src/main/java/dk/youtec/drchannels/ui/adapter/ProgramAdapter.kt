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
import coil.api.load
import coil.api.loadAny
import dk.youtec.drapi.DrMuRepository
import dk.youtec.drapi.MuScheduleBroadcast
import dk.youtec.drapi.Schedule
import dk.youtec.drapi.decryptUri
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.exoplayer.PlayerActivity
import dk.youtec.drchannels.ui.view.AspectImageView
import dk.youtec.drchannels.util.calendar
import dk.youtec.drchannels.util.inflate
import dk.youtec.drchannels.util.serverDateFormat
import dk.youtec.drchannels.util.toast
import kotlinx.android.synthetic.main.program_item.view.*
import kotlinx.coroutines.*
import kotlinx.coroutines.Dispatchers.IO
import org.koin.core.KoinComponent
import org.koin.core.inject
import java.lang.Exception
import java.util.Date

class ProgramAdapter(
        private val context: Context,
        private val schedule: Schedule
) : RecyclerView.Adapter<ProgramAdapter.ViewHolder>(), CoroutineScope by MainScope(), KoinComponent {
    private val api: DrMuRepository by inject()
    private val datePattern = "dd/M"
    private val timePattern = "HH:mm"

    private var colorMatrixColorFilter: ColorMatrixColorFilter
    private var resources: Resources
    private var genreFilter: String = ""
    private val todaysDate: String = serverDateFormat(datePattern).format(calendar().time)
    var broadcasts: List<MuScheduleBroadcast> = schedule.broadcasts

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
        holder.title.text = program.title
        holder.nowDescription.text = program.description

        //Time
        val localDateFormat = serverDateFormat(datePattern)
        val startDate = localDateFormat.format(Date(program.startTime))

        val localTimeFormat = serverDateFormat(timePattern)
        val startTime = localTimeFormat.format(Date(program.startTime))
        val endTime = localTimeFormat.format(Date(program.endTime))

        holder.time.text = if (startDate == todaysDate)
            "$startTime \u2023 $endTime"
        else
            "$startDate \u2043 $startTime \u2023 $endTime"

        //Header color
        holder.live.isVisible = System.currentTimeMillis() in
                ((program.startTime + 1)..program.endTime)

        holder.image.apply {
            if (program.programCard.primaryImageUri.isNotEmpty()) {
                isVisible = true
                loadAny(program.programCard)
            } else {
                isVisible = false
                load("")
            }
        }

        //Set view enabled state
        holder.enabled = program.programCard.primaryAsset?.uri?.isNotEmpty() ?: false
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
                program.startTime < System.currentTimeMillis() -> playProgram(program)
                program.programCard.primaryAsset?.uri?.isNotEmpty() == true -> playProgram(program)
                else -> it.context.toast(it.context.getString(R.string.upcomingTransmission))
            }
        }

        private fun playProgram(program: MuScheduleBroadcast) {
            launch {
                val uri = program.programCard.primaryAsset?.uri
                if (uri != null) {
                    try {
                        val manifest = withContext(IO) { api.getManifest(uri) }
                        val playbackUri = manifest.getUri() ?: decryptUri(manifest.getEncryptedUri())
                        if (playbackUri.isNotBlank()) {
                            context.startActivity(buildIntent(context, playbackUri))
                        } else {
                            context.toast("No stream")
                        }
                    } catch (e: Exception) {
                        context.toast(
                                if (e.message != null
                                        && e.message != "Success") e.message!!
                                else context.getString(R.string.cantChangeChannel))
                    }
                } else {
                    context.toast("No stream")
                }
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
            schedule.broadcasts.filter { it.onlineGenreText == genreFilter }
        } else {
            schedule.broadcasts
        }
        notifyDataSetChanged()
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        cancel()
        super.onDetachedFromRecyclerView(recyclerView)
    }
}