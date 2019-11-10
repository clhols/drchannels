package dk.youtec.drapi

expect object Logger {
    fun v(message: String)
    fun d(message: String)
    fun e(e: Exception, message: String)
}