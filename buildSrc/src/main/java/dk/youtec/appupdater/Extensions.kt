package dk.youtec.appupdater

import groovy.lang.Closure
import java.io.File
import java.text.SimpleDateFormat
import java.util.*
import java.util.concurrent.TimeUnit

internal fun String.execute(dir: File? = null): String {
    val cmdArgs = split(" ")

    val process = ProcessBuilder(cmdArgs)
            .directory(dir)
            .redirectOutput(ProcessBuilder.Redirect.PIPE)
            .redirectError(ProcessBuilder.Redirect.PIPE)
            .start()

    return with(process) {
        waitFor(10, TimeUnit.SECONDS)
        inputStream.bufferedReader().readText()
    }
}

internal fun String.print() = apply { println(this) }

fun dateFormat(
        pattern: String,
        locale: Locale = Locale.getDefault(),
        block: SimpleDateFormat.() -> Unit = {}
) = SimpleDateFormat(pattern, locale).apply(block)

fun <T> closure(block: () -> T) = object : Closure<T>(null) {
    fun doCall(vararg args: Any?): T {
        return block.invoke()
    }
}