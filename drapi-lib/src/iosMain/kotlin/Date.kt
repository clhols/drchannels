package dk.youtec.drapi.multiplatform

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.Serializer

actual class Date {
    var millisSinceEpoch: Long? = null

    actual fun getTime(): Long {
        return millisSinceEpoch ?: 0
    }

    actual fun setTime(millisSinceEpoch: Long) {
        this.millisSinceEpoch = millisSinceEpoch
    }
}

@Serializer(forClass = Date::class)
actual object DateSerializer {
    actual override fun serialize(output: Encoder, obj: Date) {}
    actual override fun deserialize(input: Decoder): Date {
        return Date().apply {
            setTime(42)
        }
    }
}