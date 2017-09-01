package patient.yilin.com.testkolinproject

import android.content.Context
import android.content.Intent
import android.graphics.Typeface
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.AlphaAnimation
import android.view.animation.Animation
import android.view.animation.AnimationSet
import android.view.animation.ScaleAnimation
import kotlinx.android.synthetic.main.activity_main.*
/**
 * 仿照 开眼  的kotlin   项目
    assets  文件夹下 存放字体等资源文件

    AS 3.0 之下 ：  不能直接生成 kotlinActivity 只能 先创建java的Activity  然后 转化code为kotlin-Activity
  转换 快捷键： ctrl+shift+alt+k
 * kotlin 语法学习：
 *

 */
class MainActivity : AppCompatActivity() {

    val context:Context = this

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        setAnimation()
    }

    private fun setAnimation() {
        val alphaAnimation = AlphaAnimation(0.1f,1.0f)
        alphaAnimation.duration = 1000
        val  scaleAnimation = ScaleAnimation(0.1f,1.0f,0.1f,1.0f,ScaleAnimation.RELATIVE_TO_SELF,0.5f,ScaleAnimation.RELATIVE_TO_SELF,0.5f)
        scaleAnimation.duration = 1000
        val animationSet = AnimationSet(true)
        animationSet.addAnimation(alphaAnimation)
        animationSet.addAnimation(scaleAnimation)
        animationSet.duration = 1000
        iv_icon_splash.startAnimation(animationSet)
        animationSet.setAnimationListener(object :Animation.AnimationListener{
            override fun onAnimationRepeat(animation: Animation?) {

            }

            override fun onAnimationEnd(animation: Animation?) {
                //页面跳转
                val intent = Intent(context,IndexActivity::class.java)
                startActivity(intent)
                finish()

            }

            override fun onAnimationStart(animation: Animation?) {
//
            }

        })

    }

    private fun initView() {
        //定义变量
        val font:Typeface = Typeface.createFromAsset(this.assets,"fonts/Lobster-1.4.otf")  //取到在assets/fonts 文件夹下的字体资源
        tv_name_english.typeface = font
        tv_english_intro.typeface = font
    }
}
