package com.rlamarques.cookinglist.view.activities

import android.Manifest
import android.app.AlertDialog
import android.app.Dialog
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings
import android.view.View
import android.widget.Toast
import com.karumi.dexter.Dexter
import com.karumi.dexter.MultiplePermissionsReport
import com.karumi.dexter.PermissionToken
import com.karumi.dexter.listener.PermissionRequest
import com.karumi.dexter.listener.multi.MultiplePermissionsListener
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

        binding.tvCamera.setOnClickListener {
            openCamera()
            dialog.dismiss()
        }

        binding.tvGallery.setOnClickListener {
            openGallery()
            dialog.dismiss()
        }

        dialog.show()
    }

    private fun openCamera() {
        Dexter.withContext(this).withPermissions(
            Manifest.permission.CAMERA,
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report?.areAllPermissionsGranted() == true) {
                        Toast.makeText(
                            this@AddUpdateDishActivity,
                            "You have Camera permission",
                            Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        showRationaleDialogForPermission()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    showRationaleDialogForPermission()
                }

            }).onSameThread().check()
    }

    private fun openGallery() {
        Dexter.withContext(this).withPermissions(
            Manifest.permission.READ_EXTERNAL_STORAGE
        ).withListener(object : MultiplePermissionsListener {
                override fun onPermissionsChecked(report: MultiplePermissionsReport?) {
                    if (report?.areAllPermissionsGranted() == true) {
                        Toast.makeText(
                            this@AddUpdateDishActivity,
                            "You have Gallery permission",
                            Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        showRationaleDialogForPermission()
                    }
                }

                override fun onPermissionRationaleShouldBeShown(
                    permissions: MutableList<PermissionRequest>?,
                    token: PermissionToken?
                ) {
                    showRationaleDialogForPermission()
                }

            }).onSameThread().check()
    }

    private fun showRationaleDialogForPermission() {
        AlertDialog.Builder(this).setMessage("We need permissions to access your camera and gallery")
            .setPositiveButton("Grant permission on app settings") { _,_ ->
                try {
                    val intent = Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS)
                    val uri = Uri.fromParts("package", packageName, null)
                    intent.data = uri
                    startActivity(intent)
                } catch (e: ActivityNotFoundException) {
                    e.printStackTrace()
                }
            }
            .setNegativeButton("Cancel") { dialog,_ ->
                dialog.dismiss()
            }.show()
    }
}