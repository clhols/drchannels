package dk.youtec.drchannels.logic.viewmodel

sealed class ChannelsError {
    object NoStream : ChannelsError()
    object LoadingChannelsFailed : ChannelsError()
    data class LoadingChannelFailed(val message: String?) : ChannelsError()
}