package com.timonfotografias.mytimetable

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Intent
import android.content.pm.ActivityInfo
import android.provider.CalendarContract.Events
import android.provider.CalendarContract
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.core.app.NotificationCompat




class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        addExam.setOnClickListener { addExam() }

        recreo.setOnClickListener { recreo("10:45", "11:15") }

        tipo1.setOnClickListener { mostrarDatos("8:15", "9:55", 9, "") }
        tipo2.setOnClickListener { mostrarDatos("9:55", "10:45", 8, "bis") }
        tipo3.setOnClickListener { mostrarDatos("11:15", "12:55", 8, "bis") }

        leng1.setOnClickListener { mostrarDatos("9:55", "10:45", 9, "") }
        leng2.setOnClickListener { mostrarDatos("11:15", "12:55", 9, "") }
        leng3.setOnClickListener { mostrarDatos("11:15", "12:55", 9, "") }

        empr1.setOnClickListener { mostrarDatos("12:55", "14:35", 2, "") }
        empr2.setOnClickListener { mostrarDatos("9:55", "10:45", 8, "") }
        empr3.setOnClickListener { mostrarDatos("11:15", "12:05", 8, "") }

        foto1.setOnClickListener { mostrarDatos("8:15", "10:45", 12, "") }
        foto2.setOnClickListener { mostrarDatos("8:15", "9:55", 5, "") }

        fund1.setOnClickListener { mostrarDatos("12:55", "14:35", 13, "") }
        fund2.setOnClickListener { mostrarDatos("8:15", "9:55", 7, "") }

        dis1.setOnClickListener { mostrarDatos("8:15", "9:55", 3, "") }
        dis2.setOnClickListener { mostrarDatos("9:55", "10:45", 11, "") }
        dis3.setOnClickListener { mostrarDatos("11:15", "11:30", 11, "") }

    }

    fun recreo(inicio : String, final : String){
        Toast.makeText(applicationContext, "$inicio - $final", Toast.LENGTH_LONG)
            .show()
    }

    fun mostrarDatos(inicio : String, final : String, aula : Int, extra : String){
        Toast.makeText(applicationContext, "$inicio - $final, en el aula: $aula $extra", Toast.LENGTH_LONG)
            .show()
    }

    fun addExam (){
        val intent = Intent(Intent.ACTION_INSERT)
            .setData(Events.CONTENT_URI)
            .putExtra(Events.EVENT_LOCATION, "easda")
            .putExtra(Events.AVAILABILITY, Events.AVAILABILITY_BUSY)
        startActivity(intent)
    }

}