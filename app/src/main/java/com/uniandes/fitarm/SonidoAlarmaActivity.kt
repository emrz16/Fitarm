package com.uniandes.fitarm

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
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

class SonidoAlarmaActivity : ComponentActivity() {

    private var ultimoTextViewClicado: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sonido_alarma)
        val diarioTextView = findViewById<TextView>(R.id.sonido_1)
        val cadaDosTextView = findViewById<TextView>(R.id.sonido_2)
        val cadaSemanaTextView = findViewById<TextView>(R.id.sonido_3)
        val diaPorMedioTextView = findViewById<TextView>(R.id.sonido_4)

        diarioTextView.setOnClickListener { cambiarColorDeFondo(it as TextView) }
        cadaDosTextView.setOnClickListener { cambiarColorDeFondo(it as TextView) }
        cadaSemanaTextView.setOnClickListener { cambiarColorDeFondo(it as TextView) }
        diaPorMedioTextView.setOnClickListener { cambiarColorDeFondo(it as TextView) }

        val guardarButton = findViewById<TextView>(R.id.guardarButton)
        guardarButton.setOnClickListener {
            cambiaACreacionAlarma()
        }

        val volverButton = findViewById<TextView>(R.id.volverButton)
        volverButton.setOnClickListener {
            cambiaACreacionAlarma()
        }
    }

    private fun cambiarColorDeFondo(textView: TextView) {
        ultimoTextViewClicado?.background = getDrawable(R.drawable.opciones_repeticion)

        textView.setBackgroundColor(getColor(R.color.selected_items_color_form))

        ultimoTextViewClicado = textView
    }

    fun cambiaACreacionAlarma() {
        val intent = Intent(this, CrearAlarmaActivity::class.java)
        startActivity(intent)
    }
}
