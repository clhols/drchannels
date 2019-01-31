package dk.youtec.drchannels.util

import org.koin.core.KoinComponent
import org.koin.core.inject

inline fun <reified T> koined(): T {
    return object : KoinComponent {
        val value: T by inject()
    }.value
}