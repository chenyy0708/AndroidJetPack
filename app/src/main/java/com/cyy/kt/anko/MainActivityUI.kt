package com.cyy.kt.anko

import android.widget.TextView
import com.cyy.kt.MainActivity
import com.cyy.kt.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * @author       :ChenYangYi
 * @date         :2018/07/26/16:31
 * @description  :
 * @github       :https://github.com/chenyy0708
 */


class MainActivityUI : AnkoComponent<MainActivity> {
    lateinit var tv_home: TextView
    override fun createView(ui: AnkoContext<MainActivity>) = with(ui) {
        relativeLayout {
            button("Left") {
                onClick { ui.owner.getMeizhi() }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentLeft()
            }
            button("right") {
                onClick { ui.owner.getDouBanBook() }
            }.lparams(width = wrapContent, height = wrapContent) {
                alignParentRight()
            }

            tv_home = textView {
                id = R.id.tv_home
            }.lparams(width = matchParent, height = matchParent) {
                topMargin = dip(40)
            }
        }
    }

}