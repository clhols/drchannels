import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.rxkotlin.toObservable
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DrMuReactiveRepositoryTest {
    @Test
    fun testSearch() {
        val context = InstrumentationRegistry.getInstrumentation().context

        DrMuReactiveRepository(context).search("bonderøven")
                .toObservable()
                .flatMap {
                    it.Items.toObservable()
                }
                .subscribe {
                    System.out.println("Got ${it.Title}")
                }
    }
}