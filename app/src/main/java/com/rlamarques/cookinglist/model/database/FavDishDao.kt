package com.rlamarques.cookinglist.model.database

import androidx.room.Dao
import androidx.room.Insert
import com.rlamarques.cookinglist.model.entities.FavDish

@Dao
interface FavDishDao {

    @Insert
    suspend fun insertFavDishDetails(favDish: FavDish)
}