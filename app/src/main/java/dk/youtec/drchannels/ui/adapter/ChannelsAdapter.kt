package dk.youtec.drchannels.ui.adapter

import android.content.Context
import android.support.annotation.LayoutRes
import android.support.annotation.MainThread
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import dk.youtec.drchannels.backend.*
import dk.youtec.drchannels.R
import org.jetbrains.anko.*
import java.text.SimpleDateFormat
import java.util.*
import android.support.v7.util.DiffUtil
import android.support.v7.util.ListUpdateCallback
import android.util.Log
import android.widget.ImageButton
import android.widget.ProgressBar
import com.bumptech.glide.request.RequestOptions
import dk.youtec.drapi.MuNowNext
import dk.youtec.drchannels.model.ChannelsDiffCallback
import dk.youtec.drchannels.ui.view.AspectImageView

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

class ChannelsAdapter(
        val contentView: View?,
        var channels: List<MuNowNext>,
        val listener: OnChannelClickListener
) : RecyclerView.Adapter<ChannelsAdapter.ViewHolder>() {

    //Toggles if description and image should be shown
    private var showDetails = true

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val channel = channels[position]
        val now = channel.Now!!

        holder.channelName.text = channel.ChannelSlug.toUpperCase()
        holder.title.text = now.Title
        holder.nowDescription.text = now.Description
        holder.nowDescription.visibility = if (showDetails) View.VISIBLE else View.GONE

        //Show time interval
        val localDateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
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
        holder.genre.setImageResource(0)
        if (now.OnlineGenreText == "Sport") {
            //Sport genre
            holder.genre.setImageResource(R.drawable.ic_genre_dot_black);
            holder.genre.setColorFilter(
                    ContextCompat.getColor(
                            holder.itemView.context,
                            android.R.color.holo_blue_dark))
        }

        //holder.mTimeLeft.text = "(" + (channel.now.endTime - System.currentTimeMillis()) / 60 + " min left)"

        if (!now.ProgramCard.PrimaryImageUri.isEmpty() && showDetails) {
            holder.image.visibility = View.VISIBLE
            Glide.with(holder.image.context)
                    .load(now.ProgramCard.PrimaryImageUri)
                    .apply(RequestOptions()
                            .placeholder(R.drawable.image_placeholder))
                    .into(holder.image)
        } else {
            holder.image.visibility = View.GONE
            holder.image.image = null
        }

        /*
        Glide.with(holder.logo.context)
                .load(URL_GET_GFX
                        .replace("[SID]", channel.sid, true)
                        .replace("[SIZE]", 60.toString()))
                .apply(RequestOptions()
                        .override(Target.SIZE_ORIGINAL, Target.SIZE_ORIGINAL))
                .into(holder.logo)
                */

        holder.nextTitle.text =
                if (channel.Next.isNotEmpty())
                    holder.nextTitle.context.getString(R.string.next) + ": ${channel.Next.first().Title}"
                else ""
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, payloads: MutableList<Any>) {
        if (payloads.isEmpty()) {
            super.onBindViewHolder(holder, position, payloads)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent.inflate(R.layout.channels_item))
    }

    @MainThread
    fun updateList(newList: List<MuNowNext>) {
        //Calculate the diff
        val diffResult = DiffUtil.calculateDiff(ChannelsDiffCallback(channels, newList))

        //Update the backing list
        channels = newList

        diffResult.dispatchUpdatesTo(object : ListUpdateCallback {
            override fun onInserted(position: Int, count: Int) {
            }

            override fun onRemoved(position: Int, count: Int) {
            }

            override fun onMoved(fromPosition: Int, toPosition: Int) {
            }

            override fun onChanged(position: Int, count: Int, payload: Any) {
                if (position < newList.size) {
                    val (_, channelName, now, _) = newList[position]

                    if (contentView != null) {
                        val message = now?.Title + " " + contentView.context.getString(R.string.on) + " " + channelName
                        Log.d(TAG, message)

                        //contentView.context.longToast(message)
                    }
                }
            }
        })

        //Make the adapter notify of the changes
        diffResult.dispatchUpdatesTo(this)
    }

    override fun getItemCount(): Int = channels.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val TAG = ViewHolder::class.java.simpleName
        val channelName: TextView = itemView.find(R.id.channelName)
        val title: TextView = itemView.findViewById(R.id.title)
        val progress: ProgressBar = itemView.findViewById(R.id.progress)
        val nowDescription: TextView = itemView.findViewById(R.id.nowDescription)
        val image: ImageView = itemView.findViewById(R.id.image)
        val logo: ImageView = itemView.findViewById(R.id.logo)
        val time: TextView = itemView.findViewById(R.id.time)
        val genre: ImageView = itemView.findViewById(R.id.genre)
        val more: ImageButton = itemView.findViewById(R.id.more)
        val nextTitle: TextView = itemView.findViewById(R.id.nextTitle)

        init {
            more.visibility = View.GONE
            more.setOnClickListener {
                listener.showChannel(it.context, channels[adapterPosition])
            }

            (image as AspectImageView).setAspectRatio(292, 189)

            itemView.setOnClickListener {
                if (0 <= adapterPosition && adapterPosition < channels.size) {
                    listener.playChannel(channels[adapterPosition])
                }
            }
            itemView.setOnLongClickListener {
                it.context.selector(it.context.getString(R.string.channelAction), listOf(it.context.getString(R.string.startOverAction))) { _, _ ->
                    if (0 <= adapterPosition && adapterPosition < channels.size) {
                        listener.playProgram(channels[adapterPosition])
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