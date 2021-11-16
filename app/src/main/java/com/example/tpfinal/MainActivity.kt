package com.example.tpfinal

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Se establece el Administrador por Defecto
        var administrador = Admin("Administrador", "1234","Franco","Fernandez")

        //Agrego los usuarios a una lista de objetos User
        val listaAdmin = listOf(administrador)

        //Se declaran las variables de cada elemento de diseño
        val botoniniciar: Button=findViewById(R.id.btn_iniciar)
        val ad: EditText= findViewById(R.id.editTextTextUsu)
        val pass:EditText=findViewById(R.id.editTextPass)
        val botonExit: Button=findViewById(R.id.btnfinalizar)
        var test=findViewById<TextView>(R.id.textView3)

        test.text=administrador.Aviso()

        var validar = false

        fun Revision (admin: Admin): Boolean{
            var alerta = ""

            //Checkeo que se hayan completado datos y notifico si no fue hecho
            if (admin.usu == "" || admin.contraseña == "") {
                alerta = "!Por favor complete los campos!"
            }
            //Se verifica que los campos coincidan a los que estan harcodeado
            else {
                listaAdmin.forEach {
                    if (admin.usu != it.usu) {
                        alerta = "Verifica el Administrador ingresado."
                    }
                    //Si los campos coincide, se verifica que la contraseña coincida con la del usuario
                    else {
                        if (admin.contraseña != it.contraseña) {
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

        botoniniciar.setOnClickListener {
            //Se crea un objeto de tipo Administrador con los datos validados
            var AdminBox =ad.text.toString()
            var contraseña= pass.text.toString()
            val Logeo = Admin(AdminBox,contraseña,"","")
            val valides = Revision(Logeo)

            if (valides)
            {
                val datos: Bundle = Bundle()
                datos.putString("USUARIO", Logeo.usu)

                val intent = Intent(this, MainHome:: class.java)
                intent.putExtras(datos)
                startActivity(intent)
                Toast.makeText(this, "${administrador.Aviso()}", Toast.LENGTH_SHORT).show()
            }
        }
        botonExit.setOnClickListener {
            finish()
        }
    }


}