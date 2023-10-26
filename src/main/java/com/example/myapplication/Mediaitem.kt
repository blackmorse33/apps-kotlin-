package com.example.myapplication

import com.example.myapplication.Mediaitem.Type

data class Mediaitem(
    val id: Int,
    val title: String,
    val thumb: String,
    val type: Type

){
    enum class Type { PHOTO, VIDEO}

}

fun getMedia() = (1..10).map{
    Mediaitem(
        id = it,
        title = "Title $it",
        thumb = "https://th.bing.com/th/id/OIP.MZp58Kco47NlVTzB-y6KhQHaFj?pid=ImgDet&rs=1",
        type = if(it % 2 == 0) Type.PHOTO else Type.VIDEO
    )
}