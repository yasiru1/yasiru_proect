package com.yasiru.inntavola.data.entities

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id") val id: Int?,
    @SerializedName("name") val item_name: String,
    @SerializedName("image") val item_image: String,
    @SerializedName("weight") val item_weight: String,
    @SerializedName("description") val item_description: String,
    @SerializedName("description_long") val item_description_long: String,
    @SerializedName("ingredients") val item_ingredients: String,
    @SerializedName("allergies") val item_allergies: String
)
