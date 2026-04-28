package com.example.ejercicio4

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.example.ejercicio4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val tomarFoto =
        registerForActivityResult(ActivityResultContracts.TakePicturePreview()) { bitmap ->
            binding.progressBar.visibility = View.GONE

            if (bitmap != null) {
                binding.imageViewFoto.setImageBitmap(bitmap)
            } else {
                Toast.makeText(this, "No se tomó ninguna foto", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnFoto.setOnClickListener {
            abrirCamara()
        }
    }

    private fun abrirCamara() {
        binding.progressBar.visibility = View.VISIBLE
        tomarFoto.launch(null)
    }
}