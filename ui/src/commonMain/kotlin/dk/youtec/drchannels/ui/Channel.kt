package dk.youtec.drchannels.ui

data class Channel(
    val slug: String,
    val title: String,
    val subtitle: String,
    val primaryImageUri: String,
    val videoItem: VideoItem
)