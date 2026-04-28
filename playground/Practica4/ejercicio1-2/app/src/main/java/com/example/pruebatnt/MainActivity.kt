package com.example.pruebatnt

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.pruebatnt.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnCompartir.setOnClickListener {
            compartirTexto()
        }

        binding.btnUrl.setOnClickListener {
            abrirUrl()
        }
    }

    private fun compartirTexto() {
        val texto = binding.etTexto.text.toString().trim()

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresá un texto antes de compartir", Toast.LENGTH_SHORT).show()
            return
        }

        val sendIntent = Intent(Intent.ACTION_SEND).apply {
            type = "text/plain"
            putExtra(Intent.EXTRA_TEXT, texto)
        }

        val chooser = Intent.createChooser(sendIntent, "Compartir con")

        if (sendIntent.resolveActivity(packageManager) != null) {
            startActivity(chooser)
        } else {
            Toast.makeText(this, "No hay aplicaciones compatibles para compartir", Toast.LENGTH_SHORT).show()
        }
    }

    private fun abrirUrl() {
        var texto = binding.etTexto.text.toString().trim()

        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingresá una URL para abrirla", Toast.LENGTH_SHORT).show()
            return
        }

        if (!texto.startsWith("http://") && !texto.startsWith("https://")) {
            texto = "https://$texto"
        }

        val uri = Uri.parse(texto)
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay aplicación para abrir la URL", Toast.LENGTH_SHORT).show()
        }
    }
}