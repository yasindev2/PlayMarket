package uz.yasindev.playmarket.activities

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.OnTabSelectedListener
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.YouTubePlayer
import com.pierfrancescosoffritti.androidyoutubeplayer.core.player.listeners.YouTubePlayerListener
import uz.yasindev.playmarket.adapters.CardRvAdapter
import uz.yasindev.playmarket.adapters.LinearRvAdapter
import uz.yasindev.playmarket.databinding.ActivityMainBinding
import uz.yasindev.playmarket.models.CardRvModel
import uz.yasindev.playmarket.models.ItemHorRvModel
import uz.yasindev.playmarket.models.LinearRvModel

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val cardRvAdapter = CardRvAdapter()
    private val linearRvAdapter = LinearRvAdapter(this)
    private val cardRvData = ArrayList<CardRvModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        loadCardRvData()
        loadItemHorRvData()
        changeStatusBarIconColor()
        setAdapter()
        loadAction()


    }

    private fun loadItemHorRvData() {
        val itemHorRvData = ArrayList<ItemHorRvModel>()
        itemHorRvData.add(
            ItemHorRvModel(
                1,
                "https://play-lh.googleusercontent.com/ZU9cSsyIJZo6Oy7HTHiEPwZg0m2Crep-d5ZrfajqtsH-qgUXSqKpNA2FpPDTn-7qA5Q=w240-h480-rw",
                "Telegram",
                5.0,
                "https://play.google.com/store/apps/details?id=org.telegram.messenger&hl=ru&gl=US"
            )
        )
        itemHorRvData.add(
            ItemHorRvModel(
                2,
                "https://play-lh.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=w240-h480-rw",
                "WhatsApp Messenger",
                4.3,
                "https://play.google.com/store/apps/details?id=com.whatsapp&hl=ru&gl=US"
            )
        )
        itemHorRvData.add(
            ItemHorRvModel(
                3,
                "https://play-lh.googleusercontent.com/VRMWkE5p3CkWhJs6nv-9ZsLAs1QOg5ob1_3qg-rckwYW7yp1fMrYZqnEFpk0IoVP4LM=s48-rw",
                "Instagram",
                4.9,
                "https://play.google.com/store/apps/details?id=com.instagram.android&hl=ru&gl=US"
            )
        )
        itemHorRvData.add(
            ItemHorRvModel(
                4,
                "https://play-lh.googleusercontent.com/RBUyWdycKSK15xSN6RtUFkmeAiRlb5EFDcERcm_4uPEmr35RqiU2r1Zrn7VZQuKmhmU=w240-h480-rw",
                "Tonkeeper — TON Wallet",
                3.0,
                "https://play.google.com/store/apps/details?id=com.ton_keeper&hl=ru&gl=US"
            )
        )
        itemHorRvData.add(
            ItemHorRvModel(
                5,
                "https://play-lh.googleusercontent.com/tbTCHhShK62A6GTWMD8eU710ALwMyRksrf-b5-b9ITUyjoOht-HZu7Sgp-h3pf06VDuJ=s256-rw",
                "Duolingo: уроки иностранного",
                4.5,
                "https://play.google.com/store/apps/details?id=com.duolingo&hl=ru&gl=US"
            )
        )


        val itemHorRvData1 = ArrayList<ItemHorRvModel>()
        itemHorRvData1.add(
            ItemHorRvModel(
                1,
                "https://play-lh.googleusercontent.com/Wvjx6rVlC1rGWKkln3r-23ICKV--sxEEUuq7jd15BeJan8v-wS7TGwm0NHXqqon18w=s256-rw",
                "Общайтесь и играйте с Discord",
                4.0,
                "https://play.google.com/store/apps/details?id=com.discord&hl=ru&gl=US"
            )
        )
        itemHorRvData1.add(
            ItemHorRvModel(
                2,
                "https://play-lh.googleusercontent.com/mjmbWruxfo8oYHsBNI7b76KLj1AEJQo7hXwlmi05EvfFwubOjo8nQJrVEHRe4Vbgpo8=s256-rw",
                "Видеоредактор и фото - InShot",
                4.3,
                "https://play.google.com/store/search?q=inshot&c=apps&hl=ru&gl=US"
            )
        )
        itemHorRvData1.add(
            ItemHorRvModel(
                3,
                "https://play-lh.googleusercontent.com/T3XmKkZNeJ-2x-lDI4X27Xjdz4yHenOWHUvw_ZZKKYdFtkYSSO4sMK88f9SR1b5vNA=s256-rw",
                "Ultimate Guitar: Аккорды, Табы",
                4.9,
                "https://play.google.com/store/apps/details?id=com.ultimateguitar.tabs&hl=ru&gl=US"
            )
        )
        itemHorRvData1.add(
            ItemHorRvModel(
                4,
                "https://play-lh.googleusercontent.com/QLQzL-MXtxKEDlbhrQCDw-REiDsA9glUH4m16syfar_KVLRXlzOhN7tmAceiPerv4Jg=s256-rw",
                "Twitch: прямые трансляции",
                3.0,
                "https://play.google.com/store/search?q=twitch+%D0%BF%D1%80%D1%8F%D0%BC%D1%8B%D0%B5+%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BB%D1%8F%D1%86%D0%B8%D0%B8&c=apps&hl=ru&gl=US"
            )
        )
        itemHorRvData1.add(
            ItemHorRvModel(
                5,
                "https://play-lh.googleusercontent.com/KxeSAjPTKliCErbivNiXrd6cTwfbqUJcbSRPe_IBVK_YmwckfMRS1VIHz-5cgT09yMo=s256-rw",
                "Snapchat",
                4.5,
                "https://play.google.com/store/apps/details?id=com.snapchat.android&hl=ru&gl=US"
            )
        )


        val itemHorRvData2 = ArrayList<ItemHorRvModel>()
        itemHorRvData2.add(
            ItemHorRvModel(
                1,
                "https://play-lh.googleusercontent.com/ZU9cSsyIJZo6Oy7HTHiEPwZg0m2Crep-d5ZrfajqtsH-qgUXSqKpNA2FpPDTn-7qA5Q=w240-h480-rw",
                "Telegram",
                5.0,
                "https://play.google.com/store/apps/details?id=org.telegram.messenger&hl=ru&gl=US"
            )
        )
        itemHorRvData2.add(
            ItemHorRvModel(
                2,
                "https://play-lh.googleusercontent.com/bYtqbOcTYOlgc6gqZ2rwb8lptHuwlNE75zYJu6Bn076-hTmvd96HH-6v7S0YUAAJXoJN=w240-h480-rw",
                "WhatsApp Messenger",
                4.3,
                "https://play.google.com/store/apps/details?id=com.whatsapp&hl=ru&gl=US"
            )
        )
        itemHorRvData2.add(
            ItemHorRvModel(
                3,
                "https://play-lh.googleusercontent.com/VRMWkE5p3CkWhJs6nv-9ZsLAs1QOg5ob1_3qg-rckwYW7yp1fMrYZqnEFpk0IoVP4LM=s48-rw",
                "Instagram",
                4.9,
                "https://play.google.com/store/apps/details?id=com.instagram.android&hl=ru&gl=US"
            )
        )
        itemHorRvData2.add(
            ItemHorRvModel(
                4,
                "https://play-lh.googleusercontent.com/RBUyWdycKSK15xSN6RtUFkmeAiRlb5EFDcERcm_4uPEmr35RqiU2r1Zrn7VZQuKmhmU=w240-h480-rw",
                "Tonkeeper — TON Wallet",
                3.0,
                "https://play.google.com/store/apps/details?id=com.ton_keeper&hl=ru&gl=US"
            )
        )
        itemHorRvData2.add(
            ItemHorRvModel(
                5,
                "https://play-lh.googleusercontent.com/tbTCHhShK62A6GTWMD8eU710ALwMyRksrf-b5-b9ITUyjoOht-HZu7Sgp-h3pf06VDuJ=s256-rw",
                "Duolingo: уроки иностранного",
                4.5,
                "https://play.google.com/store/apps/details?id=com.duolingo&hl=ru&gl=US"
            )
        )


        val itemHorRvData3 = ArrayList<ItemHorRvModel>()
        itemHorRvData3.add(
            ItemHorRvModel(
                1,
                "https://play-lh.googleusercontent.com/Wvjx6rVlC1rGWKkln3r-23ICKV--sxEEUuq7jd15BeJan8v-wS7TGwm0NHXqqon18w=s256-rw",
                "Общайтесь и играйте с Discord",
                4.0,
                "https://play.google.com/store/apps/details?id=com.discord&hl=ru&gl=US"
            )
        )
        itemHorRvData3.add(
            ItemHorRvModel(
                2,
                "https://play-lh.googleusercontent.com/mjmbWruxfo8oYHsBNI7b76KLj1AEJQo7hXwlmi05EvfFwubOjo8nQJrVEHRe4Vbgpo8=s256-rw",
                "Видеоредактор и фото - InShot",
                4.3,
                "https://play.google.com/store/search?q=inshot&c=apps&hl=ru&gl=US"
            )
        )
        itemHorRvData3.add(
            ItemHorRvModel(
                3,
                "https://play-lh.googleusercontent.com/T3XmKkZNeJ-2x-lDI4X27Xjdz4yHenOWHUvw_ZZKKYdFtkYSSO4sMK88f9SR1b5vNA=s256-rw",
                "Ultimate Guitar: Аккорды, Табы",
                4.9,
                "https://play.google.com/store/apps/details?id=com.ultimateguitar.tabs&hl=ru&gl=US"
            )
        )
        itemHorRvData3.add(
            ItemHorRvModel(
                4,
                "https://play-lh.googleusercontent.com/QLQzL-MXtxKEDlbhrQCDw-REiDsA9glUH4m16syfar_KVLRXlzOhN7tmAceiPerv4Jg=s256-rw",
                "Twitch: прямые трансляции",
                3.0,
                "https://play.google.com/store/search?q=twitch+%D0%BF%D1%80%D1%8F%D0%BC%D1%8B%D0%B5+%D1%82%D1%80%D0%B0%D0%BD%D1%81%D0%BB%D1%8F%D1%86%D0%B8%D0%B8&c=apps&hl=ru&gl=US"
            )
        )
        itemHorRvData3.add(
            ItemHorRvModel(
                5,
                "https://play-lh.googleusercontent.com/KxeSAjPTKliCErbivNiXrd6cTwfbqUJcbSRPe_IBVK_YmwckfMRS1VIHz-5cgT09yMo=s256-rw",
                "Snapchat",
                4.5,
                "https://play.google.com/store/apps/details?id=com.snapchat.android&hl=ru&gl=US"
            )
        )


        val arrayList = ArrayList<LinearRvModel>()
        arrayList.add(LinearRvModel(1, "Top", itemHorRvData))
        arrayList.add(LinearRvModel(2, "Interesting", itemHorRvData1))
        arrayList.add(LinearRvModel(3, "Interesting", itemHorRvData2))
        arrayList.add(LinearRvModel(4, "Interesting", itemHorRvData3))

        linearRvAdapter.setData(arrayList)
    }

    private fun loadAction() {
        cardRvAdapter.installClickListener = { url ->
            val intent = Intent(
                Intent.ACTION_VIEW, Uri.parse(url)
            )
            startActivity(intent)
        }

        binding.linearRv.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                //set the visibility of horizontal RecyclerView base on whether we can scroll upwards (-1 indicates upwards)
                if (recyclerView.canScrollVertically(-1)) {
                    binding.cardRv.visibility = View.GONE
                    binding.tv.visibility = View.GONE
                } else if (!binding.cardRv.isVisible) {
                    binding.cardRv.visibility = View.VISIBLE
                    binding.tv.visibility = View.VISIBLE
                }
            }
        })

        val tabLayout = binding.tabLayout
        tabLayout.addTab(tabLayout.newTab().setText("Home"))
        tabLayout.addTab(tabLayout.newTab().setText("Games"))
        tabLayout.addTab(tabLayout.newTab().setText("Movie"))
        tabLayout.addTab(tabLayout.newTab().setText("Social Media"))
        tabLayout.addTab(tabLayout.newTab().setText("Whether"))

        tabLayout.addOnTabSelectedListener(object : OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                Log.d("TAGkk", "onTabSelected:${tab?.position}")
                when (tab?.position) {
                    0 -> {

                    }

                    1 -> {
//                        binding.linearRv.adapter = todo list adapter

                    }

                    2 -> {

                    }

                    3 -> {

                    }

                    4 -> {

                    }
                }
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Log.d("TAGkk", "onTabUnselected:${tab?.position} ")
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Log.d("TAGkk", "onTabReselected:${tab?.position} ")
            }

        })


    }

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }


    private fun loadCardRvData() {
        cardRvData.add(
            CardRvModel(
                1,
                "czANXAJ5j8I",
                "https://play-lh.googleusercontent.com/LByrur1mTmPeNr0ljI-uAUcct1rzmTve5Esau1SwoAzjBXQUby6uHIfHbF9TAT51mgHm=s48-rw",
                "Clash of Clans",
                4.5,
                "https://play.google.com/store/apps/details?id=com.supercell.clashofclans&hl=ru&gl=US"
            )
        )
        cardRvData.add(
            CardRvModel(
                2,
                "MeRFEtKrtGI",
                "https://play-lh.googleusercontent.com/T8RuSQDFojpFjPvGASy8FUP77fAfRAPbrHcbYg97i2sJ8KTDx_KLfDaTImMbU93-Z4Y=s48-rw",
                "Free Fire MAX",
                4.0,
                "https://play.google.com/store/search?q=free+fire&c=apps&hl=ru&gl=US"
            )
        )
        cardRvData.add(
            CardRvModel(
                3,
                "y0Bm8EIP13g",
                "https://play-lh.googleusercontent.com/Y9BUoMIWfhZDUFZ_MxQmnsgSyb3O8s8Sds65E_j46-vdDSJi_0Xqmoa-fHaQa7fGlw=s48-rw",
                "Angry Birds 2",
                4.8,
                "https://play.google.com/store/apps/details?id=com.rovio.baba&pcampaignid=merch_published_cluster_promotion_battlestar_collection_new_games&hl=ru&gl=US"
            )
        )
        cardRvData.add(
            CardRvModel(
                4,
                "Tx66XQpH8EU",
                "https://play-lh.googleusercontent.com/Uew-Z0cVBLaJF4p9u0HEIXiLU4HKlxJc7z9BN_ypMO4HORIZknsyQHcaJrm7gr4pfm4=s48-rw",
                "Clash Royal",
                4.2,
                "https://play.google.com/store/search?q=clash+royale+clash+royale&c=apps&hl=ru&gl=US"
            )
        )
        cardRvData.add(
            CardRvModel(
                5,
                "3mkmZHd6xK8",
                "https://play-lh.googleusercontent.com/n9CeusCmd-m3uzx8dANuIBorYwG8L5ZbEdkYfVhIn5riLqMiviFPnEuzUveNXLdoVvew=s48-rw",
                "Jeopardy!® Trivia TV Game Show",
                4.4,
                "https://play.google.com/store/search?q=jeopardy&c=apps&hl=ru&gl=US"
            )
        )
    }

    private fun setAdapter() {

        cardRvAdapter.setData(cardRvData)
        binding.cardRv.adapter = cardRvAdapter


        binding.linearRv.adapter = linearRvAdapter


    }

    private fun changeStatusBarIconColor() {
        // Set the status bar icons to dark (light background)
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
    }

    override fun onPause() {
        super.onPause()

    }

}

