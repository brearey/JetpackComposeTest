package ru.oktemsec.jetpackcomposetest

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.AlertDialog
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionContext
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Column (Modifier.verticalScroll(rememberScrollState(), enabled = true)) {
                for(i in 0..9) {
                    Row (
                        Modifier
                            .padding(8.dp)
                            .clickable {

                            }
                    ) {
                        Image(
                            painter = painterResource(id = R.drawable.aes),
                            contentDescription = "Абрамов Евгений Семенович молодой",
                            Modifier
                                .width(60.dp)
                                .clip(CircleShape)
                                .border(2.dp, Color.Black, CircleShape)
                        )
                        Column (Modifier.padding(horizontal = 8.dp)) {
                            MyWidget("$i $i $i $i $i", "Абрамов", 16.sp)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun MessageCard(name:String) {
        Text(text="Hello $name")
    }
    
    @Composable
    fun MyWidget(name:String, surname:String, fontSize: TextUnit) {
        Column () {
            Text(text ="Имя: $name", fontSize = fontSize)
            Text(text ="Фамилия: $surname", fontSize = fontSize)
        }
    }

    @Composable
    fun MyText(value1:String) {
        Text(text = value1, fontSize = 18.sp)
    }

    @Preview
    @Composable
    fun PreviewMessageCard() {
        MessageCard(name = "Jeka")
    }

    @Composable
    fun MyAlertDialog(title:String, body:String) {
        MaterialTheme {
            AlertDialog(
                onDismissRequest = {},
                title = { Text(title) },
                text = { Text(body) },
                confirmButton = {  Button( onClick = {} ) {Text("Ok")}  },
                dismissButton = {  Button( onClick = {} ) {Text("Dismiss")} }
            )
        }
    }


}