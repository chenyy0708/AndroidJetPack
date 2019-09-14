package com.minic.kt.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.minic.base.extens.initToolbar
import com.minic.base.extens.showWarning
import com.minic.base.net.exception.showLoading
import com.minic.kt.R
import com.minic.kt.base.App
import com.minic.kt.databinding.FragmentBrowserBinding
import org.kodein.di.Kodein

/**
 * @ClassName: BrowserFragment
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-09-12 18:14
 */
class BrowserFragment : BaseBrowserFragment<FragmentBrowserBinding>() {
    override val kodein: Kodein
        get() = Kodein.lazy {
            extend(App.INSTANCE.kodein)
        }

    private val args: BrowserFragmentArgs by navArgs()

    override fun getLayoutRes(): Int = R.layout.fragment_browser

    override fun getStatusLayout(): View = mBinding.webView

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        initToolbar(mBinding.includeToolbar.toolBar, args.title)
        val appBarConfiguration = AppBarConfiguration(findNavController().graph)
        mBinding.includeToolbar.toolBar.setupWithNavController(findNavController(), appBarConfiguration)
        showLoading()
        val url = args.url
        mBinding.webView?.loadUrl(url)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_browser, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.share -> showWarning("分享")
            R.id.copy -> showWarning("复制")
            R.id.open_browser -> showWarning("从浏览器打开")
        }
        return true
    }

    override fun getWebView(): WebView = mBinding.webView

    override fun getProgressBar(): ProgressBar? = mBinding.progressHorizontal

}