package com.minic.kt.ui.activity.common

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.webkit.WebView
import android.widget.ProgressBar
import com.minic.base.extens.initToolbar
import com.minic.base.extens.showWarning
import com.minic.base.net.exception.showLoading
import com.minic.kt.R
import com.minic.kt.databinding.FragmentBrowserBinding

/**
 * @ClassName: BrowserActivity
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-09-12 18:14
 */
class BrowserActivity : BaseBrowserActivity<FragmentBrowserBinding>() {
    override fun getLayoutRes(): Int = R.layout.fragment_browser

    override fun getStatusLayout(): View = mBinding.webView

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        initToolbar(mBinding.includeToolbar.toolBar, intent.getStringExtra("title")!!)
        showLoading()
        val url = intent.getStringExtra("url")!!
        mBinding.webView?.loadUrl(url)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_browser, menu)
        return super.onCreateOptionsMenu(menu)
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