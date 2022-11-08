package din.U1_2

import android.os.Build
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.time.LocalDate
import java.util.*

class MainActivity : ComponentActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Horoscopo(name = "Horóscopo del día")
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun Horoscopo(name: String) {
    var suerte = mapOf(
        "-" to 0,
        "*" to 1,
        "**" to 2,
        "***" to 3
    )
    var amor by remember { mutableStateOf(suerte.map { it.key }.random()) }
    var dinero by remember { mutableStateOf(suerte.map { it.key }.random()) }
    var salud by remember { mutableStateOf(suerte.map { it.key }.random()) }
    var trabajo by remember { mutableStateOf(suerte.map { it.key }.random()) }
    var suerteGeneral = media("Juan Manuel")
    val imagenHoroscopo = painterResource(R.drawable.horoscopo1)

    androidx.compose.material3.Surface(
        color = Color.LightGray,
        modifier = Modifier
            .fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.Top,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "$name",
                    modifier = Modifier.padding(horizontal = 10.dp, vertical = 10.dp),
                    color = Color.White,
                    fontFamily = FontFamily.Cursive,
                    fontStyle = FontStyle.Italic,
                    fontWeight = FontWeight.Bold,
                    fontSize = 45.sp
                )
            }
            Row(
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Amor: $amor",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Dinero: $dinero",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Salud: $salud",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Trabajo: $trabajo",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }
            Row (
                horizontalArrangement = Arrangement.Center,
                verticalAlignment = Alignment.CenterVertically
            ){
                Text(
                    text = "Suerte general: $suerteGeneral",
                    modifier = Modifier.padding(vertical = 10.dp),
                    fontWeight = FontWeight.SemiBold,
                    fontFamily = FontFamily.SansSerif,
                    fontStyle = FontStyle.Italic,
                    fontSize = 20.sp
                )
            }
        }
        Row(
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ) {
            Image(
                painter = imagenHoroscopo,
                contentDescription = "",
                modifier = Modifier
                    .clip(RectangleShape)
                    .size(300.dp)
                    .padding(vertical = 30.dp)
                    .wrapContentSize(Alignment.BottomStart)
                    .clickable {
                        amor = suerte.map { it.key }.random()
                        dinero = suerte.map { it.key }.random()
                        salud = suerte.map { it.key }.random()
                        trabajo = suerte.map { it.key }.random()
                    }
            )
        }
        /*Row (
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.Bottom
        ){
            OutlinedButton(onClick = {
                amor = suerte.map { it.key }.random()
                dinero = suerte.map { it.key }.random()
                salud = suerte.map { it.key }.random()
                trabajo = suerte.map { it.key }.random()
            }, modifier = Modifier.padding(vertical = 0.dp)) {
                Text(
                    text = "Pulsa para saber tu horóscopo",
                    style = androidx.compose.ui.text.TextStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = FontFamily.SansSerif,
                        fontStyle = FontStyle.Italic,
                        fontSize = 20.sp
                    )
                )
            }
        }*/
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun media(nombre: String): String {
    val days: List<String> = listOf("MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY")
    val dias: List<String> = listOf("LUNES","MARTES","MIERCOLES","JUEVES","VIERNES","SABADO","DOMINGO")
    val day = LocalDate.now().dayOfWeek.name
    var dia = ""
    val nombreSinEspacios = nombre.filterNot { it.isWhitespace() }.lowercase()
    val nombreSinEspaciosListaChar: CharArray = nombreSinEspacios.toCharArray()
    val numeroLetrasNombre = nombreSinEspacios.count()
    var numeroLetrasCoincidentes = 0
    var suerte = ""

    for (i in days.indices) { if (day == days[i]) { dia = dias[i].lowercase() } }

    for (ch in nombreSinEspaciosListaChar) {
        val coincidencias = dia.filter { it == ch }.count()
        numeroLetrasCoincidentes += coincidencias
    }

    val x = ((numeroLetrasCoincidentes / numeroLetrasNombre) * 4).toInt()
    when {
        (x in 0..1) -> suerte = "*"
        (x in 1..2) -> suerte = "**"
        (x in 2..3) -> suerte = "***"
        (x in 3..4) -> suerte = "****"
    }
    return suerte
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Horoscopo("Horóscopo del día")
}