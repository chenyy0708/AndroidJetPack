package com.minic.base.net.exception

import androidx.databinding.ViewDataBinding
import android.widget.TextView
import com.minic.base.R
import com.minic.base.base.BaseActivity
import com.minic.base.base.BaseFragment
import com.minic.base.callback.ErrorCallback
import com.minic.base.callback.LoadingCallback
import java.net.UnknownHostException

/**
 * @author       :ChenYangYi
 * @date         :2018/10/08/16:42
 * @description  :
 * @github       :https://github.com/chenyy0708
 */


fun <VB : ViewDataBinding> BaseFragment<VB>.doError(throwable: Throwable?) {
    when (throwable) {
        is UnknownHostException -> showError()
        is CException -> showError(throwable.msg)
        else -> showError()
    }
}

/**
 * 多状态布局切换
 */
fun <VB : ViewDataBinding> BaseFragment<VB>.showSuccess() = mLoadService.showSuccess()

fun <VB : ViewDataBinding> BaseFragment<VB>.showLoading() = mLoadService.showCallback(LoadingCallback::class.java)
fun <VB : ViewDataBinding> BaseFragment<VB>.showError() = mLoadService.showCallback(ErrorCallback::class.java)
fun <VB : ViewDataBinding> BaseFragment<VB>.showError(msg: String) {
    mLoadService.setCallBack(ErrorCallback::class.java) { _, view ->
        val tvMsg = view.findViewById<TextView>(R.id.tv_message)
        tvMsg.text = msg
    }
    mLoadService.showCallback(ErrorCallback::class.java)
}


fun <VB : ViewDataBinding> BaseActivity<VB>.showSuccess() = mLoadService.showSuccess()
fun <VB : ViewDataBinding> BaseActivity<VB>.showLoading() = mLoadService.showCallback(LoadingCallback::class.java)
fun <VB : ViewDataBinding> BaseActivity<VB>.showError() = mLoadService.showCallback(ErrorCallback::class.java)
fun <VB : ViewDataBinding> BaseActivity<VB>.showError(msg: String) {
    mLoadService.setCallBack(ErrorCallback::class.java) { _, view ->
        val tvMsg = view.findViewById<TextView>(R.id.tv_message)
        tvMsg.text = msg
    }
    mLoadService.showCallback(ErrorCallback::class.java)
}

