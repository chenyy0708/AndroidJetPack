package com.minic.push.base

import android.content.Context


/**
 * 描述: 推送管理类，管理多个Push
 * 作者: ChenYy
 * 日期: 2020-01-03 11:57
 */
class CPushManager : CPush() {

    /**
     * 管理多个Push
     */
    private val pushManager = mutableListOf<CPush>()

    companion object {
        fun getInstance(): CPushManager {
            return SingletonHolder.holder
        }
    }

    private object SingletonHolder {
        val holder = CPushManager()
    }

    /**
     * 添加Push
     */
    fun addPush(push: CPush): CPushManager {
        pushManager.add(push)
        return this
    }

    /**
     * 初始化推送服务
     */
    override fun initPush(context: Context) {
        pushManager.forEach { it.initPush(context) }
    }

    /**
     * 恢复推送服务
     */
    override fun resumePush(context: Context) {
        pushManager.forEach { it.resumePush(context) }
    }

    /**
     * 暂停推送服务
     */
    override fun pausePush(context: Context) {
        pushManager.forEach { it.pausePush(context) }
    }
}