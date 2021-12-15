package com.example.tpfinal

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class AgregarProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_producto)

        var btnatras: Button = findViewById(R.id.btn_atras)
        var btnagregar: Button=findViewById(R.id.botonAgregar)
        var edtProducto: EditText=findViewById(R.id.editTextTextNom)
        var edtPrecio: EditText=findViewById(R.id.editTextTextPrecio)
        var edtStock: EditText= findViewById(R.id.editTextStock)

        btnatras.setOnClickListener {
            finish()
        }

        btnagregar.setOnClickListener {
            ingresarDatos(edtProducto,edtPrecio,edtStock)
        }

    }
    fun ingresarDatos(edtProducto: EditText,edtPrecio:EditText,edtStock:EditText){
        //Tomamos el valor de los productos
        var ConNom=edtProducto.text.toString()
        var ConPrecio= edtPrecio.text.toString()
        var ConStock=edtStock.text.toString()

        //Se cre el objeto Producto
        var Producto1=Producto(ConNom,ConPrecio,ConStock)

        Toast.makeText(this,"¡¡Producto: ${Producto1.nombre} Cargado con exito..!!",Toast.LENGTH_SHORT).show()

        //validar si los campos estan vacios
        if(ConPrecio.isEmpty()||ConNom.isEmpty()||ConStock.isEmpty()){
            Toast.makeText(this,"Por favor complete los campos requeridos.", Toast.LENGTH_SHORT).show()
        }
        else{
            val intent = Intent(this, MostrarProducto :: class.java)

            //envio el objeto a la activity MostrarProducto
            intent.putExtra("producto",Producto1)
            startActivity(intent)
            finish()
        }
    }
}