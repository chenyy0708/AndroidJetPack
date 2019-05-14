package com.minic.kt.ui.activity

import android.annotation.SuppressLint
import android.graphics.Bitmap
import android.net.http.SslError
import android.os.Build
import android.os.Bundle
import android.view.View
import android.webkit.*
import android.widget.ProgressBar
import androidx.databinding.ViewDataBinding
import com.minic.base.base.BaseActivity
import com.minic.base.net.exception.showSuccess

/**
 * @ClassName: BaseBrowserActivity
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-05-14 16:46
 */
abstract class BaseBrowserActivity<VB : ViewDataBinding> : BaseActivity<VB>() {
    abstract fun getWebView(): WebView
    abstract fun getProgressBar(): ProgressBar?

    protected override fun initData(savedInstanceState: Bundle?) {
        initWebViewSettings()
    }

    @SuppressLint("SetJavaScriptEnabled")
    private fun initWebViewSettings() {
        val webSettings = getWebView().settings
        webSettings.javaScriptEnabled = true
        webSettings.layoutAlgorithm = WebSettings.LayoutAlgorithm.NORMAL
        webSettings.domStorageEnabled = true
        webSettings.defaultTextEncodingName = "UTF-8"
        webSettings.allowUniversalAccessFromFileURLs = true//解决js跨域问题
        webSettings.useWideViewPort = true
        webSettings.loadWithOverviewMode = true
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            webSettings.mixedContentMode = WebSettings.MIXED_CONTENT_ALWAYS_ALLOW//解决https页面中有http图片显示不出问题
        }
        getWebView().webViewClient = BaseWebViewClient()
        getWebView().webChromeClient = BaseWebChromeClient()
    }


    inner class BaseWebViewClient : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
            view.loadUrl(url)
            return true
        }

        override fun onReceivedSslError(view: WebView, handler: SslErrorHandler, error: SslError) {
            handler.proceed()  // 接受所有网站的证书
        }

        override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
            getProgressBar()?.visibility = View.VISIBLE
            super.onPageStarted(view, url, favicon)
        }
    }

    inner class BaseWebChromeClient : WebChromeClient() {
        override fun onProgressChanged(view: WebView, progress: Int) {
            getProgressBar()?.progress = progress
            if (progress >= 100) {
                getProgressBar()?.visibility = View.INVISIBLE
                showSuccess()
            }
        }
    }

    override fun onBackPressed() {
        if (getWebView().canGoBack()) {
            getWebView().goBack()
        } else {
            super.onBackPressed()
        }
    }
}