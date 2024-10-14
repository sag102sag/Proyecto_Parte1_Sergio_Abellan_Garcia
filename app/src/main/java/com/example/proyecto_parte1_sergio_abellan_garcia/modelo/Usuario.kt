package com.example.proyecto_parte1_sergio_abellan_garcia.modelo

import androidx.annotation.DrawableRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Usuario(
    @StringRes val nombreUsuario: Int,
    @DrawableRes val imagenUsuario: Int,
    @StringRes val apellido: Int,
    @StringRes val correoElectronico: Int,
    val numeroTelefono: Int
)
