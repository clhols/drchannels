package dk.youtec.drapi

import io.ktor.util.date.*

class DateParser(private val pattern: String) {
    init {
        check(pattern.isNotEmpty()) { "Date parser pattern shouldn't be empty." }
    }

    /**
     * Parse [GMTDate] from [dateString] using [pattern].
     */
    fun parse(dateString: String): GMTDate {
        val builder = DateBuilder()

        var start = 0
        var current = pattern[start]
        var chunkStart = 0
        var index = 1

        try {
            while (index < pattern.length) {
                if (pattern[index] == current) {
                    index++
                    continue
                }

                val chunkEnd = chunkStart + index - start
                builder.handleToken(current, dateString.substring(chunkStart, chunkEnd))

                chunkStart = chunkEnd
                start = index
                current = pattern[index]

                index++
            }

            if (chunkStart < dateString.length) {
                builder.handleToken(current, dateString.substring(chunkStart))
            }
        } catch (_: Throwable) {
            throw InvalidDateStringException(dateString, chunkStart, pattern)
        }

        return builder.build()
    }

    private fun DateBuilder.handleToken(
            type: Char, chunk: String
    ): Unit = when (type) {
        SECONDS -> {
            seconds = chunk.toInt()
        }
        MINUTES -> {
            minutes = chunk.toInt()
        }
        HOURS -> {
            hours = chunk.toInt()
        }
        DAY_OF_MONTH -> {
            dayOfMonth = chunk.toInt()
        }
        MONTH -> {
            month = chunk.toInt()-1
        }
        YEAR -> {
            year = chunk.toInt()
        }
        ZONE ->
            check(chunk == "Z")
        ANY -> Unit
        else -> {
            check(chunk.all { it == type })
        }
    }

    companion object {
        const val SECONDS = 's'
        const val MINUTES = 'm'
        const val HOURS = 'H'

        const val DAY_OF_MONTH = 'd'
        const val MONTH = 'M'
        const val YEAR = 'Y'

        const val ZONE = 'Z'

        const val ANY = '*'
    }
}

internal class DateBuilder {
    var seconds: Int? = null
    var minutes: Int? = null
    var hours: Int? = null

    var dayOfMonth: Int? = null
    var month: Int? = null
    var year: Int? = null

    fun build(): GMTDate = GMTDate(seconds!!, minutes!!, hours!!, dayOfMonth!!, Month.from(month!!), year!!)
}