package dk.youtec.drchannels.model

import android.support.v7.util.DiffUtil
import dk.youtec.drapi.MuNowNext

class ChannelsDiffCallback(
        private val oldChannels: List<MuNowNext>,
        private val newChannels: List<MuNowNext>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldChannels.size

    override fun getNewListSize(): Int = newChannels.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldChannels[oldItemPosition].ChannelSlug == newChannels[newItemPosition].ChannelSlug

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
            oldChannels[oldItemPosition] == newChannels[newItemPosition]

    override fun getChangePayload(oldItemPosition: Int, newItemPosition: Int): Any? {
        val newChannel = newChannels[newItemPosition]
        val oldChannel = oldChannels[oldItemPosition]

        if (newChannel.Now != oldChannel.Now) {
            return newChannel.Now
        }
        if (newChannel.Next != oldChannel.Next) {
            return newChannel.Next
        }

        return super.getChangePayload(oldItemPosition, newItemPosition)
    }
}