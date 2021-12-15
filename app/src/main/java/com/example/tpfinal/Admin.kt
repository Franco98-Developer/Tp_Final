package com.example.tpfinal

class Admin (var usu:String,var contraseña:String,nombre:String,apellido:String):Persona(nombre,apellido){

    override fun Identificacion(){
        println("------------Identificacion----------")
        println("Nombre: ${this.Nombre}.")
        println("Apellido: ${this.Apellido}.")
        println("Correo: ${this.usu}.")
        println("---------------------------------------")
    }

    override fun Aviso():String {
        return ("${Nombre} usted esta entrando en un perfil de administrador.")
    }
}