package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.widget.*
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var etNombre: EditText
    private lateinit var btnSiguiente: Button

    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->

            if (result.resultCode == RESULT_OK) {
                val nuevoNombre = result.data?.getStringExtra("nombre_editado")

                if (!nuevoNombre.isNullOrEmpty()) {
                    etNombre.setText(nuevoNombre)
                }
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etNombre = findViewById(R.id.etNombre)
        btnSiguiente = findViewById(R.id.btnSiguiente)

        btnSiguiente.setOnClickListener {
            val nombre = etNombre.text.toString()

            val intent = Intent(this, SegundaActivity::class.java)
            intent.putExtra("nombre", nombre)

            launcher.launch(intent)
        }
    }
}