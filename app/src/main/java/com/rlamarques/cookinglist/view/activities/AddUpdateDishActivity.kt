package com.rlamarques.cookinglist.view.activities

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.rlamarques.cookinglist.R
import com.rlamarques.cookinglist.databinding.ActivityAddUpdateDishBinding
import com.rlamarques.cookinglist.databinding.DialogCustomImageSelectionBinding

class AddUpdateDishActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var mBinding: ActivityAddUpdateDishBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mBinding = ActivityAddUpdateDishBinding.inflate(layoutInflater)
        setContentView(mBinding.root)

        setupActionBar()

        mBinding.ivAddADishImage.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        v?.apply {
            when(this.id) {
                R.id.iv_add_a_dish_image -> {
                    customImageSelectionDialog()
                }
            }
        }
    }

    private fun setupActionBar() {
        setSupportActionBar(mBinding.addDishToolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        mBinding.addDishToolbar.setNavigationOnClickListener { onBackPressed() }
    }

    private fun customImageSelectionDialog() {
        val dialog = Dialog(this)
        val binding: DialogCustomImageSelectionBinding =
            DialogCustomImageSelectionBinding.inflate(layoutInflater)
        dialog.setContentView(binding.root)
        dialog.show()
    }
}