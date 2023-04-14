package com.yasiru.inntavola.ui.itemdetail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.switchMap
import com.yasiru.inntavola.data.entities.ItemList
import com.yasiru.inntavola.data.repository.ItemRepository
import com.yasiru.inntavola.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemDetailViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    private val _id = MutableLiveData<Int>()

    private val _item = _id.switchMap { id ->
        repository.getItem(id)
    }

    val item: LiveData<Resource<ItemList>> = _item

    fun start(id: Int) {
        _id.value = id
    }
}
