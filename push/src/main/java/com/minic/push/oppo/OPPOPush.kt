package com.minic.push.oppo

import android.content.Context
import android.util.Log
import com.heytap.mcssdk.PushManager
import com.heytap.mcssdk.callback.PushAdapter
import com.minic.push.base.CPush


/**
 * 描述: OPPO PUSH推送
 * 作者: ChenYy
 * 日期: 2020-01-03 13:49
 */
class OPPOPush : CPush() {

    override fun initPush(context: Context) {
        if (!PushManager.isSupportPush(context)) return
        PushManager.getInstance().register(context, "6ab1f9264c9a4ca4bd538802310b873b", "47a3579c4f604fe495fd0b662d602a0a", object : PushAdapter() {
            override fun onRegister(responseCode: Int, registerID: String?) {
                if (responseCode == 0) {
                    Log.d("OPPOPush", "registerID:${registerID}")
                } else {
                    Log.d("OPPOPush", "OPPOPush init error responseCode:${responseCode}")
                }
            }
        })
    }

    override fun resumePush(context: Context) {
        PushManager.getInstance().resumePush()
    }

    override fun pausePush(context: Context) {
        PushManager.getInstance().pausePush()
    }
}