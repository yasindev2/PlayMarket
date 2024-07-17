package uz.yasindev.playmarket.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import uz.yasindev.playmarket.databinding.ItemLinearRvBinding
import uz.yasindev.playmarket.databinding.ItemLinearRvForTabBinding
import uz.yasindev.playmarket.models.ItemHorRvModel
import uz.yasindev.playmarket.models.LinearRvModel
import uz.yasindev.playmarket.models.TabItemModel

class LinearRvAdapter(val context: Context) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val data = ArrayList<LinearRvModel>()
    private var a = 0;

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<LinearRvModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemLinearRvBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bindData(linearRvModel: LinearRvModel, position: Int) {
            val itemHorRvAdapter = ItemHorRvAdapter()

            binding.categoryTv.text = linearRvModel.category

            itemHorRvAdapter.setData(linearRvModel.apps )
            binding.horizontalRv.adapter = itemHorRvAdapter

            itemHorRvAdapter.itemClickListener = { url ->
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                context.startActivity(intent)
            }


        }

    }

    inner class ViewHolder1(private val binding: ItemLinearRvForTabBinding):RecyclerView.ViewHolder(binding.root){

//        fun bindData(tabItemModel: LinearRvModel){
//            binding.imgViewTabItem.load(tabItemModel.image)
//            binding.appNameTabItem.text = tabItemModel.appName
//            binding.ratingTabItem.text = tabItemModel.rating.toString()
//        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(a){
            0-> ViewHolder(
                ItemLinearRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
            else->ViewHolder1(
                ItemLinearRvForTabBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
      when(a){
          0-> ( holder as ViewHolder ).bindData(data[position], position)
//          else-> ( holder as ViewHolder1 ).bindData(data[position])
      }
    }

}