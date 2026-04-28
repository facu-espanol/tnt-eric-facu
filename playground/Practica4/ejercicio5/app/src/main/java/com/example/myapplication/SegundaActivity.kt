package com.example.myapplication
import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class SegundaActivity : AppCompatActivity() {

    private lateinit var tvSaludo: TextView
    private lateinit var etEditarNombre: EditText
    private lateinit var btnVolver: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_segunda)

        tvSaludo = findViewById(R.id.tvSaludo)
        etEditarNombre = findViewById(R.id.etEditarNombre)
        btnVolver = findViewById(R.id.btnVolver)

        // Recibir dato
        val nombre = intent.getStringExtra("nombre") ?: ""

        // Mostrar saludo formal
        tvSaludo.text = "Hola $nombre, este es un saludo formal."
        etEditarNombre.setText(nombre)

        btnVolver.setOnClickListener {
            val nombreEditado = etEditarNombre.text.toString()

            val intentResultado = Intent()
            intentResultado.putExtra("nombre_editado", nombreEditado)

            setResult(RESULT_OK, intentResultado)
            finish()
        }
    }
}