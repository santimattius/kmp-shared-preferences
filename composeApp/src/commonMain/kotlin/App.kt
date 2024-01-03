import androidx.compose.runtime.Composable
import com.santimattius.kmp.skeleton.MainApplication
import com.santimattius.kmp.skeleton.di.applicationModules
import org.koin.compose.KoinApplication
import org.koin.core.module.Module

@Composable
fun App(platformModules: List<Module> = emptyList()) {
    KoinApplication(moduleList = { applicationModules() + platformModules }) {
        MainApplication()
    }
}