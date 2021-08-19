package ir.hsh.searchfoodtask.utils

import android.util.Log
import ir.hsh.searchfoodtask.BuildConfig

fun logi(msg: String) {
    if (BuildConfig.DEBUG) {
        Log.i("APP_DEBUG", msg)
    }
}

fun loge(msg: String) {
    if (BuildConfig.DEBUG) {
        Log.e("APP_DEBUG", msg)
    }
}

fun logd(msg: String) {
    if (BuildConfig.DEBUG) {
        Log.d("APP_DEBUG", msg)
    }
}

fun logw(msg: String) {
    if (BuildConfig.DEBUG) {
        Log.w("APP_DEBUG", msg)
    }
}

fun logv(msg: String) {
    if (BuildConfig.DEBUG) {
        Log.v("APP_DEBUG", msg)
    }
}
