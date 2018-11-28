package dk.youtec.drchannels.ui.adapter

import android.content.Context
import androidx.annotation.LayoutRes
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import dk.youtec.drapi.multiplatform.MuNowNext
import dk.youtec.drchannels.R
import dk.youtec.drchannels.ui.view.AspectImageView
import dk.youtec.drchannels.util.load
import dk.youtec.drchannels.util.serverDateFormat
import kotlinx.android.synthetic.main.channels_item.view.*
import org.jetbrains.anko.image
import org.jetbrains.anko.selector

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

class ChannelsAdapter(
        val listener: OnChannelClickListener
) : ListAdapter<MuNowNext, ChannelsAdapter.ViewHolder>(ChannelsDiffItemCallback()) {

    //Toggles if description and image should be shown
    private var showDetails = true

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val channel = getItem(position)
        val now = channel.Now ?: return

        holder.channelName.text = channel.ChannelSlug.toUpperCase()
        holder.title.text = now.Title
        holder.nowDescription.text = now.Description
        holder.nowDescription.visibility = if (showDetails) View.VISIBLE else View.GONE

        //Show time interval
        val localDateFormat = serverDateFormat("HH:mm")
        val startTime = localDateFormat.format(now.StartTime)
        val endTime = localDateFormat.format(now.EndTime)

        holder.time.text = buildString {
            append(startTime)
            append(" - ")
            append(endTime)
        }

        //Progress
        val programDuration = now.EndTime.time - now.StartTime.time
        val programTime = System.currentTimeMillis() - now.StartTime.time
        val percentage = 100 * programTime.toFloat() / programDuration
        holder.progress.progress = percentage.toInt()

        //Genre icon
        holder.genre.apply {
            setImageResource(0)
            if (now.OnlineGenreText == "Sport") {
                //Sport genre
                setImageResource(R.drawable.ic_genre_dot_black);
                setColorFilter(
                        ContextCompat.getColor(
                                context,
                                android.R.color.holo_blue_dark))
            }
        }

        //holder.mTimeLeft.text = "(" + (channel.now.endTime - System.currentTimeMillis()) / 60 + " min left)"

        holder.image.apply {
            if (!now.ProgramCard.PrimaryImageUri.isEmpty() && showDetails) {
                visibility = View.VISIBLE
                load(now.ProgramCard.PrimaryImageUri)
            } else {
                visibility = View.GONE
                image = null
            }
        }

        holder.nextTitle.text =
                if (channel.Next.isNotEmpty())
                    holder.nextTitle.context.getString(R.string.next) + ": ${channel.Next.first().Title}"
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
                listener.showChannel(it.context, getItem(adapterPosition))
            }

            image.setAspectRatio(292, 189)

            itemView.setOnClickListener {
                if (adapterPosition in 0..(itemCount - 1)) {
                    listener.playChannel(getItem(adapterPosition))
                }
            }
            itemView.setOnLongClickListener {
                it.context.selector(it.context.getString(R.string.channelAction), listOf(it.context.getString(R.string.startOverAction))) { _, _ ->
                    if (adapterPosition in 0..(itemCount - 1)) {
                        listener.playProgram(getItem(adapterPosition))
                    }
                }
                true
            }
        }
    }

    interface OnChannelClickListener {
        fun showChannel(context: Context, channel: MuNowNext)
        fun playChannel(muNowNext: MuNowNext)
        fun playProgram(muNowNext: MuNowNext)
    }
}

class ChannelsDiffItemCallback : DiffUtil.ItemCallback<MuNowNext>() {
    override fun areItemsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem.ChannelSlug == newItem.ChannelSlug

    override fun areContentsTheSame(oldItem: MuNowNext, newItem: MuNowNext): Boolean =
            oldItem == newItem
}