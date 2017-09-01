package patient.yilin.com.testkolinproject.utils

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.database.Observable
import android.view.Gravity
import android.widget.Toast
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by Administrator on 2017/9/1.
 */


fun  Context.showToast(message:String):Toast{
    var toast:Toast = Toast.makeText(this,message,Toast.LENGTH_SHORT)
    toast.setGravity(Gravity.CENTER,0,0)
    toast.show()
    return toast
}

inline fun <reified T:Activity> Activity.newIntent(){
    val intent = Intent(this,T::class.java)
    startActivity(intent)
}


//fun <T> Observable<T>.applySchedulers(): Observable<T> {
//    return  subscribeOn(Schedulers.io()).
//            unsubscribeOn(Schedulers.io()).
//            observeOn(AndroidSchedulers.mainThread())
//}