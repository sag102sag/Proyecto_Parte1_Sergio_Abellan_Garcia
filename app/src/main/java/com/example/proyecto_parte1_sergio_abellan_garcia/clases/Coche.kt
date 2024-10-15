package com.example.proyecto_parte1_sergio_abellan_garcia.clases

import com.example.proyecto_parte1_sergio_abellan_garcia.R


class Coche(
    gps: Boolean,
    rutaImagen: Int,
    val tipoCombustible: String,
    tipo: String = "Coche"
) : Vehiculo(gps, rutaImagen, tipo){
    val nombre: String = "coche"
}