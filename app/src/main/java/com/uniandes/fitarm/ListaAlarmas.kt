package com.uniandes.fitarm

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.uniandes.fitarm.ui.theme.FitarmTheme

class ListaAlarmas : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.inicio)
        val boton = findViewById<Button>(R.id.add)
        boton.setOnClickListener {
            cambiaACrearAlarma()
        }
    }

    fun cambiaACrearAlarma() {
        val intent = Intent(this, CrearAlarmaActivity::class.java)
        startActivity(intent)
    }
}
