package com.timonfotografias.mytimetable

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_bienvenida.*
import kotlinx.android.synthetic.main.activity_change_log.*

class bienvenida : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bienvenida)

        continuarBienvenida.setOnClickListener {
            //val changelogActivity = Intent(this, semestre2::class.java)
            //startActivity(changelogActivity)
            finish()
        }

        storeBienvenida.setOnClickListener {
            val intent2 = Intent(Intent.ACTION_VIEW).apply {
                data = Uri.parse(
                    "https://play.google.com/store/apps/details?id=com.timonfotografias.mytimetable")
                setPackage("com.android.vending")
            }
            startActivity(intent2)
        }

    }
}
