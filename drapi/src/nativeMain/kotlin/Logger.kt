package dk.youtec.drapi

actual object Logger {
    actual fun v(message: String) {
        println("V/ $message")
    }

    actual fun d(message: String) {
        println("D/ $message")
    }

    actual fun e(e: Exception, message: String) {
        println("E/ $message")
        e.printStackTrace()
    }
}