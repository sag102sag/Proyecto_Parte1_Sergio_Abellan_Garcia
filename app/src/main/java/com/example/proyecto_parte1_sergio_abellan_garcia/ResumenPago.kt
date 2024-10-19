package com.example.proyecto_parte1_sergio_abellan_garcia


import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
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
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.MetodoPago
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos

@Composable
fun VistaResumenPago(modifier: Modifier = Modifier)
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
            ResumenMetodoPago(
                modifier = Modifier,
                metodoPago = Datos().MetodoPagoPrueba(3)
            )


        }
    }
}



@Composable
fun ResumenMetodoPago(modifier: Modifier = Modifier, metodoPago: MetodoPago)
{
    Spacer(Modifier.size(35.dp))
    Card (
        modifier
            .fillMaxWidth()
            .padding(16.dp)){
        Row (
            modifier
                .fillMaxWidth()
                .padding(16.dp))
        {
            Column {
                Image(
                    painter = painterResource(metodoPago.tarjeta.imagen),
                    contentDescription = stringResource(R.string.icono_tarjeta),
                    modifier = Modifier.size(100.dp)
                )
            }
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = stringResource(R.string.tipo_de_tarjeta)+ metodoPago.tarjeta.nombre
                    +"\n"+ stringResource(R.string.n_mero_de_tarjeta)+ metodoPago.numeroTarjeta
                    +"\n"+ stringResource(R.string.fecha_de_caducidad)+ metodoPago.fechaCad
                    +"\n"+ stringResource(R.string.cvc)+ metodoPago.cvc,
                    textAlign = TextAlign.Start,
                    modifier = Modifier.padding(start = 25.dp)
                )
                Spacer(Modifier.size(16.dp))
                Text(
                    text = stringResource(R.string.precio_total)+" 100€"
                )
            }
        }
        Row(modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
            horizontalArrangement = Arrangement.Center)
        {
            BotonesFinalesResumenPago()
        }
    }
}

@Composable
fun BotonesFinalesResumenPago(
) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {

            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(R.string.aceptar))
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(
                text = stringResource(R.string.enviar)
            )
        }
    }
}