import androidx.compose.ui.window.ComposeUIViewController
import com.russhwolf.settings.NSUserDefaultsSettings
import com.russhwolf.settings.Settings
import org.koin.dsl.module
import platform.Foundation.NSUserDefaults

fun MainViewController() = ComposeUIViewController { App(iosPlatformModules) }


val iosModule = module {
    single<Settings> {
        NSUserDefaultsSettings(NSUserDefaults.standardUserDefaults)
    }
}

val iosPlatformModules = listOf(iosModule)