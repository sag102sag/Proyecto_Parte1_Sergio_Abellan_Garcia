package com.example.proyecto_parte1_sergio_abellan_garcia

import android.annotation.SuppressLint
import com.example.proyecto_parte1_sergio_abellan_garcia.modelo.Usuario

class Datos {

    fun CargarUsuario() : Usuario
    {
       val usuario = Usuario(R.string.nombreprueba,R.drawable.usera, R.string.apellidoprueba, R.string.correoprueba, 654654654 )
        return usuario
    }
}