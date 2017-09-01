package patient.yilin.com.testkolinproject

import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.gyf.barlibrary.ImmersionBar
import kotlinx.android.synthetic.main.activity_index.*
import patient.yilin.com.testkolinproject.utils.showToast
import java.util.*

class IndexActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_index)
        ImmersionBar.with(this)
                .transparentBar()    //透明状态栏和导航栏
                .barAlpha(0.3f)    //状态栏和导航栏透明度 设置
                .fitsSystemWindows(true)   //解决状态栏和布局 重叠问题   当为true 时  一定要指定statusBarColor  不然状态栏为透明色
                .init()   //初始化 才开始调用
        setRadionButton()
        initToolbar()
        initFragment(savedInstanceState)

    }

    private fun initFragment(savedInstanceState: Bundle?) {

    }

    private fun initToolbar() {
        var today = getToday()
        tv_bar_title.text = today
        tv_bar_title.typeface = Typeface.createFromAsset(this.assets,"fonts/Lobster-1.4.otf")   //this  IndexActivity
        iv_search.setOnClickListener {
            if(rb_mine.isChecked){
                //点击设置
                showToast("Index 首页 欢迎光临")  //调用utils 封装的工具  utils工具类 可以直接写方法
            }else{

            }
        }
    }

    private fun getToday(): String {
        var list = arrayOf("Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday")
        var data:Date = Date()
        var calendar:Calendar = Calendar.getInstance()
        calendar.time = data
        var index:Int = calendar.get(Calendar.DAY_OF_WEEK)-1
        if(index<0){
            index = 0
        }
        return list[index]
    }

    private fun setRadionButton() {

    }
}
