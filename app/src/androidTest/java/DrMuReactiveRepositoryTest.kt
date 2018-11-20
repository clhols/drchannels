import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import dk.youtec.drapi.ProgramCard
import dk.youtec.drchannels.DrApplication
import dk.youtec.drchannels.backend.DrMuReactiveRepository
import io.reactivex.observers.TestObserver
import io.reactivex.rxkotlin.toObservable
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
open class DrMuReactiveRepositoryTest {
    @Test
    fun testSearch() {
        val context: DrApplication = ApplicationProvider.getApplicationContext()
        val testObserver = TestObserver<ProgramCard>()

        val title = "Tæt på sandheden"
        DrMuReactiveRepository(context).search(title)
                .toObservable()
                .flatMap {
                    it.Items.toObservable()
                }
                .subscribe(testObserver)

        testObserver.awaitCount(1)
        testObserver.assertComplete()
        testObserver.assertValueAt(0) {
            it.SeriesTitle == title
        }
    }
}