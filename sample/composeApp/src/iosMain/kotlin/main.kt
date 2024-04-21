import com.cme.platform.StatusBarsProviderUIViewController
import org.company.app.App
import platform.UIKit.UIViewController

fun MainViewController(): UIViewController {
    return StatusBarsProviderUIViewController { App() }
}

