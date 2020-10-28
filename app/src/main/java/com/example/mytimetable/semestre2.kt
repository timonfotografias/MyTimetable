package com.timonfotografias.mytimetable

import android.content.Context
import android.content.Intent
import android.content.pm.ActivityInfo
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import com.example.mytimetable.settingsDialog
import kotlinx.android.synthetic.main.activity_semestre2.*


class semestre2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        /*val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
        val primerUso = sharedPref.getBoolean("se ha usado", true)

        if(primerUso){
            val changelogActivity = Intent(this, ChangeLog::class.java)
            startActivity(changelogActivity)
            val sharedPref = this.getPreferences(Context.MODE_PRIVATE)
            with (sharedPref.edit()){
                putBoolean("se ha usado", false)
                apply()
            }
        }*/

        when(getFirstTimeRun(this)){
            0 -> {
                val changelogActivity = Intent(this, bienvenida::class.java)
                startActivity(changelogActivity)
            }
            1 -> {
            }
            2 -> {
                val changelogActivity2 = Intent(this, ChangeLog::class.java)
                startActivity(changelogActivity2)
            }
        }

        requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_semestre_2_light)

        /*
        val fab: View = findViewById(R.id.config_fab)
        fab.setOnClickListener { view ->
            // Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
              //  .setAction("Action", null)
                //.show()

            val fragmentmanager = supportFragmentManager
            val dialog = settingsDialog()
            dialog.show(fragmentmanager, "Settings_Dialog")
        }

         */

        recreo_s2.setOnClickListener { mostrarDatos("Recreo", "", "", "", "") }


        /*
        PB1.setOnClickListener { mostrarDatos("Proyectos básicos", "Cándida Pérez Payá \r\n Conxi Borrell", "candida.perez@easda.es \r\n concepcionborrell@easda.es", "8:15 - 10:45", "Aula: 11 / 3") }
        PB2.setOnClickListener { mostrarDatos("Proyectos básicos", "Cándida Pérez Payá \r\n Conxi Borrell", "candida.perez@easda.es \r\n concepcionborrell@easda.es", "8:15 - 9:55", "Aula: 11 / 3") }

        DTG1.setOnClickListener { mostrarDatos("Diseño y técnicas gráficas", "Mario Rodríguez Ruiz", "mariorodriguez@easda.es", "11:15 - 13:45", "Aula: 11") }
        DTG2.setOnClickListener { mostrarDatos("Diseño y técnicas gráficas", "Mario Rodríguez Ruiz", "mariorodriguez@easda.es", "8:15 - 9:55", "Aula: 11") }

        EV1.setOnClickListener { mostrarDatos("Espacio y volumen", "Eva Torralba Pradillos", "evatorralba@easda.es", "9:55 - 12:55", "Aula: 3") }
        EV2.setOnClickListener { mostrarDatos("Espacio y volumen", "Eva Torralba Pradillos", "evatorralba@easda.es", "9:55 - 12:55", "Aula: 3") }
        EV3.setOnClickListener { mostrarDatos("Espacio y volumen", "Eva Torralba Pradillos", "evatorralba@easda.es", "11:15 - 12:55", "Aula: 5") }

        FHDTutoria.setOnClickListener{ mostrarDatos("Fundamentos históricos del diseño", "Francisco Otero Alia", "franciscotero@easda.es", "8:15 - 9:05, ","Aula: 1") }
        FHD1.setOnClickListener { mostrarDatos("Fundamentos históricos del diseño", "Francisco Otero Alia", "franciscotero@easda.es", "9:05 - 10:45, ","Aula: 1") }
        FHD2.setOnClickListener { mostrarDatos("Fundamentos históricos del diseño", "Francisco Otero Alia", "franciscotero@easda.es", "9:05 - 10:45, ","Aula: 10") }

        SR1.setOnClickListener { mostrarDatos("Sistemas de representación", "Miguel Ángel Blanco García", "miguelblanco@easda.es", "11:15 - 12:55", "Aula: 11") }
        SR2.setOnClickListener { mostrarDatos("Sistemas de representación", "Miguel Ángel Blanco García", "miguelblanco@easda.es", "9:55 - 12:55", "Aula: 12") }
        SR3.setOnClickListener { mostrarDatos("Sistemas de representación", "Miguel Ángel Blanco García", "miguelblanco@easda.es", "9:55 - 12:55", "Aula: 12") }
        */

    }

    fun toastRecreo(inicio : String, final : String){
        Toast.makeText(applicationContext, "$inicio - $final", Toast.LENGTH_LONG)
            .show()
    }

    fun toastMostrarDatos(inicio : String, final : String, aula : Int, extra : String){
        Toast.makeText(applicationContext, "$inicio - $final, en el aula: $aula $extra", Toast.LENGTH_LONG)
            .show()
    }

    fun mostrarDatos (Vnombre : String, Vprofesor : String, Vcorreo : String, Vhoras : String, Vaula : String){
        val nombre: TextView = findViewById(R.id.nombreAsignatura)
        val profesor: TextView = findViewById(R.id.nombreProfesor)
        val correo: TextView = findViewById(R.id.correoProfesor)
        val horas: TextView = findViewById(R.id.horasAsignatura)
        val aula: TextView = findViewById(R.id.numeroAula)

        nombre.text = Vnombre
        profesor.text = Vprofesor
        correo.text = Vcorreo
        horas.text = Vhoras
        aula.text = Vaula
    }

    fun getFirstTimeRun(contexto : Context): Int{

        val sp = contexto.getSharedPreferences("MyApp", 0)
        val currentVersionCode = BuildConfig.VERSION_CODE
        var result: Int
        val lastVersionCode = sp.getInt("FirstTimeRun", -1)

        if (lastVersionCode == -1){
            result= 0
        }
        else if (lastVersionCode == currentVersionCode){
            result = 1
        }
        else result =2

        sp.edit().putInt("FirstTimeRun", currentVersionCode).apply()
        return result
        // TODO Cambiar valor para el lanzamiento
        //return 1

    }

}
