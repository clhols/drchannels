package dk.youtec.drchannels.coil

import coil.map.Mapper
import dk.youtec.drapi.ProgramCard
import okhttp3.HttpUrl
import okhttp3.HttpUrl.Companion.toHttpUrl

class ProgramCardMapper : Mapper<ProgramCard, HttpUrl> {
    override fun map(programCard: ProgramCard): HttpUrl = programCard.primaryImageUri.toHttpUrl()
}