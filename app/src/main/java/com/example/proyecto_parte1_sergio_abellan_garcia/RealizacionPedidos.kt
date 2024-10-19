package com.example.proyecto_parte1_sergio_abellan_garcia

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.ZeroCornerSize
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Pedido
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
        Column (modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
        ListaVehiculos(
            lista = Datos().cargarVehiculos(),
            modifier = Modifier
        )
            Row(modifier = Modifier.padding(16.dp))
            {
                BotonesFinales()
            }
        }

    }
}

@Composable
fun ListaVehiculos(lista: List<Vehiculo>, modifier: Modifier = Modifier)
{
    Row (
        Modifier
            .fillMaxWidth()
            .padding(top = 50.dp),
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
    var tipoVehiculo by remember{ mutableStateOf("") }
    var contador by remember { mutableStateOf(0) }
    Card (modifier = modifier
        .width(300.dp)
        .clickable {
            mostrar = !mostrar
            tipoVehiculo = vehiculo.tipo
            contador++
        })
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

        if(mostrar) {

            when(tipoVehiculo)
            { "Coche" -> {
                Row {
                    ExtensionEleccion(vehiculo.tipo)
                }
            }
                "Moto" -> {
                    Row {
                        ExtensionEleccion(vehiculo.tipo)
                    }
                }
                "Patinete" -> {
                    Row {
                        ExtensionEleccion(vehiculo.tipo)
                    }
                }
            }
        }
    }
}
@Composable
fun ExtensionEleccion(tipo: String)
{
var precioFinal by remember { mutableStateOf(0.0) }
    if(tipo.equals("Coche"))
    {
        var gps by remember { mutableStateOf(false) }
        var numDias by remember { mutableStateOf(0) }
        var precioCombustible by remember { mutableStateOf(0) }
        var tipoCombustible by remember { mutableStateOf("") }
        var eleccionCombustible by remember { mutableStateOf("" + tipoCombustible) }
        var eleccion by remember{ mutableStateOf(false) }

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
                                   eleccion= true
                                   precioCombustible=25},
                        modifier = Modifier.align(Alignment.CenterHorizontally)

                    )
                    Text(
                        text = "Diesel"
                    )
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceAround, modifier = Modifier.padding(16.dp)){
                    RadioButton(
                        selected = tipoCombustible == "Gasolina",
                        onClick = { tipoCombustible = "Gasolina"
                                    eleccion= true
                                    precioCombustible=20},
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
                                    eleccion= true
                                    precioCombustible=15},

                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                    Text(
                        text = "Eléctrico",
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    )
                }
            }
            if (eleccion) {
                Row(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.Center
                ) {
                    Text(
                        text = stringResource(R.string.usted_ha_elegido) + tipoCombustible
                    )
                }
            }
            Spacer(Modifier.size(16.dp))
            gps = QuiereGps(modifier = Modifier)
            numDias = CantidadDias(modifier = Modifier)
            precioFinal=CalculoPrecioFinal(tipo, precioCombustible, gps, 0, numDias)

            Text(
                text = "Precio final: "+precioFinal,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            MuestraBotones(modifier = Modifier, tipo, gps, tipoCombustible, 0, numDias, precioFinal, R.drawable.coche )

                var nuevoPedido : Pedido


        }
    }
    else if (tipo.equals("Moto"))
    {
        var gps by remember { mutableStateOf(false) }
        var numDias by remember { mutableStateOf(0) }
        var cilindrada by remember { mutableStateOf(0) }
        var realizarPedidoMoto by remember { mutableStateOf(false) }
        Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){
            cilindrada = EleccionCilindrada(modifier = Modifier)
            Spacer(Modifier.size(16.dp))
            gps = QuiereGps(modifier = Modifier)
            numDias = CantidadDias(modifier = Modifier)
            precioFinal=CalculoPrecioFinal(tipo, 0, gps, cilindrada, numDias)
            Text(
                text = "Precio final: "+precioFinal+"€",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            realizarPedidoMoto = MuestraBotones(modifier = Modifier, tipo, gps, "", cilindrada, numDias, precioFinal, R.drawable.motico)
            if(realizarPedidoMoto)
            {
                var nuevoPedido : Pedido
                nuevoPedido = Pedido(tipo, gps, "", 0, numDias, precioFinal, R.drawable.motico)
            }
        }
    }
    else{
        var gps by remember { mutableStateOf(false) }
        var numDias by remember { mutableStateOf(0) }
        var realizarPedidoPatinete by remember { mutableStateOf(false) }

        Column (modifier = Modifier.fillMaxWidth(), verticalArrangement = Arrangement.Center){
            Spacer(modifier = Modifier.size(16.dp))
            gps = QuiereGps(modifier = Modifier)
            numDias = CantidadDias(modifier = Modifier)
            precioFinal=CalculoPrecioFinal(tipo, 0, gps, 0, numDias)
            Text(
                text = "Precio final: "+precioFinal+"€",
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                textAlign = TextAlign.Center
            )
            realizarPedidoPatinete = MuestraBotones(modifier = Modifier, tipo, gps, "", 0, numDias, precioFinal, R.drawable.patinete)
            if(realizarPedidoPatinete)
            {
                var nuevoPedido : Pedido
                nuevoPedido = Pedido(tipo, gps, "", 0, numDias, precioFinal, R.drawable.patinete)
            }

        }
    }
}

@Composable
fun EleccionCilindrada(modifier: Modifier = Modifier): Int
{
    var cilindrada by remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
        Row (modifier = Modifier.padding(top = 16.dp)) {
            Text(
                text = "Elija su cilindrada:"
            )
        }
            Row (){
                Column(modifier = Modifier.padding(16.dp)) {
                    RadioButton(
                        selected = cilindrada == 250,
                        onClick = {cilindrada = 250}
                    )
                    Text(
                        text = "250cc"
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    RadioButton(
                        selected = cilindrada == 125,
                        onClick = {cilindrada = 125}
                    )
                    Text(
                        text = "125cc"
                    )
                }
                Column(modifier = Modifier.padding(16.dp)) {
                    RadioButton(
                        selected = cilindrada == 50,
                        onClick = {cilindrada = 50}
                    )
                    Text(
                        text = "50cc"
                    )
                }
            }
        if (cilindrada>0) {
            Text(
                text = "Has elegido: " + cilindrada + "cc"
            )
        }
    }
    return cilindrada
}

@Composable
fun QuiereGps (modifier: Modifier = Modifier) :Boolean
{
    var respuesta by remember { mutableStateOf<Boolean?>(null) }
    var respuesta2 by remember { mutableStateOf(false) }
    Row (modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.desea_gps)
            )
            Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(16.dp)) {
                    RadioButton(
                        selected = respuesta == true,
                        onClick = {respuesta = true}
                    )
                    Text(
                        text = stringResource(R.string.s)
                    )
                }
                Column (horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.padding(16.dp)){
                    RadioButton(
                        selected = respuesta == false,
                        onClick = {respuesta = false}
                    )
                    Text(
                        text = stringResource(R.string.no)
                    )
                }
            }
        }
    }
    respuesta2 = respuesta == true
    if (respuesta==true||respuesta==false)
    {
        Row (modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp), horizontalArrangement = Arrangement.Center) {
            when (respuesta2)
            {
                true ->
                {
                    Text( text = stringResource(R.string.tu_vehiculo_contar_con_gps))
                }
                false ->
                {
                    Text( text = stringResource(R.string.tu_vehiculo_no_contar_con_gps))
                }
            }
        }
    }
    return respuesta2
}

@Composable
fun CantidadDias(modifier: Modifier) : Int
{
    var numDias by remember { mutableStateOf(0) }
    var mostrarNumDias by remember { mutableStateOf(false) }
    Row (modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text = stringResource(R.string.cu_ntos_dias_lo_quiere_alquilar)
            )
            Row (
                modifier
                    .fillMaxWidth()
                    .padding(16.dp), horizontalArrangement = Arrangement.Center, verticalAlignment = Alignment.CenterVertically)
            {
                Text(
                    text = stringResource(R.string.d_as) +numDias,
                )
                Button(onClick = {
                    numDias++
                    mostrarNumDias = true}, modifier = Modifier.padding(start = 35.dp)) {
                    Text(
                        text = stringResource(R.string.plus)
                    )
                }
                Button(onClick = {
                    if(numDias>0){numDias--}
                    mostrarNumDias = true}, modifier = Modifier.padding(10.dp)) {
                    Text(
                        text = stringResource(R.string.minus)
                    )
                }
            }
        }
    }
    if (mostrarNumDias) {
        Row(modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center) {
            Text(
                text = stringResource(R.string.ha_elegido) + numDias + stringResource(R.string.dias),
                textAlign = TextAlign.Center
            )
        }
    }
    return numDias
}

@Composable
fun MuestraBotones (modifier: Modifier = Modifier,
                    tipo: String,
                    gps: Boolean,
                    tipoCombustible: String,
                    cilindrada: Int,
                    numDias: Int,
                    precioFinal: Double,
                    imagen: Int) : Boolean
{
    var aceptar by remember { mutableStateOf(false) }
    var nuevoPedido by remember { mutableStateOf<Pedido?> (null) }
    Row (modifier = Modifier
        .fillMaxWidth()
        .padding(16.dp), horizontalArrangement = Arrangement.Center){
        Button(onClick = {aceptar = true
                         nuevoPedido = GeneracionPedido(tipo, gps, tipoCombustible, cilindrada, numDias, precioFinal, imagen)
        }, Modifier.padding(10.dp), colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_200))) {
            Text(
                text = stringResource(R.string.reservar)
            )
        }
        Button(onClick = {aceptar = false}, Modifier.padding(10.dp), colors = ButtonDefaults.buttonColors(containerColor = colorResource(id = R.color.purple_500))) {
            Text(
                text = stringResource(R.string.cancelar)
            )
        }
    }
    if(aceptar && nuevoPedido != null)
    {
        var tenerGps by remember { mutableStateOf("No") }
        if (gps==true)
        {
            tenerGps = "Sí"
        }
        Column(modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(
                text =   "Reserva realizada: ",
                textAlign = TextAlign.Center
            )
            Text(
                text =   "\nVehiculo: "+ nuevoPedido!!.vehiculo
                        +"\nGPS: "+ tenerGps
                        +"\nTipo de combustible: "+ nuevoPedido!!.tipoCombustible+" (Solo coches)"
                        +"\nCilindrada: "+ nuevoPedido!!.cilindrada+" (Solo motos)"
                        +"\nNúmero de dias: "+nuevoPedido!!.numDias
                        +"\nPrecio final: "+ nuevoPedido!!.precioTotal,
                modifier.padding(16.dp)
            )



        }
    }
    return aceptar
}

@Composable
fun CalculoPrecioFinal (tipoVehiculo: String ,precioCombustible: Int, gps: Boolean, cilindrada: Int, numDias: Int) : Double
{
    var precioFinal: Double = 0.0
    var precioGps: Int =0
    var precioCilindrada: Int =0
    when (gps)
    {
        true -> {precioGps = 5}
        false -> {precioGps = 0}
    }
    when (cilindrada)
    {
        250 -> {precioCilindrada = 20}
        125 -> {precioCilindrada = 15}
        50 -> {precioCilindrada = 10}
    }

    when(tipoVehiculo)
    {
        "Coche" ->
        {
            precioFinal=((numDias*precioCombustible)+(numDias*precioGps)).toDouble()
        }
        "Moto" ->
            {
            precioFinal=((numDias*precioCilindrada)+(numDias*precioGps)).toDouble()
            }
        "Patinete" ->
        {
            precioFinal=((numDias*5)+(numDias*precioGps)).toDouble()
        }
    }

    return precioFinal
}

@Composable
fun BotonesFinales(
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
            Text(text = stringResource(R.string.cancelar))
        }
    }
}


fun GeneracionPedido(
    tipo: String,
    gps: Boolean,
    tipoCombustible: String,
    cilindrada: Int,
    numDias: Int,
    precioFinal: Double,
    imagen: Int
): Pedido {
    // Crea y devuelve una nueva instancia de Pedido
    return Pedido(tipo, gps, tipoCombustible, cilindrada, numDias, precioFinal, imagen)
}