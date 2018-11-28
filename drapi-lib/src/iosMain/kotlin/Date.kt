package dk.youtec.drapi.multiplatform

actual class Date actual constructor(millisSinceEpoch: Long) {
    actual fun getTime(): Long {
        TODO("not implemented")
    }
}

@Serializer(forClass = Date::class)
actual object DateSerializer {
    actual override fun serialize(output: Encoder, obj: Date) {}
    actual override fun deserialize(input: Decoder): Date {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}