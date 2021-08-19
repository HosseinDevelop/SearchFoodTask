package ir.hsh.searchfoodtask.ui.component

import android.content.Context
import android.os.Build
import android.text.Editable
import android.text.Html
import android.text.TextWatcher
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import ir.hsh.searchfoodtask.databinding.ViewSearchBinding


class SearchView : LinearLayout {

    private lateinit var binding: ViewSearchBinding

    constructor(context: Context?) : super(context) {
        initialize(context)
    }

    constructor(context: Context?, attrs: AttributeSet?) : super(context, attrs) {
        initialize(context, attrs)
    }

    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        initialize(context, attrs)
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    constructor(context: Context?, attrs: AttributeSet?, defStyleAttr: Int, defStyleRes: Int) : super(context, attrs, defStyleAttr, defStyleRes) {
        initialize(context, attrs)
    }

    private fun initialize(context: Context?, attrs: AttributeSet? = null) {
        binding = ViewSearchBinding.inflate(LayoutInflater.from(context), this, true)


    }

    fun setHint(location: String) {
        val sourceString = "<b>search food</b> near <b>$location</b>"
        binding.editText.hint = Html.fromHtml(sourceString)
    }

    fun onSearchTextWatcher(watch: (text: String) -> Unit) {
        binding.editText.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                watch(s.toString())
            }

            override fun afterTextChanged(s: Editable?) {

            }
        })

    }


}