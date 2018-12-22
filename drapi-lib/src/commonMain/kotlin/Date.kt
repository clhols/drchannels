package dk.youtec.drapi

import com.soywiz.klock.DateException
import com.soywiz.klock.DateFormat
import com.soywiz.klock.DateTime
import com.soywiz.klock.parse
import kotlinx.serialization.*
import kotlinx.serialization.internal.StringDescriptor

class Date {
    internal var dateTime = DateTime(0)

    var time: Long
        get() = dateTime.unixMillisLong
        set(value) {
            dateTime = DateTime(value)
        }

    override fun toString(): String = dateTime.toString()
}

@Serializer(forClass = Date::class)
object DateSerializer : KSerializer<Date> {
    override val descriptor: SerialDescriptor
        get() = StringDescriptor.withName("WithCustomDefault")

    private val dateFormatMillis = DateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'")
    private val dateFormatSeconds = DateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'")

    override fun serialize(output: Encoder, obj: Date) {
        output.encodeString(obj.dateTime.format(dateFormatMillis))
    }

    override fun deserialize(input: Decoder): Date {
        val json = input.decodeString()
        return try {
            Date().apply { dateTime = dateFormatMillis.parse(json).local }
        } catch (e: DateException) {
            Date().apply { dateTime = dateFormatSeconds.parse(json).local }
        }
    }
}