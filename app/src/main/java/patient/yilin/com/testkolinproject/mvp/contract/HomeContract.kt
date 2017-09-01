package patient.yilin.com.testkolinproject.mvp.contract

import patient.yilin.com.testkolinproject.base.BasePresenter
import patient.yilin.com.testkolinproject.base.BaseView
import patient.yilin.com.testkolinproject.mvp.model.HomeBean

/**
 * Created by Administrator on 2017/9/1.
 */

interface HomeContract{
    interface View:BaseView<Presenter>{
        fun setData(bean: HomeBean)
    }

    interface Presenter:BasePresenter{
        fun RequestData()
    }
}
