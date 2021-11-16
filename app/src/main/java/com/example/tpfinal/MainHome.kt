package com.example.tpfinal

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainHome : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_home)

        var botoncesion: Button =findViewById(R.id.btn_cesion)
        var bienvenida: TextView=findViewById(R.id.textHome)
        val bundle=intent.extras
        val dato=bundle?.getString("USUARIO")


        bienvenida.text="Bienvenido ¡${dato}! Carrefour."

        botoncesion.setOnClickListener {
            finish()
        }

    }

    fun btn_agragarpro(view: android.view.View) {
        val intent = Intent(this, AgregarProducto:: class.java)
        startActivity(intent)
    }

    fun btn_mostrarpro(view: android.view.View) {
        val intent = Intent(this, MostrarProducto:: class.java)
        startActivity(intent)
    }

}