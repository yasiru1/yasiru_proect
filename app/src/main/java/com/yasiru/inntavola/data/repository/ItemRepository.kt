package com.yasiru.inntavola.data.repository

import com.yasiru.inntavola.data.remote.ItemRemoteDataSource
import com.yasiru.inntavola.utils.performGetOperation
import javax.inject.Inject

class ItemRepository @Inject constructor(
    private val remoteDataSource: ItemRemoteDataSource
) {
    fun getAllItem() = performGetOperation(
        networkCall = { remoteDataSource.getAllItem() }
    )
    fun getItem(id: Int) = performGetOperation(
        networkCall = { remoteDataSource.getItem(id) }
    )
}
