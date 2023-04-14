package com.yasiru.inntavola.ui.items

import androidx.lifecycle.ViewModel
import com.yasiru.inntavola.data.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ItemsViewModel @Inject constructor(
    private val repository: ItemRepository
) : ViewModel() {

    val itemList = repository.getAllItem()
}
