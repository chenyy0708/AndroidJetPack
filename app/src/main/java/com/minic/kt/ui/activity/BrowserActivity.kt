package com.minic.kt.ui.activity

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
import com.minic.kt.databinding.ActivityBrowserBinding

/**
 * @ClassName: BrowserActivity
 * @Description:通用浏览器WebView页面
 * @Author: ChenYy
 * @Date: 2019-05-14 14:45
 */
class BrowserActivity : BaseBrowserActivity<ActivityBrowserBinding>() {
    override fun getLayoutRes(): Int = R.layout.activity_browser

    override fun getStatusLayout(): View = mBinding.webView

    override fun initData(savedInstanceState: Bundle?) {
        super.initData(savedInstanceState)
        initToolbar(mBinding.includeToolbar.toolBar, intent.getStringExtra(BROWSER_TITLE))
        showLoading()
        mBinding.webView.loadUrl(intent.getStringExtra(BROWSER_URL))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_browser, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.share -> showWarning("分享")
            R.id.copy -> showWarning("复制")
            R.id.open_browser -> showWarning("从浏览器打开")
        }
        return true
    }

    override fun getWebView(): WebView = mBinding.webView

    override fun getProgressBar(): ProgressBar? = mBinding.progressHorizontal


}

const val BROWSER_URL = "browser_url"
const val BROWSER_TITLE = "browser_title"