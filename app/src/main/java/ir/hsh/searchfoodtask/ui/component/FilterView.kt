package ir.hsh.searchfoodtask.ui.component

import android.content.Context
import android.os.Build
import android.text.Html
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import androidx.annotation.RequiresApi
import ir.hsh.searchfoodtask.databinding.ViewFilterBinding


class FilterView : LinearLayout {

    private lateinit var binding: ViewFilterBinding

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
        binding = ViewFilterBinding.inflate(LayoutInflater.from(context), this, true)



    }

}