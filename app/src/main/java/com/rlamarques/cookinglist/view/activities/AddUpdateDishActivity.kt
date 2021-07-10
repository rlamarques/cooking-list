package com.rlamarques.cookinglist.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rlamarques.cookinglist.R
import com.rlamarques.cookinglist.databinding.ActivityAddUpdateDishBinding

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupActionBar()

        mBinding.ivAddADishImage.setOnClickListener(this)
    }

    private fun setupActionBar() {
        setSupportActionBar(mBinding.addDishToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.addDishToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    override fun onClick(v: View?) {
        v?.apply {
            when(this.id) {
                R.id.iv_add_a_dish_image -> {
                    Toast.makeText(this@AddUpdateDishActivity, "Clicked add a image", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}