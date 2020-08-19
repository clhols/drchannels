package dk.youtec.drchannels.ui.adapter

import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.loadAny
import coil.transform.RoundedCornersTransformation
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.view.AspectImageView
import dk.youtec.drchannels.util.inflate
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.android.synthetic.main.channels_item.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.channels.BroadcastChannel
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.launch
import java.util.Date

class TvChannelsAdapter(
        val scope: CoroutineScope
) : ListAdapter<MuNowNext, TvChannelsAdapter.ViewHolder>(ChannelsDiffItemCallback()) {

    private val moreClickedChannel = BroadcastChannel<MuNowNext>(1)
    private val itemClickedChannel = BroadcastChannel<MuNowNext>(1)
    private val startOverClickedChannel = BroadcastChannel<MuNowNext>(1)

    val moreClicked = moreClickedChannel.asFlow()
    val itemClicked = itemClickedChannel.asFlow()
    val startOverClicked = startOverClickedChannel.asFlow()

    //Toggles if description and image should be shown
    private var showDetails = true

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val tvChannel = getItem(position)
        val now = tvChannel.now ?: return

        holder.channelName.text = tvChannel.channelSlug.toUpperCase()
        holder.title.text = now.title
        holder.nowDescription.text = now.description
        holder.nowDescription.visibility = if (showDetails) View.VISIBLE else View.GONE

        //Show time interval
        val localDateFormat = serverDateFormat("HH:mm")
        val startTime = localDateFormat.format(Date(now.startTime))
        val endTime = localDateFormat.format(Date(now.endTime))

        holder.time.text = buildString {
            append(startTime)
            append(" \u2023 ")
            append(endTime)
        }

        //Progress
        val programDuration = now.endTime - now.startTime
        val programTime = System.currentTimeMillis() - now.startTime
        val percentage = 100 * programTime.toFloat() / programDuration
        holder.progress.progress = percentage.toInt()

        //Genre icon
        holder.genre.apply {
            setImageResource(0)
            if (now.onlineGenreText == "Sport") {
                //Sport genre
                setImageResource(R.drawable.ic_genre_dot_black)
                setColorFilter(
                        ContextCompat.getColor(
                                context,
                                android.R.color.holo_blue_dark))
            }
        }

        //holder.mTimeLeft.text = "(" + (channel.now.endTime - System.currentTimeMillis()) / 60 + " min left)"

        holder.image.apply {
            if (now.programCard.primaryImageUri.isNotEmpty() && showDetails) {
                visibility = View.VISIBLE
                loadAny(now.programCard) {
                    transformations(RoundedCornersTransformation(40f))
                }
            } else {
                visibility = View.GONE
                load("")
            }
        }

        holder.nextTitle.text =
                if (tvChannel.next.isNotEmpty())
                    holder.nextTitle.context.getString(R.string.next) + ": ${tvChannel.next.first().title}"
                else ""
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.channels_item))
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val channelName: TextView = itemView.channelName
        val title: TextView = itemView.title
        val progress: ProgressBar = itemView.progress
        val nowDescription: TextView = itemView.nowDescription
        val image: AspectImageView = itemView.image
        val logo: ImageView = itemView.logo
        val time: TextView = itemView.time
        val genre: ImageView = itemView.genre
        val more: ImageButton = itemView.more
        val nextTitle: TextView = itemView.nextTitle

        init {
            more.setOnClickListener {
                scope.launch {
                    moreClickedChannel.offer(getItem(adapterPosition))
                }
            }

            image.setAspectRatio(292, 189)

            itemView.setOnClickListener {
                if (adapterPosition in 0 until itemCount) {
                    scope.launch {
                        itemClickedChannel.offer(getItem(adapterPosition))
                    }
                }
            }
            itemView.setOnLongClickListener {
                AlertDialog.Builder(it.context)
                        .setTitle(R.string.channelAction)
                        .setItems(arrayOf(it.context.getString(R.string.startOverAction))) { _, _ ->
                            if (adapterPosition in 0 until itemCount) {
                                startOverClickedChannel.offer(getItem(adapterPosition))
                            }
                        }
                        .show()
                true
            }
        }
    }
}

class ChannelsDiffItemCallback : DiffUtil.ItemCallback<MuNowNext>() {
    override fun areItemsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem.channelSlug == newItem.channelSlug

    override fun areContentsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem == newItem
}