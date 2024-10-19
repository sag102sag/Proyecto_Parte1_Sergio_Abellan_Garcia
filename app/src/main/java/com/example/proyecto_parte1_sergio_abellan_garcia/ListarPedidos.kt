package com.example.proyecto_parte1_sergio_abellan_garcia

import android.graphics.Color.rgb
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CenterAlignedTopAppBar
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
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyecto_parte1_sergio_abellan_garcia.clases.Pedido
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos


@Composable
fun VistaListaPedidos(modifier: Modifier = Modifier)
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
            ListaPedidos(
                modifier = Modifier,
                lista = Datos().PedidosPrueba(modifier)
            )


        }
    }
}

@Composable
fun ListaPedidos (modifier: Modifier=Modifier, lista: List<Pedido>)
{
    var mostrar by remember { mutableStateOf(false) }
        Row (Modifier.padding(40.dp), horizontalArrangement = Arrangement.Center){
            Column (Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally){
            Text(
                text = "Lista de pedidos"
            )
            Spacer(modifier.size(16.dp))

                Card(modifier = Modifier.background(Color(rgb(242, 242, 242)))) {
                    Row (modifier= Modifier
                        .fillMaxWidth()
                        .clickable { mostrar = !mostrar }
                        .background(Color(rgb(242, 242, 242))),
                        horizontalArrangement = Arrangement.Center)
                    {
                        Column (horizontalAlignment = Alignment.CenterHorizontally){
                            Text(
                                text = "Toca aquí para ver tu lista de pedidos",
                                textAlign = TextAlign.Center,
                                modifier = Modifier.padding(16.dp)
                            )

                        if (mostrar) {
                            LazyColumn(
                                modifier = modifier.padding(16.dp),
                                horizontalAlignment = Alignment.CenterHorizontally
                            )
                            {
                                items(lista) { pedido ->
                                    TarjetaPedido(modifier = Modifier, pedido = pedido)
                                }
                            }
                            Text(
                                text = stringResource(R.string.pulsa_sobre_cualquier_pedido_para_ver_m_s_informaci_n),
                                textAlign = TextAlign.Center,
                                fontStyle = FontStyle.Italic,
                                modifier = Modifier.padding(start = 50.dp, end = 50.dp, top = 10.dp, bottom = 20.dp)
                            )
                            Row (modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Center){
                                Button( onClick = {}, Modifier.padding(bottom = 35.dp)) {
                                    Text(
                                        text = stringResource(R.string.a_adir)
                                    )
                                }
                            }
                        }
                        }
                }
            }
        }
    }
}
@Composable
fun TarjetaPedido(modifier: Modifier=Modifier, pedido: Pedido)
{
    Card (modifier = Modifier
        .clickable { PestanaResumen(pedido) }
        .padding(5.dp)){


            if (pedido.vehiculo == "Coche") {
                Row (
                    modifier
                        .fillMaxWidth()
                        .background(Color(0xFFADD8E6))) {
                    Image(
                        painter = painterResource(R.drawable.caricon),
                        contentDescription = stringResource(R.string.icono_de_coche),
                        modifier
                            .padding(16.dp)
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.cocheB),
                        modifier
                            .padding(16.dp)
                            .padding(start = 20.dp),

                    )
                }
            }
            else if (pedido.vehiculo == "Moto") {
                Row (
                    modifier
                        .fillMaxWidth()
                        .background(Color(0xFFFFC0CB))) {
                    Image(
                        painter = painterResource(R.drawable.motorbikeicon),
                        contentDescription = stringResource(R.string.icono_de_moto),
                        modifier
                            .padding(16.dp)
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.moto),
                        modifier
                            .padding(16.dp)
                            .padding(start = 20.dp)
                    )
                }
            }
            else{
                Row (
                    modifier
                        .fillMaxWidth()
                        .background(Color(0xFF90EE90))) {
                    Image(
                        painter = painterResource(R.drawable.kickscootericon),
                        contentDescription = stringResource(R.string.icono_de_patinete),
                        modifier
                            .padding(16.dp)
                            .size(30.dp)
                    )
                    Text(
                        text = stringResource(R.string.patinete),
                        modifier
                            .padding(16.dp)
                            .padding(start = 20.dp)
                    )
                }
            }
    }
}

fun PestanaResumen(pedido: Pedido)
{

}


