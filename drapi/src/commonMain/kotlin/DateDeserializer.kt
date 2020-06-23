package dk.youtec.drapi

import io.ktor.util.date.InvalidDateStringException
import kotlinx.serialization.*

object DateDeserializer : KSerializer<Long> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveDescriptor("DateDeserializer", PrimitiveKind.STRING)

    private val dateFormat = DateParser("YYYY-MM-ddTHH:mm:ss*")

    override fun serialize(encoder: Encoder, value: Long) {
        throw IllegalStateException("Only deserialize available in DateDeserializer")
    }

    override fun deserialize(decoder: Decoder): Long {
        val json = decoder.decodeString()
        return try {
            dateFormat.parse(json).timestamp
        } catch (e: InvalidDateStringException) {
            println("Error parsing date ${e.message}")
            0L
        }
    }
}