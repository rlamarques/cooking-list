package com.rlamarques.cookinglist.utils

object Constants {
    const val DISH_TYPE: String = "DishType"
    const val DISH_CATEGORY: String = "DishCategory"
    const val DISH_COOKING_TIME: String = "DishCookingTime"

    /**
     * This function will return the Dish Type List items.
     */
    fun dishTypes(): List<String> {
        return listOf(
            "breakfast",
            "lunch",
            "snacks",
            "dinner",
            "salad",
            "side dish",
            "dessert",
            "other")
    }

    /**
     *  This function will return the Dish Category list items.
     */
    fun dishCategories(): List<String> {
        return listOf(
            "Pizza",
            "BBQ",
            "Bakery",
            "Burger",
            "Cafe",
            "Chicken",
            "Dessert",
            "Drinks",
            "Hot Dogs",
            "Juices",
            "Sandwich",
            "Tea & Coffee",
            "Wraps",
            "Other")
    }

    /**
     *  This function will return the Dish Cooking Time list items. The time added is in Minutes.
     */
    fun dishCookTime(): List<String> {
        return listOf(
            "10",
            "15",
            "20",
            "30",
            "45",
            "50",
            "60",
            "90",
            "120",
            "150",
            "180",)
    }
}