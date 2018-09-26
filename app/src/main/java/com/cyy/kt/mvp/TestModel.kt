package com.cyy.kt.mvp

import com.cyy.base.rx.applySchedulers
import com.cyy.kt.bean.DouBanBook
import com.cyy.kt.bean.MeizhiData
import com.cyy.kt.net.NetManager
import io.reactivex.Observable

/**
 * @author       :ChenYangYi
 * @date         :2018/07/24/15:29
 * @description  :
 * @github       :https://github.com/chenyy0708
 */
class TestModel : TestContract.Model {
    override fun getDouBanBook(): Observable<DouBanBook> {
        return NetManager.getInstance().getDouBan()
                .getDouBanBook()
                .compose(applySchedulers())
    }

    override fun getMeizhi(): Observable<MeizhiData> {
        return NetManager.getInstance().getGank()
                .getMeiZhi()
                .compose(applySchedulers())
    }
}