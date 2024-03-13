package com.uniandes.fitarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val boton = findViewById<Button>(R.id.button)
        boton.setOnClickListener {
            cambiaAInicio()
        }
    }

    fun cambiaAInicio() {
        val intent = Intent(this, ListaAlarmas::class.java)
        startActivity(intent)
    }

}
