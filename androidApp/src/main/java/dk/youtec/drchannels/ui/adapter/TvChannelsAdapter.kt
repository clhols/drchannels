package dk.youtec.drchannels.ui.adapter

import android.content.Context
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
import coil.api.load
import coil.api.loadAny
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.view.AspectImageView
import dk.youtec.drchannels.util.inflate
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.android.synthetic.main.channels_item.view.*
import java.util.Date

class TvChannelsAdapter(
        val listener: OnChannelClickListener
) : ListAdapter<MuNowNext, TvChannelsAdapter.ViewHolder>(ChannelsDiffItemCallback()) {

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
        val startTime = localDateFormat.format(Date(now.startTime.time))
        val endTime = localDateFormat.format(Date(now.endTime.time))

        holder.time.text = buildString {
            append(startTime)
            append(" - ")
            append(endTime)
        }

        //Progress
        val programDuration = now.endTime.time - now.startTime.time
        val programTime = System.currentTimeMillis() - now.startTime.time
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
                loadAny(now.programCard)
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
                listener.showTvChannel(it.context, getItem(adapterPosition))
            }

            image.setAspectRatio(292, 189)

            itemView.setOnClickListener {
                if (adapterPosition in 0 until itemCount) {
                    listener.playTvChannel(getItem(adapterPosition))
                }
            }
            itemView.setOnLongClickListener {
                AlertDialog.Builder(it.context)
                        .setTitle(R.string.channelAction)
                        .setItems(arrayOf(it.context.getString(R.string.startOverAction))) { _, _ ->
                            if (adapterPosition in 0 until itemCount) {
                                listener.playProgram(getItem(adapterPosition))
                            }
                        }
                        .show()
                true
            }
        }
    }

    interface OnChannelClickListener {
        fun showTvChannel(context: Context, tvChannel: MuNowNext)
        fun playTvChannel(muNowNext: MuNowNext)
        fun playProgram(muNowNext: MuNowNext)
    }
}

class ChannelsDiffItemCallback : DiffUtil.ItemCallback<MuNowNext>() {
    override fun areItemsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem.channelSlug == newItem.channelSlug

    override fun areContentsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem == newItem
}