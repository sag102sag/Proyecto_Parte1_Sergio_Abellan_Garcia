package com.example.proyecto_parte1_sergio_abellan_garcia.clases

import com.example.proyecto_parte1_sergio_abellan_garcia.R

class Tarjeta (tipo: String){
    val nombre: String
    val imagen: Int

    init {
        when(tipo)
        {
            "visa" -> {
                nombre = "VISA"
                imagen = R.drawable.visa
            }
            "mastercard" -> {
                nombre = "MasterCard"
                imagen = R.drawable.mastercard
            }
            "euro6000" -> {
                nombre = "Euro 6000"
                imagen = R.drawable.e6000
            }
            else -> throw IllegalArgumentException("Tipo de método de pago no válido")
        }
    }
}