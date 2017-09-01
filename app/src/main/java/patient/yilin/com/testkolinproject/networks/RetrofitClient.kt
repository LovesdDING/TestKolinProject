package patient.yilin.com.testkolinproject.networks

import android.content.Context
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.internal.cache.CacheInterceptor
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/**
 * Created by Administrator on 2017/9/1.
 */


class RetrofitClient private constructor(context:Context,baseUrl:String){
        var httpCacheDirectory: File?=null
        var mContext:Context = context
        var cache:Cache?= null
        var okHttpClient:OkHttpClient ?=null
        var retrofit:Retrofit ?= null
        val DEFAULT_TIMEOUT:Long = 20
        val url = baseUrl

        init {
            //缓存地址
            if(httpCacheDirectory==null){
                httpCacheDirectory = File(mContext.cacheDir,"app_cache")
            }

            try {
                if(cache==null){
                    cache = Cache(httpCacheDirectory,10*1024*1024)
                }
            } catch(e: Exception) {
            }

            //创建 okHttpClient
            okHttpClient = OkHttpClient.Builder()
                    .addNetworkInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .cache(cache)
//                    .addInterceptor(CacheInterceptor(context))
//                    .addNetworkInterceptor(CacheInterceptor(context))
                    .connectTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS)
                    .build()

            //创建  Retrofit
            retrofit = Retrofit.Builder()
                    .client(okHttpClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .baseUrl(url)
                    .build()
        }


}