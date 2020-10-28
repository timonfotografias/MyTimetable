package com.example.mytimetable

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import android.widget.ToggleButton
import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentContainer
import com.timonfotografias.mytimetable.R
import kotlinx.android.synthetic.*
import kotlinx.android.synthetic.main.settings_layout.*

class settingsDialog :DialogFragment(){
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        val sharedPreferences = context?.getSharedPreferences("VALUES", Context.MODE_PRIVATE)
        val currentTheme = sharedPreferences?.getInt("THEME", 0)
        val view = inflater.inflate(R.layout.settings_layout, container)

        return view
    }

}