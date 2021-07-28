package com.rlamarques.cookinglist.model.database

import androidx.annotation.WorkerThread
import com.rlamarques.cookinglist.model.entities.FavDish

class FavDishRepository(private val favDishDao: FavDishDao) {

    @WorkerThread
    suspend fun insertFavDishData(favDish: FavDish) {
        favDishDao.insertFavDishDetails(favDish)
    }
}