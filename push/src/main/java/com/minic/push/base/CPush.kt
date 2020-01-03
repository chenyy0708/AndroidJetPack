package com.minic.push.base

import android.app.ActivityManager
import android.content.Context
import android.os.Process


/**
 * 描述:
 * 作者: ChenYy
 * 日期: 2020-01-03 13:43
 */
abstract class CPush {
    /**
     * 初始化推送服务
     */
    abstract fun initPush(context: Context)

    /**
     * 恢复推送服务
     */
    abstract fun resumePush(context: Context)

    /**
     * 暂停推送服务
     */
    abstract fun pausePush(context: Context)

    protected fun isMainProcess(context: Context): Boolean {
        val am = context.getSystemService(Context.ACTIVITY_SERVICE) as ActivityManager
        val processInfos = am.runningAppProcesses
        val mainProcessName = context.packageName
        val myPid = Process.myPid()
        if (processInfos != null && processInfos.isNotEmpty()) {
            for (info in processInfos) {
                if (info.pid == myPid && mainProcessName == info.processName) {
                    return true
                }
            }
        }
        return false
    }
}