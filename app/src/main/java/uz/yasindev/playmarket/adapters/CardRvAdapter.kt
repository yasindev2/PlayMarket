package uz.yasindev.playmarket.adapters

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.AbstractYouTubePlayerListener
import uz.yasindev.playmarket.databinding.ItemCardRvBinding
import uz.yasindev.playmarket.models.CardRvModel

class CardRvAdapter : RecyclerView.Adapter<CardRvAdapter.ViewHolder>() {

    var installClickListener: ((url: String) -> Unit)? = null

    private val data = ArrayList<CardRvModel>()

    @SuppressLint("NotifyDataSetChanged")
    fun setData(data: ArrayList<CardRvModel>) {
        this.data.clear()
        this.data.addAll(data)
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val binding: ItemCardRvBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindData(cardRvModel: CardRvModel) {

            binding.cardRvVideo.addYouTubePlayerListener(object :
                AbstractYouTubePlayerListener() {
                override fun onReady(youTubePlayer: YouTubePlayer) {
                    val videoId = cardRvModel.youTubeLink
                    youTubePlayer.cueVideo(videoId, 0f)
                }
            })

            binding.cardRvRating.text = cardRvModel.rating.toString()

            binding.cardRvInstall.setOnClickListener {
                installClickListener?.invoke(cardRvModel.installLink)
            }

            binding.cardRvAppName.text = cardRvModel.appName

            binding.appImage.load(cardRvModel.appImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(
            ItemCardRvBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.bindData(data[position])

    }
}
