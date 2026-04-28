package com.example.ejercicio3

import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnMapa.setOnClickListener {
            abrirMapa()
        }

        binding.btnLlamar.setOnClickListener {
            llamarTelefono()
        }
    }

    private fun abrirMapa() {
        val direccion = binding.etTexto.text.toString().trim()

        if (direccion.isEmpty()) {
            Toast.makeText(this, "Ingresá una ciudad, calle o coordenadas", Toast.LENGTH_SHORT).show()
            return
        }

        val uri = Uri.parse("geo:0,0?q=${Uri.encode(direccion)}")
        val intent = Intent(Intent.ACTION_VIEW, uri)

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay una aplicación de mapas disponible", Toast.LENGTH_SHORT).show()
        }
    }

    private fun llamarTelefono() {
        val numero = binding.etTelefono.text.toString().trim()

        if (numero.isEmpty()) {
            Toast.makeText(this, "Ingresá un número", Toast.LENGTH_SHORT).show()
            return
        }
        /*
             ACTION_DIAL únicamente abre la aplicación de marcador telefónico del sistema
             con el número previamente cargado, permitiendo que el usuario revise y confirme
             manualmente la acción antes de iniciar la llamada. Esto implica que la aplicación
             no realiza ninguna acción crítica por sí sola.

             En cambio, ACTION_CALL inicia la llamada directamente sin intervención del usuario,
             lo cual representa un mayor riesgo desde el punto de vista de seguridad, ya que la app
             podría realizar llamadas sin el consentimiento explícito en ese momento.

             Debido a esto, ACTION_CALL requiere declarar y solicitar el permiso sensible
             android.permission.CALL_PHONE en el AndroidManifest.xml, y además solicitarlo
             en tiempo de ejecución (runtime permissions).
         */
        
        /*
          if (checkSelfPermission(android.Manifest.permission.CALL_PHONE)
            != PackageManager.PERMISSION_GRANTED) {

            requestPermissions(arrayOf(android.Manifest.permission.CALL_PHONE), 1)
            return
        }
         */

        val intent = Intent(Intent.ACTION_DIAL).apply {
            data = Uri.parse("tel:$numero")
        }

        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        } else {
            Toast.makeText(this, "No hay app para realizar llamadas", Toast.LENGTH_SHORT).show()
        }
    }
}