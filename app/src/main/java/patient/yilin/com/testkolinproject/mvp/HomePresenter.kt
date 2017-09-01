package patient.yilin.com.testkolinproject.mvp

import android.content.Context
import android.database.Observable
import patient.yilin.com.testkolinproject.mvp.contract.HomeContract
import patient.yilin.com.testkolinproject.mvp.model.HomeBean
import patient.yilin.com.testkolinproject.mvp.model.HomeModel

/**
 * MVP 架构 P
 * Created by Administrator on 2017/9/1.
 */

class HomePresenter(context:Context,view:HomeContract.View):HomeContract.Presenter{

    var mContext:Context?=null
    var mView:HomeContract.View?=null
    val mModel: HomeModel by lazy {
        HomeModel()
    }

    init {
        mView = view
        mContext = context
    }

    override fun start() {
        RequestData()
    }

    override fun RequestData() {
//        val observable:Observable<HomeBean>?= mContext?.let { mModel.loadData(it,true,"0") }
//        observable?.applySchedulers()?.
    }


}