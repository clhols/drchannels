import dk.youtec.drapi.DrMuRepository
import kotlinx.coroutines.runBlocking

fun main(args: Array<String>) = runBlocking {
    val repo = DrMuRepository()

    val channels = repo.getScheduleNowNext()
    channels.forEach {
        println("Channel ${it.channelSlug} showing ${it.now?.title}")
    }
    println("Done")
}