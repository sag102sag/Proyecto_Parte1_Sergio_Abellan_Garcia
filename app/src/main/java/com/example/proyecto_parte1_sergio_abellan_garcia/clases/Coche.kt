package com.example.proyecto_parte1_sergio_abellan_garcia.clases

import androidx.compose.ui.res.stringResource
import com.example.proyecto_parte1_sergio_abellan_garcia.R


class Coche(
    gps: Boolean,
    rutaImagen: Int,
    val tipoCombustible: String,
    tipo: String = "Coche"
) : Vehiculo(gps, rutaImagen, tipo){
    val nombre: String = R.string.cocheB.toString()
}