package com.example.trabajo3

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import android.util.Log
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    var contadorVidas = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart(){
        super.onStart()
        contadorVidas+=1
        Log.i("Ciclo de vida", "onStart. Contador de vidas: $contadorVidas")
    }

    override fun onResume(){
        super.onResume()
        Log.i("Ciclo de vida", "onResume. Contador de vidas: $contadorVidas")
    }

    override fun onPause(){
        super.onPause()
        Log.i("Ciclo de vida", "onPause. Contador de vidas: $contadorVidas")
    }

    override fun onStop(){
        super.onStop()
        Log.i("Ciclo de vida", "onStop. Contador de vidas: $contadorVidas")
    }

    override fun onDestroy(){
        super.onDestroy()
        Log.i("Ciclo de vida", "onDestroy, Contador de vidas: $contadorVidas")
    }

}