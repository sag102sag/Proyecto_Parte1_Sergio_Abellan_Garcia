package com.example.proyecto_parte1_sergio_abellan_garcia.datos

import com.example.proyecto_parte1_sergio_abellan_garcia.R
import com.example.proyecto_parte1_sergio_abellan_garcia.modelo.Usuario
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Vehiculo

class Datos {

    fun CargarUsuario() : Usuario
    {
       val usuario = Usuario(
           R.string.nombreprueba,
           R.drawable.usera,
           R.string.apellidoprueba,
           R.string.correoprueba, 654654654 )
        return usuario
    }

}