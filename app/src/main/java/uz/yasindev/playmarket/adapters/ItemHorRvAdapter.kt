package uz.yasindev.playmarket.adapters

import android.annotation.SuppressLint
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.yasindev.playmarket.databinding.ItemHorizontalRvBinding
import uz.yasindev.playmarket.models.ItemHorRvModel

class ItemHorRvAdapter : RecyclerView.Adapter<ItemHorRvAdapter.ViewHolder>() {

    private val data = ArrayList<ItemHorRvModel>()
    var itemClickListener: ((url: String) -> Unit)? = null

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<ItemHorRvModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }


    inner class ViewHolder(val binding: ItemHorizontalRvBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(itemHorRvModel: ItemHorRvModel) {
            binding.imageHorRv.load(itemHorRvModel.image)
            binding.appNameHorRv.text = itemHorRvModel.appName
            binding.ratingHorRv.text = itemHorRvModel.rating.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemHorizontalRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindData(data[position])


        holder.binding.root.setOnClickListener {
            itemClickListener?.invoke(data[position].url)
            Log.d("TAGqq", "onBindViewHolder: Clicked")
        }

    }

}