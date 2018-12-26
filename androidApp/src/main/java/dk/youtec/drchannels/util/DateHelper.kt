package dk.youtec.drchannels.util

import java.text.SimpleDateFormat
import java.util.*

val defaultLocale: Locale = Locale.GERMAN
val serverTimeZone: TimeZone = TimeZone.getTimeZone("Europe/Copenhagen")

inline fun calendar(block: Calendar.() -> Unit = {}): Calendar = GregorianCalendar.getInstance().apply(block)

inline fun serverCalendar(block: Calendar.() -> Unit = {}): Calendar = calendar {
    timeZone = serverTimeZone
    block()
}

inline fun dateFormat(pattern: String,
                      locale: Locale = defaultLocale,
                      block: SimpleDateFormat.() -> Unit = {}): SimpleDateFormat = SimpleDateFormat(pattern, locale).apply(block)

fun serverDateFormat(pattern: String) = dateFormat(pattern, defaultLocale) {
    timeZone = serverTimeZone
}