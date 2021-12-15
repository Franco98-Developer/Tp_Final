package com.example.tpfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginUser : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_user)

        //Se establece User por Defecto
        var User = Usuario ("Franco","1234","41585168")

        //Agrego los usuarios a una lista de objetos User
        val listaUser = listOf(User)

        var botonsalir: Button =findViewById(R.id.btnexit)
        var botonvalidar: Button=findViewById(R.id.btn_validar)
        var useredit: EditText=findViewById(R.id.editTextTextUsu2)
        var passedit: EditText=findViewById(R.id.editTextPass2)

        var validar = false

        fun Revision (user: Usuario): Boolean{
            var alerta = ""

            //Checkeo que se hayan completado datos y notifico si no fue hecho
            if (user.username == "" || user.pass == "") {
                alerta = "!Por favor complete los campos!"
            }
            //Se verifica que los campos coincidan a los que estan harcodeado
            else {
                listaUser.forEach {
                    if (user.username != it.username) {
                        alerta = "Verifica el Usuario ingresado."
                    }
                    //Si los campos coincide, se verifica que la contraseña coincida con la del usuario
                    else {
                        if (user.pass != it.pass) {
                            alerta = "Verifica el password ingresado."
                        }
                        else {
                            validar = true
                        }
                    }
                }
            }
            //Si  falso  el boolean notifica el problema
            if (!validar)
            {
                Toast.makeText(this, alerta, Toast.LENGTH_SHORT).show()
            }
            return validar
        }

        botonsalir.setOnClickListener {
            Toast.makeText(this, "Estas en El login del Administrador", Toast.LENGTH_SHORT).show()
            finish()
        }

        botonvalidar.setOnClickListener{
            //Se crea un objeto de tipo usuario con los datos validados
            var userbox =useredit.text.toString()
            var passbox= passedit.text.toString()
            val Logeo = Usuario(userbox,passbox)
            val valides = Revision(Logeo)

            if (valides)
            {
                val intent = Intent(this, MainUser:: class.java)
                intent.putExtra("USUARIO",User)
                startActivity(intent)
                Toast.makeText(this, "Bienvenido al Perfil de Usuario", Toast.LENGTH_SHORT).show()
            }
        }
    }

}
