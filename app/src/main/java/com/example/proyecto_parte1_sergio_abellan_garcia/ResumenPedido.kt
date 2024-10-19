package com.example.proyecto_parte1_sergio_abellan_garcia

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Pedido
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos

@Composable
fun VistaResumenPedido(modifier: Modifier = Modifier)
{
    Box()
    {
        Image(
            painter = painterResource(R.drawable.cochecito),
            contentDescription = "Vehiculo",
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxSize()
                .graphicsLayer(alpha = 0.2f) // Ajustar la opacidad aquí (0.0f a 1.0f)
        )
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            // Puedes probar un ejemplo de cada vehiculo introduciendo 1,2 o 3 como parámetro en la función ResumenPedidoPrueba
            ResumenPedido(modifier = Modifier, pedido = Datos().ResumenPedidoPrueba(1))
            BotonesFinalesResumen(modifier = Modifier)
        }
    }
}

@Composable
fun ResumenPedido(modifier: Modifier, pedido: Pedido)
{
    Card (
        modifier
            .fillMaxWidth()
            .padding(40.dp)){
        Row {
            Column {
                Row (Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                    Image(
                        painter = painterResource(pedido.imagen),
                        contentDescription = stringResource(R.string.imagen_del_pedido),
                        modifier = Modifier
                            .size(300.dp)
                            .padding(0.dp)
                    )
                }
                Row (
                    Modifier
                        .fillMaxWidth()
                        .padding(start = 16.dp, end = 16.dp, bottom = 25.dp),
                        horizontalArrangement = Arrangement.Center) {
                    var gpsTF : String
                    if(pedido.gps) gpsTF = stringResource(R.string.s) else gpsTF = stringResource(R.string.no)
                        Text(
                            text = stringResource(R.string.vehiculo) + pedido.vehiculo
                            +"\nGPS: "+gpsTF
                            +"\n "+stringResource(R.string.tipo_de_combustible)+ pedido.tipoCombustible + stringResource(R.string.solo_coches)
                            +"\n "+stringResource(R.string.cilindrada) + pedido.cilindrada +" "+ stringResource(R.string.solo_motos)
                            +"\n "+stringResource(R.string.d_as_a_alqular) + pedido.numDias
                            +"\n "+ stringResource(R.string.precio_total) + " "+pedido.precioTotal,
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }

@Composable
fun BotonesFinalesResumen (modifier: Modifier) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp).width(120.dp)
        ) {
            Text(text = stringResource(R.string.cancelar))
        }
        Button(
            onClick = {

            },
            modifier = Modifier.padding(16.dp).width(120.dp)
        ) {
            Text(text = stringResource(R.string.pagar))
        }
    }
}
