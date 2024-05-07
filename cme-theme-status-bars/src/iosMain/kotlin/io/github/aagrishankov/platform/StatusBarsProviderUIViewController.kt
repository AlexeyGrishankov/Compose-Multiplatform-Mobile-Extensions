package io.github.aagrishankov.platform

import platform.UIKit.UIStatusBarStyle
import platform.UIKit.UIStatusBarStyleDarkContent
import platform.UIKit.UIStatusBarStyleLightContent
import platform.UIKit.UIView
import platform.UIKit.UIViewAutoresizingFlexibleHeight
import platform.UIKit.UIViewAutoresizingFlexibleWidth
import platform.UIKit.UIViewController
import platform.UIKit.addChildViewController
import platform.UIKit.didMoveToParentViewController

internal class StatusBarsProviderUIViewController : UIViewController(nibName = null, bundle = null) {

    internal var isDark: Boolean =
        PreRenderCurrentThemeStatusBars.activeTheme.isDark

    internal var childComposeViewController: UIViewController? = null

    override fun loadView() {
        super.loadView()

        val childComposeViewController = childComposeViewController
            ?: error("Child controller not initialized")

        view = UIView().apply {
            addSubview(
                childComposeViewController.view.apply {
                    setAutoresizingMask(UIViewAutoresizingFlexibleWidth or UIViewAutoresizingFlexibleHeight)
                }
            )
        }
        addChildViewController(childComposeViewController)
        childComposeViewController.didMoveToParentViewController(this)
    }

    override fun preferredStatusBarStyle(): UIStatusBarStyle {
        return if (isDark) UIStatusBarStyleLightContent else UIStatusBarStyleDarkContent
    }
}
