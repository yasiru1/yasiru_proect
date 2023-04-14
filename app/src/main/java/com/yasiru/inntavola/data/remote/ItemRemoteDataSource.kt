package com.yasiru.inntavola.data.remote

import javax.inject.Inject

class ItemRemoteDataSource @Inject constructor(
    private val itemService: ItemService
) : BaseDataSource() {
    suspend fun getAllItem() = getResult { itemService.getAllItem() }
    suspend fun getItem(id: Int) = getResult { itemService.getItem(id) }
}
