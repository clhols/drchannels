import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.rxkotlin.toObservable
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DrMuReactiveRepositoryTest {
    @Test
    fun testSearch() {
        val context = InstrumentationRegistry.getInstrumentation().context

        DrMuReactiveRepository(context).search("Tæt på sandheden")
                .toObservable()
                .flatMap {
                    it.Items.toObservable()
                }
                .subscribe {
                    System.out.println("Got ${it.Title}")
                }
    }
}