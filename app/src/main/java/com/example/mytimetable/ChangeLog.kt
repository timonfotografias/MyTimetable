package com.timonfotografias.mytimetable

import android.content.Intent
import android.content.pm.ActivityInfo
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import kotlinx.android.synthetic.main.activity_change_log.*

class ChangeLog : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change_log)
        textoChangelog.setText(Html.fromHtml(getString(R.string.changelog)))

        storeChangelog.setOnClickListener {
            val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(
                "https://play.google.com/store/apps/details?id=com.timonfotografias.mytimetable")
            setPackage("com.android.vending")
            }
            startActivity(intent) }

        continuarChangelog.setOnClickListener {
            //val changelogActivity = Intent(this, semestre2::class.java)
            //startActivity(changelogActivity)
            finish()
        }
    }
}
