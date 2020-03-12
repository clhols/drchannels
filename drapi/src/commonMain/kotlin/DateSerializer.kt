package dk.youtec.drapi

import com.soywiz.klock.*
import kotlinx.serialization.*

@Serializer(forClass = Long::class)
object DateSerializer : KSerializer<Long> {
    override val descriptor: SerialDescriptor
        get() = PrimitiveDescriptor("DateSerializer", PrimitiveKind.STRING)

    private val dateFormat = PatternDateFormat("yyyy-MM-dd'T'HH:mm:ss[.S]'Z'").withOptional()

    override fun serialize(encoder: Encoder, obj: Long) {
        encoder.encodeString(DateTime(obj).format(dateFormat))
    }

    override fun deserialize(decoder: Decoder): Long {
        val json = decoder.decodeString()
        return try {
            dateFormat.parse(json).local.unixMillisLong
        } catch (e: DateException) {
            println("Error parsing date ${e.message}")
            0L
        }
    }
}