import java.text.SimpleDateFormat
import java.util.*

val versionCodeTimestamp
    get() = SimpleDateFormat("yyMMddHH00", Locale.US)
            .apply { timeZone = TimeZone.getTimeZone("Europe/Copenhagen") }
            .format(Date()).toInt()