package com.example.proyecto_parte1_sergio_abellan_garcia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyHorizontalGrid
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyecto_parte1_sergio_abellan_garcia.modelo.Usuario
import com.example.proyecto_parte1_sergio_abellan_garcia.ui.theme.Proyecto_Parte1_Sergio_Abellan_GarciaTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Proyecto_Parte1_Sergio_Abellan_GarciaTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    MuestraDatosUsuario(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}




@Composable
fun MuestraDatosUsuario(modifier: Modifier = Modifier)
{
    val datos = Datos()
    val usuario = datos.CargarUsuario()
    val tamanyoFuente: Int = 18
    Card(
        modifier = modifier.padding(16.dp),
        shape = RoundedCornerShape(25.dp)

    ) {
        Row(modifier = Modifier
            .fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically,
        )
        {
            Image(
               painter = painterResource(usuario.imagenUsuario),
               contentDescription = "Usuario",
                modifier = modifier.padding(16.dp).clip(RoundedCornerShape(50.dp))

            )
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                verticalArrangement = Arrangement.spacedBy(8.dp),
                horizontalArrangement = Arrangement.spacedBy(8.dp),
                modifier = modifier.padding(0.dp)
            ) {
                item {
                Text(
                    text = stringResource(R.string.nombre)+"\n" + stringResource(usuario.nombreUsuario),
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = tamanyoFuente.sp
                )
                }
                item {
                    Text(
                        text = stringResource(R.string.apellido)+"\n" + stringResource(usuario.apellido),
                        modifier = Modifier.padding(10.dp),
                        style = MaterialTheme.typography.headlineSmall,
                                fontSize = tamanyoFuente.sp
                    )
                }
                item {
                Text(
                    text = stringResource(R.string.correo_electr_nico)+"\n" + stringResource(usuario.nombreUsuario),
                    modifier = Modifier.padding(10.dp),
                    style = MaterialTheme.typography.headlineSmall,
                    fontSize = tamanyoFuente.sp
                )
                }
                item {
                Text(
                    text = "Número de teléfono: \n" + usuario.numeroTelefono,
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
fun MostrarBotones()
{

}