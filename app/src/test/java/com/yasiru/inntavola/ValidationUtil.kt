package com.yasiru.inntavola

import com.yasiru.inntavola.data.entities.Item

object ValidationUtil {

    fun validateDrink(item: Item): Boolean {
        if ((item.id != null) && item.item_name.isNotEmpty() && item.item_weight.isNotEmpty()  && item.item_image.isNotEmpty()
            && item.item_description.isNotEmpty()   && item.item_description_long.isNotEmpty()
            && item.item_ingredients.isNotEmpty()   && item.item_allergies.isNotEmpty()
        ) {
            return true
        }
        return false
    }
}
