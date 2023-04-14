package com.yasiru.inntavola.data.remote

import com.yasiru.inntavola.data.entities.ItemList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ItemService {

    @GET("/v1/search.php?s=cotoletta")
    suspend fun getAllItem(): Response<ItemList>

    @GET("/v1/lookup.php")
    suspend fun getItem(@Query("id") id: Int): Response<ItemList>
}
