package com.example.ejercicio6

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var txtTextoRecibido: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtTextoRecibido = findViewById(R.id.etNombre)

        recibirTextoCompartido(intent)
    }

    private fun recibirTextoCompartido(intent: Intent) {
        if (intent.action == Intent.ACTION_SEND && intent.type == "text/plain") {
            val textoRecibido = intent.getStringExtra(Intent.EXTRA_TEXT)
            txtTextoRecibido.text = textoRecibido ?: "No se recibió texto"
        } else {
            txtTextoRecibido.text = "La app se abrió normalmente"
        }
    }
}