package com.rlamarques.cookinglist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.rlamarques.cookinglist.R
import com.rlamarques.cookinglist.databinding.ActivityAddUpdateDishBinding

class AddUpdateDish : AppCompatActivity() {

    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        
        setContentView(R.layout.activity_add_update_dish)
    }
}