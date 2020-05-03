import dk.youtec.drapi.DrMuRepository
import kotlinx.coroutines.runBlocking
import libui.ktx.*

fun main(args: Array<String>) {
    val repo = DrMuRepository()

    appWindow(
            title = "DR api",
            width = 320,
            height = 240
    ) {
        lateinit var scroll: TextArea
        vbox {
            button("Get channels") {
                action {
                    runBlocking {
                        val channels = repo.getScheduleNowNext()
                        channels.filter { it.now != null }.forEach {
                            scroll.append("Channel ${it.channelSlug} showing ${it.now?.title}\n")
                        }
                    }
                }
            }
            scroll = textarea {
                readonly = true
                stretchy = true
            }
        }
    }
}
