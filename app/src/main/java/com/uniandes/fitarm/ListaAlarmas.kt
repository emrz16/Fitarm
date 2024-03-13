package com.uniandes.fitarm

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.PopupMenu
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

        val button2 = findViewById<ImageButton>(R.id.button2)

        button2.setOnClickListener { view ->
            showPopupMenu(view)
        }

        val button4 = findViewById<ImageButton>(R.id.button4)

        button4.setOnClickListener { view ->
            showPopupMenu(view)
        }
        val button3 = findViewById<ImageButton>(R.id.button3)

        button3.setOnClickListener { view ->
            showPopupMenu(view)
        }
    }

    fun cambiaACrearAlarma() {
        val intent = Intent(this, CrearAlarmaActivity::class.java)
        startActivity(intent)
    }

    private fun showPopupMenu(view: View){
        val popupMenu = PopupMenu(this, view)
        popupMenu.menuInflater.inflate(R.menu.menu_options, popupMenu.menu)
        popupMenu.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.editar_option -> {
                    true
                }
                R.id.eliminar_option -> {
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }
}
