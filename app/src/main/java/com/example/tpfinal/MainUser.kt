package com.example.tpfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_user)


        var salir:Button=findViewById(R.id.button3)
        var textUser:TextView=findViewById(R.id.textView4)

        val user=intent.getParcelableExtra<Usuario>("USUARIO")

        if (user!=null){
            textUser.text="bienvenido ${user.username} \n" +
                    "DNI:${user.dni}\n" +
                    "CONTRASEÑA:${user.pass}"

        }



        salir.setOnClickListener{
            finish()
        }
    }
}