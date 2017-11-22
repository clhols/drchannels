package dk.youtec.drapi

import java.io.IOException

class DrMuException(message: String?): IOException(message ?: "Unknown error")