package com.example.proyecto_parte1_sergio_abellan_garcia

import android.widget.RadioButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.MetodoPago
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Tarjeta
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos

@Composable
fun VistaFormulario(modifier: Modifier)
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
            Spacer(Modifier.padding(25.dp))
            FormularioTarjeta(
                modifier = Modifier.padding(16.dp),
                tarjetas = Datos().tarjetas(modifier)
            )
        }
    }
}

@Composable
fun FormularioTarjeta(modifier: Modifier=Modifier, tarjetas: List<Tarjeta>)
{
    var tarjetaElegida by remember { mutableStateOf("") }
    var numeroTarjetaS by remember { mutableStateOf("") }
    var numeroTarjeta = numeroTarjetaS.toLongOrNull()?:0
    var fechaCaducidad by remember { mutableStateOf("") }
    var cvcS by remember { mutableStateOf("") }
    var cvc = cvcS.toIntOrNull()?:0

    Text(
        text = "Bienvenido al formulario de pago"
    )
    Card (
        Modifier
            .fillMaxWidth()
            .padding(16.dp)) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = stringResource(R.string.elija_tipo_de_tarjeta)
            )
           Spacer(Modifier.size(16.dp))
                for (tarjeta in tarjetas) {
                    Row (
                        Modifier
                            .fillMaxWidth()
                            .padding(start = 110.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically){
                        Column(verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally) {
                            RadioButton(
                                selected = tarjetaElegida == tarjeta.nombre,
                                onClick = { tarjetaElegida = tarjeta.nombre
                                }
                            )
                        }
                        Column (verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
                            TipoTarjeta(modifier = Modifier, tarjeta = tarjeta)
                        }
                    }
                }
        Row (
            Modifier
                .fillMaxWidth()
                .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
            Text(
                text = stringResource(R.string.n_mero_de_tarjeta),
                modifier = Modifier.padding(end = 8.dp).width(100.dp)
            )
            TextField(
                value = numeroTarjetaS,
                onValueChange = {numeroTarjetaS = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                singleLine = true,
                modifier = Modifier.width(800.dp)
            )
        }

        Row (
            Modifier
                .fillMaxWidth()
                .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
            Text(
                text = stringResource(R.string.fecha_de_caducidad),
                modifier = Modifier.padding(end = 8.dp).width(100.dp)
            )
            TextField(
                value = fechaCaducidad,
                onValueChange = {fechaCaducidad = it},
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text),
                singleLine = true,
                modifier = Modifier.width(800.dp)
            )
        }
            Row (
                Modifier
                    .fillMaxWidth()
                    .padding(16.dp), verticalAlignment = Alignment.CenterVertically){
                Text(
                    text = stringResource(R.string.cvc),
                    modifier = Modifier.padding(end = 8.dp).width(100.dp)
                )
                OutlinedTextField(
                    value = cvcS,
                    onValueChange = {cvcS = it},
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
                    singleLine = true,
                    modifier = Modifier.width(70.dp)

                )
            }
        }
        Row(Modifier.fillMaxWidth().padding(25.dp), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(R.string.tipo_de_tarjeta) +tarjetaElegida
                        + stringResource(R.string.n_mero_de_tarjeta) + numeroTarjeta
                        + stringResource(R.string.fecha_de_caducidad) + fechaCaducidad
                        + "\n"+stringResource(R.string.cvc) + cvc,
                textAlign = TextAlign.Center
            )
        }
        Row(Modifier.fillMaxWidth().padding(25.dp), horizontalArrangement = Arrangement.Center) {
            BotonesFinalesMetodoPago()
        }

    }
}

@Composable
fun TipoTarjeta(modifier: Modifier = Modifier, tarjeta: Tarjeta)
{
    Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically) {
        Text(
            text = tarjeta.nombre
        )
        Spacer(modifier.size(20.dp))
        Image(
            painter = painterResource(tarjeta.imagen),
            contentDescription = "tarjeta",
            modifier = Modifier.size(45.dp)
        )
    }
}

@Composable
fun BotonesFinalesMetodoPago()
{
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(R.string.cancelar))
        }
        Button(
            onClick = {},
            modifier = Modifier.padding(16.dp)
        ) {
            Text(text = stringResource(R.string.aceptar))
        }
    }
}
