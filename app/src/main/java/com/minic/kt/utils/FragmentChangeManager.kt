package com.minic.kt.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

/**
 * @ClassName: FragmentChangeManager
 * @Description:
 * @Author: ChenYy
 * @Date: 2019-08-02 17:41
 */
class FragmentChangeManager(private val mFragmentManager: FragmentManager, private val mContainerViewId: Int, private val mFragments: List<Fragment>) {
    /** 当前选中的Tab  */
    private var mCurrentTab: Int = 0

    init {
        initFragments()
    }

    /** 初始化fragments  */
    private fun initFragments() {
        for (fragment in mFragments) {
            mFragmentManager.beginTransaction().add(mContainerViewId, fragment).hide(fragment).commit()
        }
        setFragments(0)
    }

    /** 界面切换控制  */
    fun setFragments(index: Int) {
        for (i in 0 until mFragments.size) {
            val ft = mFragmentManager.beginTransaction()
            val fragment = mFragments[i]
            if (i == index) {
                ft.show(fragment)
            } else {
                ft.hide(fragment)
            }
            ft.commit()
        }
        mCurrentTab = index
    }

    fun getCurrentTab(): Int {
        return mCurrentTab
    }

    fun getCurrentFragment(): Fragment {
        return mFragments[mCurrentTab]
    }
}