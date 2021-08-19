package ir.hsh.searchfoodtask.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import java.io.IOException
import java.io.InputStream
import java.nio.charset.Charset


fun RecyclerView.setVerticalList(context: Context, isReverse: Boolean = false) {
    this.layoutManager = LinearLayoutManager(context, RecyclerView.VERTICAL, isReverse)
}


fun String.toast(context: Context) {
    Toast.makeText(context, this, Toast.LENGTH_SHORT)
        .show()
}

fun View.visible() {
    this.visibility = View.VISIBLE
}

fun View.invisible() {
    this.visibility = View.INVISIBLE
}

fun View.gone() {
    this.visibility = View.GONE
}


fun Activity.toast(msg: String) {
    Toast.makeText(this, msg, Toast.LENGTH_SHORT)
        .show()
}

fun loadJSONFromAsset(context: Context, assetsFileName: String): String? {
    var json: String? = null
    json = try {
        val `is`: InputStream = context.assets.open("$assetsFileName.json")
        val size: Int = `is`.available()
        val buffer = ByteArray(size)
        `is`.read(buffer)
        `is`.close()
        String(buffer, Charset.forName("UTF-8"))
    } catch (ex: IOException) {
        ex.printStackTrace()
        return null
    }
    return json
}
