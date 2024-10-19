package com.example.proyecto_parte1_sergio_abellan_garcia.datos

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.example.proyecto_parte1_sergio_abellan_garcia.R
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Coche
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.MetodoPago
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Moto
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Patinete
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Pedido
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Tarjeta
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
    @Composable
    fun PedidosPrueba(modifier: Modifier) : List<Pedido>
    {
        val listaPedidos = mutableListOf<Pedido>()

        val pedido1 = Pedido("Coche", true, "Diesel", 0, 3, 90.00, R.drawable.coche)
        val pedido2 = Pedido("Moto", false, "", 250, 4, 80.00, R.drawable.motico)
        val pedido3 = Pedido("Patinete", true, "", 0, 5, 25.00, R.drawable.patinete)
        val pedido4 = Pedido("Coche", true, "Diesel", 0, 3, 90.00, R.drawable.coche)
        val pedido5 = Pedido("Coche", false, "", 0, 4, 80.00, R.drawable.coche)
        val pedido6 = Pedido("Patinete", true, "", 0, 5, 25.00, R.drawable.patinete)
        val pedido7 = Pedido("Moto", false, "", 250, 4, 80.00, R.drawable.motico)

        listaPedidos.add(pedido1)
        listaPedidos.add(pedido2)
        listaPedidos.add(pedido3)
        listaPedidos.add(pedido4)
        listaPedidos.add(pedido5)
        listaPedidos.add(pedido6)
        listaPedidos.add(pedido7)

        return listaPedidos

    }

    @Composable
    fun ResumenPedidoPrueba(num: Int) : Pedido
    {
        val pedidoPrueba = when (num) {
            1 -> Pedido("Coche", true, "Diesel", 0, 3, 90.00, R.drawable.coche)
            2 -> Pedido("Moto", false, "", 250, 4, 80.00, R.drawable.motico)
            3 -> Pedido("Patinete", true, "", 0, 5, 25.00, R.drawable.patinete)
            else -> throw IllegalArgumentException("Número inválido")
        }
        return pedidoPrueba
    }

    @Composable
    fun tarjetas(modifier: Modifier) : List<Tarjeta>
    {
        val tarjetas = mutableListOf<Tarjeta>()
        tarjetas.add(Tarjeta("visa"))
        tarjetas.add(Tarjeta("mastercard"))
        tarjetas.add(Tarjeta("euro6000"))

        return tarjetas
    }

    @Composable
    fun MetodoPagoPrueba(num:Int): MetodoPago
    {
        val tarjeta = when (num)
        {
            1 -> Tarjeta("visa")

            2 -> Tarjeta("mastercard")
            3 -> Tarjeta("euro6000")
            else -> throw IllegalArgumentException("Número inválido")
        }
        return MetodoPago(tarjeta,123456789, "12/25", 123)
    }
}