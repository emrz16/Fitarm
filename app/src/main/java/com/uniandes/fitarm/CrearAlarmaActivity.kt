package com.uniandes.fitarm

import android.app.DatePickerDialog
import android.app.Dialog
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.LinearLayout
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
import java.util.Calendar

class CrearAlarmaActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.creacion_alarma)

        val boton = findViewById<Button>(R.id.repeticion_button)
        boton.setOnClickListener {
            cambiaARepeticion()
        }
        val botonHora = findViewById<TextView>(R.id.hora_num)
        botonHora.setOnClickListener {
            mostrarModal()
        }

        val botonSonido = findViewById<TextView>(R.id.sonido_button)
        botonSonido.setOnClickListener {
            cambiaASonido()
        }
        val guardarButton = findViewById<TextView>(R.id.guardarButton)
        guardarButton.setOnClickListener {
            cambiaAInicio()
        }

        val volverButton = findViewById<TextView>(R.id.volverButton)
        volverButton.setOnClickListener {
            cambiaAInicio()
        }

        val linearLayout = findViewById<TextView>(R.id.fecha_input)
        linearLayout.setOnClickListener {
            showDatePickerDialog()
        }

    }

    fun cambiaARepeticion() {
        val intent = Intent(this, RepeticionAlarmaActivity::class.java)
        startActivity(intent)
    }
    fun cambiaAInicio() {
        val intent = Intent(this, ListaAlarmas::class.java)
        startActivity(intent)
    }

    private fun mostrarModal() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.modal_hora)
        dialog.window?.setBackgroundDrawableResource(android.R.color.transparent)

        val botonCancelar = dialog.findViewById<Button>(R.id.btn_cerrar_modal_cancelar)
        botonCancelar.setOnClickListener {
            dialog.dismiss()
        }
        val botonAceptar = dialog.findViewById<Button>(R.id.btn_cerrar_modal_aceptar)
        botonAceptar.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }

    private fun cambiaASonido() {
        val intent = Intent(this, SonidoAlarmaActivity::class.java)
        startActivity(intent)
    }

    private fun showDatePickerDialog() {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, selectedYear, selectedMonth, selectedDay ->
            // Maneja la fecha seleccionada aquí
            val selectedDate = "$selectedDay/${selectedMonth + 1}/$selectedYear"
            val fechaInput = findViewById<TextView>(R.id.fecha_input)
            fechaInput.text = selectedDate
        }, year, month, dayOfMonth)

        datePickerDialog.show()
    }

}
