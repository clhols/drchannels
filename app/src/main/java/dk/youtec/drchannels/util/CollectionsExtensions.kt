package dk.youtec.drchannels.util

fun <T> Collection<T>?.isNullOrEmpty(): Boolean = this?.isEmpty() ?: true