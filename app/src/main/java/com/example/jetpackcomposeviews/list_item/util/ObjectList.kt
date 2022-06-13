package com.example.jetpackcomposeviews.list_item.util

import com.example.jetpackcomposeviews.list_item.model.Data

object ObjectList {
    fun getDataList(): List<Data> {
        return listOf(
            Data("Apple", 1),
            Data("Bananas", 2),
            Data("Cherries", 3),
            Data("Damson plum", 4),
            Data("Elderberry", 5),
            Data("Finger Lime", 6),
            Data("Grapefruit", 7),
            Data("Honeydew Melon", 8),
            Data("Indonesian Lime", 9),
            Data("Jack Fruit", 10),
            Data("Kaffir Lime", 11),
            Data("Longan, Lychee", 12),
            Data("Mandarin Orange", 13),
            Data("Navel Orange", 14),
            Data("Oval Kumquat", 15),
        )
    }
}