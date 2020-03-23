package com.example.studentportal

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity

import kotlinx.android.synthetic.main.activity_add_portal.*
import kotlinx.android.synthetic.main.content_add_portal.*
import kotlinx.android.synthetic.main.content_main.*


const val NEW_PORTAL = "NEW_PORTAL"

class AddPortal : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_portal)
        setSupportActionBar(toolbar)

        initViews()
    }

    private fun initViews() {
        fab.setOnClickListener { onSaveClick() }
    }

    private fun onSaveClick() {
        if (inputPortal.text.toString().isNotBlank() && inputUrl.text.toString().isNotBlank()){
            val newPortal = PortalData(inputPortal.text.toString(), inputUrl.text.toString())
            val resultIntent = Intent()
            resultIntent.putExtra(NEW_PORTAL, newPortal)
            setResult(Activity.RESULT_OK, resultIntent)

            finish()
        } else {
            Toast.makeText(this,"The fields cannot be empty", Toast.LENGTH_SHORT).show()
        }
    }
}

