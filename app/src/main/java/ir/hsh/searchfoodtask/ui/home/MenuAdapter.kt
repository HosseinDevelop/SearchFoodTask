package ir.hsh.searchfoodtask.ui.home

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.RequestBuilder
import ir.hsh.searchfoodtask.data.model.MenuModelItem
import ir.hsh.searchfoodtask.databinding.ItemLayoutMenuBinding
import java.util.*
import javax.inject.Inject

class MenuAdapter @Inject constructor(val context: Context, private val glide: RequestBuilder<Drawable>) : RecyclerView.Adapter<MenuAdapter.MainViewHolder>() {

    private var data: List<MenuModelItem> = ArrayList()
    private lateinit var click: (id: String?, title: String) -> Unit
    fun setOnClick(click: (id: String?, title: String) -> Unit) {
        this.click = click
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainViewHolder {
        val binding = ItemLayoutMenuBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MainViewHolder(binding)
    }

    override fun getItemCount() = data.size

    override fun onBindViewHolder(holder: MainViewHolder, position: Int) = holder.bind(data[position], position)

    fun swapData(data: List<MenuModelItem>) {
        this.data = data
        notifyDataSetChanged()
    }

    inner class MainViewHolder(val binding: ItemLayoutMenuBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: MenuModelItem, position: Int) = with(itemView) {

            binding.apply {
                txtTitle.text = item.title
                txtRate.text = item.rate.toString()
                txtPrice.text = "$${item.price} delivery"
                txtPreparation.text = "${item.preparation} min"
                glide.load(item.image)
                    .into(imgCover)
            }
            setOnClickListener {
                click(item.id, item.title.toString())
            }
        }
    }
}