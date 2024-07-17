package uz.yasindev.playmarket.models

import java.util.ArrayList

data class LinearRvModel(
    val id:Int,
    val category:String,
    val apps:ArrayList<ItemHorRvModel>,
//    val image:String,
//    val appName:String,
//    val rating:Double
)
