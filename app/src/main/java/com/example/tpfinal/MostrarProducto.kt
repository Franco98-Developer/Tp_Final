package com.example.tpfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.TextView
import java.util.ArrayList

class MostrarProducto : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_producto)


        val arrayAdapter:ArrayAdapter<*>
        var btncerrar: Button =findViewById(R.id.btn_atras)
        val listaProducto: ListView=findViewById(R.id.lista)
        val list = ArrayList<String>()
        list.add("       Producto      Stock       Precio ")
        list.add("       Coca Cola       10        $200 ")
        list.add("       Don Satur        15        $90  ")
        list.add("       Fideos              20        $50  ")



        arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,list)
        listaProducto.adapter=arrayAdapter

        //llamo a la funcion Recibir datos para que se guarde a la lista precargada
        list.add(recibirDatos())

        btncerrar.setOnClickListener {
            finish()
        }

    }
    fun recibirDatos():String{
        //creo la variable en la que voy a recibir el objeto Producto
        val producto=intent.getParcelableExtra<Producto>("producto")

        if (producto!=null){
            return "      ${producto.nombre}                  ${producto.stock}        $${producto.precio}"

        }
        return ""
    }
}