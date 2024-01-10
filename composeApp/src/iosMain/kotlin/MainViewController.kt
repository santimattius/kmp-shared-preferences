import androidx.compose.ui.window.ComposeUIViewController
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.santimattius.kmp.skeleton.core.ui.components.createDataStore
import org.koin.dsl.module

fun MainViewController() = ComposeUIViewController { App(iosPlatformModules) }


val iosModule = module {
    single<DataStore<Preferences>> {
        createDataStore()
    }
}

val iosPlatformModules = listOf(iosModule)