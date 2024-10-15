package com.example.proyecto_parte1_sergio_abellan_garcia

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Vehiculo
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos

@Composable
fun VistaPedidos(modifier: Modifier = Modifier)
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
        ListaVehiculos(
            lista = Datos().cargarVehiculos(),
            modifier = Modifier
        )
    }
}

@Composable
fun ListaVehiculos(lista: List<Vehiculo>, modifier: Modifier = Modifier)
{
    Row (Modifier.fillMaxWidth().padding(top = 50.dp),
        horizontalArrangement = Arrangement.Center)
    {
        Column(horizontalAlignment = Alignment.CenterHorizontally)
        {
            Text(text = "Elija vehículo a reservar", textAlign = TextAlign.Center)

            Spacer(modifier.size(16.dp))

            LazyColumn(modifier = modifier, horizontalAlignment = Alignment.CenterHorizontally)
            {
                items(lista) { vehiculo ->
                    TarjetaVehiculo(vehiculo = vehiculo, modifier = Modifier.padding(8.dp))
                }
            }
        }
    }

}
@Composable
fun TarjetaVehiculo(vehiculo: Vehiculo, modifier: Modifier = Modifier)
{
    var mostrar by remember { mutableStateOf(false) }
    Card (modifier = modifier.width(300.dp).clickable {mostrar = !mostrar})
    {

        Row (modifier = Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically)
        {
          Box(){
                Image(
                    painter = painterResource(vehiculo.rutaImagen),
                    contentDescription = "Vehiculo",
                    modifier = Modifier
                        .fillMaxWidth()
                        .graphicsLayer(alpha = 0.95f) // Ajustar la opacidad aquí (0.0f a 1.0f)

                )
                Text(
                    text = vehiculo.tipo,
                    modifier = Modifier
                        .align(Alignment.Center)
                        .padding(8.dp),
                    fontSize = 35.sp,
                    color = colorResource(id = R.color.white),
                    fontWeight = FontWeight.Bold
                )
            }

        }
        if(mostrar)
        {
            Row {
                ExtensionEleccion(vehiculo.tipo)
            }
        }
    }
}
@Composable
fun ExtensionEleccion(tipo: String)
{

    if(tipo.equals("Coche"))
    {
        var tipoCombustible by remember { mutableStateOf("") }
        var eleccionCombustible by remember { mutableStateOf("" + tipoCombustible) }
        Column {
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Text(
                    text = "Elige el tipo de combustible:",
                    modifier = Modifier.padding(16.dp)
                )

            }
            Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center)
            {
                Column (horizontalAlignment = Alignment.Start, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)){
                    RadioButton(
                        selected = tipoCombustible == "Diesel",
                        onClick = {tipoCombustible = "Diesel"
                                   eleccionCombustible = "Usted ha elegido: "},
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    )
                    Text(
                        text = "Diesel"
                    )
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)){
                    RadioButton(
                        selected = tipoCombustible == "Gasolina",
                        onClick = { tipoCombustible = "Gasolina"
                                    eleccionCombustible = "Usted ha elegido: "},
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Gasolina"
                    )
                }
                Column (horizontalAlignment = Alignment.End, verticalArrangement = Arrangement.Center, modifier = Modifier.padding(16.dp)){
                    RadioButton(
                        selected = tipoCombustible == "Eléctrico",
                        onClick = { tipoCombustible = "Eléctrico"
                                    eleccionCombustible = "Usted ha elegido: "},

                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Eléctrico",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                Text(
                    text = eleccionCombustible + tipoCombustible
                )
            }
        }
    }
    else if (tipo.equals("Moto"))
    {
        Row {
            Text(
                text = "Hola soy la prueba de la moto"
            )
        }
    }
    else{
        Row {
            Text(
                text = "Hola soy la prueba del patinete"
            )
        }
    }
}