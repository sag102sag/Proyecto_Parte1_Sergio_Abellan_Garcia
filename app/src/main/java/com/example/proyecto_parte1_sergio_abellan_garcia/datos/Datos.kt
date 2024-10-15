package com.example.proyecto_parte1_sergio_abellan_garcia.datos

import com.example.proyecto_parte1_sergio_abellan_garcia.R
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Coche
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Moto
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Patinete
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

    fun cargarVehiculos(): List<Vehiculo> = listOf(
        Coche(gps = true, R.drawable.coche, ""),
        Moto(gps = true, R.drawable.motico, 0),
        Patinete(gps = true, R.drawable.patinete )
    )
}