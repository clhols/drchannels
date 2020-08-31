package dk.youtec.drapi

import io.ktor.util.date.InvalidDateStringException
import kotlinx.serialization.*
import kotlinx.serialization.encoding.*
import kotlinx.serialization.descriptors.*

object DateDeserializer : KSerializer<Long> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveSerialDescriptor("DateDeserializer", PrimitiveKind.STRING)

    private val dateFormat = DateParser("YYYY-MM-ddTHH:mm:ss*")

    override fun serialize(encoder: Encoder, value: Long): Unit {
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