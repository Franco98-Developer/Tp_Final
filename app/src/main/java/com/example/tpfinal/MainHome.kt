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

        //creo las variables de los botones y lo texview
        var botoncesion: Button =findViewById(R.id.btn_cesion)

        var bienvenida: TextView=findViewById(R.id.textHome)
        //creo una variable bundle donde recibo mi usuario
        val bundle=intent.extras
        val dato=bundle?.getString("USUARIO")//recibo el usuario haciendo referencia a la palabra clave


        //mensaje de bienevenida hacienod referencia la usuario
        bienvenida.text="Bienvenido ¡${dato}! a Carrefour."

        botoncesion.setOnClickListener {
            finish()
        }

    }

    //funcion para dirigirme a la activity AgregarProducto
    fun btn_agragarpro(view: android.view.View) {
        val intent = Intent(this, AgregarProducto:: class.java)
        startActivity(intent)

    }

    //funcion para dirigirme a la activity MostarProducto
    fun btn_mostrarpro(view: android.view.View) {
        val intent = Intent(this, MostrarProducto:: class.java)
        startActivity(intent)
    }

}