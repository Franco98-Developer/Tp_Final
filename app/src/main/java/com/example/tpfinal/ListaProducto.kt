package com.example.tpfinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//lateinit var service: ApiService

class ListaProducto : AppCompatActivity() {
    //lateinit var servicio:ApiService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_producto)
        var botoncesion: Button =findViewById(R.id.button)

        botoncesion.setOnClickListener {
            //getAllPost()
        }


       /* val retrofit:Retrofit=Retrofit.Builder()
            .baseUrl("http://carrefourexpress.free.beeceptor.com/listadeProductos/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        service=retrofit.create<ApiService>(ApiService::class.java)*/


    }

    /*fun getAllPost(){
        val test = findViewById<TextView>(R.id.textView3)
        service.getAllPost().enqueue(object : Callback<List<Post>> {
            override fun onResponse(call: Call<List<Post>>, response: Response<List<Post>>) {
                var postList: List<Post>?=response.body()

                test.text= postList?.get(2)?.Precio.toString()
            }

            override fun onFailure(call: Call<List<Post>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }*/
}