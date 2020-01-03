package com.minic.push.xiaomi

import android.content.Context
import android.util.Log
import com.minic.push.base.CPush
import com.xiaomi.channel.commonutils.logger.LoggerInterface
import com.xiaomi.mipush.sdk.Logger
import com.xiaomi.mipush.sdk.MiPushClient


/**
 * 描述: 小米推送
 * 作者: ChenYy
 * 日期: 2020-01-03 13:49
 */
class XMPush : CPush() {

    override fun initPush(context: Context) {
        if (!isMainProcess(context)) return
        MiPushClient.registerPush(context, "2882303761517135649", "5461713542649")
        val newLogger = object : LoggerInterface {

            override fun setTag(tag: String) {
            }

            override fun log(content: String, t: Throwable) {
                Log.d("XMPush", content, t)
            }

            override fun log(content: String) {
                Log.d("XMPush", content)
            }
        }
        Logger.setLogger(context, newLogger)
    }

    override fun resumePush(context: Context) {
        MiPushClient.resumePush(context.applicationContext, null)
    }

    override fun pausePush(context: Context) {
        MiPushClient.pausePush(context.applicationContext, null)
    }
}