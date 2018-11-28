package dk.youtec.drapi.multiplatform

import kotlinx.serialization.Decoder
import kotlinx.serialization.Encoder
import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializer

expect class Date(millisSinceEpoch: Long) {
    fun getTime(): Long
}

@Serializer(forClass = Date::class)
expect object DateSerializer: KSerializer<Date> {
    override fun serialize(output: Encoder, obj: Date)
    override fun deserialize(input: Decoder): Date
}