package com.yasiru.inntavola

import com.yasiru.inntavola.data.entities.Item
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.JUnit4

@RunWith(JUnit4::class)
class ValidationUtilTest {

    @Test
    fun validateDrinkTest() {
        val item = Item(
            id = 1,
            item_name = "Mezzi paccheri polpo e olive nere",
            item_image = "https:\\/\\/scanworld.lk\\/images\\/cotoletta.png",
            item_weight = "300 gr",
            item_description = "Un primo piatto stuzzicante e saporito, il polpo viene prima...\",\"ingredients\":\"Carne avicola (pollo 58%)." +
                    " Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_description_long = "Un piatto evergreen che piace sempre a tutti, dai bambini agli adulti, noi la prepariamo" +
                    " con tenera carne di pollo.\",\"allergies\":\"Contiene: cereali contenenti glutine, uova e prodotti a base di uova.",
            item_ingredients = "Carne avicola (pollo 58%). Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_allergies = "Contiene: cereali contenenti glutine, uova e prodotti a base di uova."
        )
        assertEquals(true, ValidationUtil.validateDrink(item))
    }

    @Test
    fun validateDrinkEmptyTest() {
        val item = Item(
            id = null,item_name = "",item_image = "", item_weight = "",
            item_description = "",item_description_long = "",
            item_ingredients = "",  item_allergies = ""
        )
        assertEquals(false, ValidationUtil.validateDrink(item))
    }

    @Test
    fun validateDrinkIdEmptyTest() {
        val item = Item(
            id = null,
            item_name = "Mezzi paccheri polpo e olive nere",
            item_image = "https:\\/\\/scanworld.lk\\/images\\/cotoletta.png",
            item_weight = "300 gr",
            item_description = "Un primo piatto stuzzicante e saporito, il polpo viene prima...\",\"ingredients\":\"Carne avicola (pollo 58%)." +
                    " Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_description_long = "Un piatto evergreen che piace sempre a tutti, dai bambini agli adulti, noi la prepariamo" +
                    " con tenera carne di pollo.\",\"allergies\":\"Contiene: cereali contenenti glutine, uova e prodotti a base di uova.",
            item_ingredients = "Carne avicola (pollo 58%). Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_allergies = "Contiene: cereali contenenti glutine, uova e prodotti a base di uova."

        )
        assertEquals(false, ValidationUtil.validateDrink(item))
    }

    @Test
    fun validateDrinkNameEmptyTest() {
        val item = Item(
            id = 1,
            item_name = "",
            item_image = "https:\\/\\/scanworld.lk\\/images\\/cotoletta.png",
            item_weight = "300 gr",
            item_description = "Un primo piatto stuzzicante e saporito, il polpo viene prima...\",\"ingredients\":\"Carne avicola (pollo 58%)." +
                    " Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_description_long = "Un piatto evergreen che piace sempre a tutti, dai bambini agli adulti, noi la prepariamo" +
                    " con tenera carne di pollo.\",\"allergies\":\"Contiene: cereali contenenti glutine, uova e prodotti a base di uova.",
            item_ingredients = "Carne avicola (pollo 58%). Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_allergies = "Contiene: cereali contenenti glutine, uova e prodotti a base di uova."
        )
        assertEquals(false, ValidationUtil.validateDrink(item))
    }

    @Test
    fun validateDrinkImageEmptyTest() {
        val item = Item(
            id = 1,
            item_name = "Mezzi paccheri polpo e olive nere",
            item_image = "",
            item_weight = "300 gr",
            item_description = "Un primo piatto stuzzicante e saporito, il polpo viene prima...\",\"ingredients\":\"Carne avicola (pollo 58%)." +
                    " Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_description_long = "Un piatto evergreen che piace sempre a tutti, dai bambini agli adulti, noi la prepariamo" +
                    " con tenera carne di pollo.\",\"allergies\":\"Contiene: cereali contenenti glutine, uova e prodotti a base di uova.",
            item_ingredients = "Carne avicola (pollo 58%). Pangrattato. Misto d'uovo. Farina di frumento. Olio di semi di girasole. Sale.",
            item_allergies = "Contiene: cereali contenenti glutine, uova e prodotti a base di uova."
        )
        assertEquals(false, ValidationUtil.validateDrink(item))
    }
}
