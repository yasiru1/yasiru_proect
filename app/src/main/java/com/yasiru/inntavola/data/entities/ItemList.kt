package com.yasiru.inntavola.data.entities

import com.google.gson.annotations.SerializedName

data class ItemList(
    @SerializedName("drinks") val results: List<Item>
)
