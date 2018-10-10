import java.text.SimpleDateFormat
import java.util.*

val versionCodeTimestamp
    get() = SimpleDateFormat("yyMMddHHmm")
            .apply { timeZone = TimeZone.getTimeZone("Europe/Copenhagen") }
            .format(Date()).toInt()