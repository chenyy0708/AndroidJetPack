package com.minic.push.xiaomi

import android.content.Context
import android.util.Log
import com.xiaomi.mipush.sdk.MiPushClient
import com.xiaomi.mipush.sdk.MiPushCommandMessage
import com.xiaomi.mipush.sdk.MiPushMessage
import com.xiaomi.mipush.sdk.PushMessageReceiver


/**
 * 描述: 小米推送接受广播
 * 作者: ChenYy
 * 日期: 2020-01-03 14:51
 */
class XMPushReceiver : PushMessageReceiver() {
    /**
     * 接收到消息
     */
    override fun onNotificationMessageArrived(context: Context?, message: MiPushMessage?) {
        super.onNotificationMessageArrived(context, message)
    }

    /**
     * 点击通知
     */
    override fun onNotificationMessageClicked(context: Context?, message: MiPushMessage?) {
        super.onNotificationMessageClicked(context, message)
    }

    /**
     * 用来接收客户端向服务器发送命令消息后返回的响应
     *
     *
     */
    override fun onCommandResult(context: Context?, miPushCommandMessage: MiPushCommandMessage?) {
        super.onCommandResult(context, miPushCommandMessage)
        val command = miPushCommandMessage?.command
        val arguments = miPushCommandMessage?.commandArguments
        if (arguments != null && MiPushClient.COMMAND_REGISTER == command && arguments.size == 1) {
            val regId = arguments[0]
            Log.d("XMPush", "registerID:${regId}")
        }
    }
}