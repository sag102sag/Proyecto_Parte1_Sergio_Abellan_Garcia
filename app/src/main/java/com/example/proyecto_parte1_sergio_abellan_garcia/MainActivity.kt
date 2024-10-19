package com.example.proyecto_parte1_sergio_abellan_garcia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_parte1_sergio_abellan_garcia.datos.Datos
import com.example.proyecto_parte1_sergio_abellan_garcia.ui.theme.Proyecto_Parte1_Sergio_Abellan_GarciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto_Parte1_Sergio_Abellan_GarciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    PantallaInicial(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun PantallaInicial(modifier: Modifier = Modifier)
{
/*
    Column (

        modifier= modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.Top
    ) {
        DatosUsuario()
        Botones()
    }
*/
    VistaPedidos(
        modifier = Modifier
    )


}


@Composable
fun DatosUsuario(modifier: Modifier = Modifier) {
    val datos = Datos()
    val usuario = datos.CargarUsuario()
    val tamanyoFuente: Int = 18
    Row(
        Modifier
            .padding(16.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        Text(text = "¡Bienvenido de nuevo!")
    }

    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(25.dp)
    ) {
        Row(
            modifier = Modifier,
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Row (modifier = Modifier.align(Alignment.Top)){

                Image(
                    painter = painterResource(usuario.imagenUsuario),
                    contentDescription = "Usuario",
                    modifier = modifier
                        .padding(
                            top = 25.dp,
                            start = 16.dp,
                            end = 16.dp
                        )
                        .clip(RoundedCornerShape(25.dp))
                )
            }
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.padding(0.dp)
            ) {
                item {
                    Text(
                        text = stringResource(R.string.nombre) + "\n" + stringResource(usuario.nombreUsuario),
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = tamanyoFuente.sp
                    )
                }
                item {
                    Text(
                        text = stringResource(R.string.apellido) + "\n" + stringResource(usuario.apellido),
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = tamanyoFuente.sp
                    )
                }
                item {
                    Text(
                        text = stringResource(R.string.correo_electr_nico) + "\n" + stringResource(
                            usuario.correoElectronico
                        ),
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = tamanyoFuente.sp
                    )
                }
                item {
                    Text(
                        text = stringResource(R.string.n_mero_de_tel_fono) + usuario.numeroTelefono,
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall,
                        fontSize = tamanyoFuente.sp
                    )
                }
            }
        }
    }
}
    @Composable
    fun Botones(modifier: Modifier = Modifier) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(bottom = 70.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Bottom
        ) {
            Row(
                Modifier
                    .padding(16.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                Text(text = stringResource(R.string.elige_que_quieres_hacer))
            }
            Spacer(modifier.size(20.dp))
            Button(onClick = {},
                modifier
                    .height(60.dp)
                    .width(180.dp)) {
                Text(
                    text = stringResource(R.string.realizar_pedido),
                    fontSize = 15.sp
                )
            }
            Spacer(modifier.size(20.dp))
            Button(onClick = {},
                modifier
                    .height(60.dp)
                    .width(180.dp)) {
                Text(
                    stringResource(R.string.listar_pedidos),
                    fontSize = 15.sp
                )

            }
        }
    }


