package dk.youtec.drchannels.backend.exception

import java.io.IOException

class HttpException(val code: Int, httpMessage: String) : IOException(httpMessage)