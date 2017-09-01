package patient.yilin.com.testkolinproject.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Created by Administrator on 2017/9/1.
 */

abstract class BaseFragment : Fragment(){
    var isFirst:Boolean = false
    var rootView:View ?= null  //nullable  赋值 可为空
    var isFragmentVisible:Boolean = false
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if(rootView == null){
            rootView = inflater?.inflate(getLayoutResources(),container,false)
        }
        return rootView
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView()
    }

    override fun setUserVisibleHint(isVisibleToUser: Boolean) {  //fragment  与tab 结合使用的时候 可能需要预加载 延迟加载
        super.setUserVisibleHint(isVisibleToUser)
        if(isVisibleToUser){
            isFragmentVisible = true
        }

        if(rootView==null){
            return
        }

        //可见 并且没有加载过
        if (isFirst&&isFragmentVisible){
            onFragmentVisibleChange(true)
            return
        }

        //可见 ->不可见 加载过
        if(isFragmentVisible){
            onFragmentVisibleChange(false)
            isFragmentVisible = false
        }
    }

    open protected fun onFragmentVisibleChange(b:Boolean){  //open 允许继承  不写open的 默认都是final 无法继承

    }

    abstract fun getLayoutResources():Int

    abstract fun initView()
}
