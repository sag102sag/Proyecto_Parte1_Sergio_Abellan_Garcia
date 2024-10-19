package com.example.proyecto_parte1_sergio_abellan_garcia.clases

import com.example.proyecto_parte1_sergio_abellan_garcia.R

class Patinete(
    gps:Boolean,
    rutaImagen: Int,
    tipo: String = "Patinete"
): Vehiculo(gps, rutaImagen, tipo){
    val nombre: String = R.string.patinete.toString()
}