package com.example.proyecto_parte1_sergio_abellan_garcia.clases

import com.example.proyecto_parte1_sergio_abellan_garcia.R

class Moto (
    gps: Boolean,
    rutaImagen: Int,
    val cilindrada: Int,
    tipo: String = "Moto"
): Vehiculo(gps, rutaImagen, tipo){
    val nombre: String = R.string.moto.toString()
}