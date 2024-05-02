package com.example.testpusher

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.testpusher.component.HomeScreen
import com.example.testpusher.component.SecondScreen
import com.example.testpusher.ui.theme.PusherViewModel

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            val navController = rememberNavController()
            NavHost(navController = navController, startDestination = "SecondScreen") {
                composable("HomeScreen") {
                    HomeScreen(navController)
                }
                composable("SecondScreen") {
                    SecondScreen(navController)
                }
            }
            val viewModel: PusherViewModel = viewModel()
        }
    }
}

@Composable
fun testUI() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .border(10.dp, Color.Green, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .border(10.dp, Color.Blue, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
            .border(10.dp, Color.Red, shape = RoundedCornerShape(10.dp))
            .padding(10.dp)
    ) {
        Text(text = "Jetpack", color = Color.White)
        Spacer(modifier = Modifier.height(100.dp))
        Text(text = "Compose", color = Color.White)
    }
}

@SuppressLint("UnrememberedMutableState")
@Composable
fun MyAlertDialog(
    onCloseDialog: () -> Unit
) {
    val showDialog by remember { mutableStateOf(true) }
    val color = mutableStateOf(Color.Blue)

    if (showDialog) {
        AlertDialog(
            onDismissRequest = onCloseDialog,
            title = {
                Text(
                    style = TextStyle(
                        color = color.value,
                    ), text = "Alert Title"
                )
            },
            text = {
                Text(
                    text = "Alert Message", style = TextStyle(
                        color = Color.Black,
                        fontWeight = FontWeight(600)
                    )
                )
            },
            confirmButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    onClick = {
                        onCloseDialog.invoke()
                        color.value = Color.White
                    }
                ) {
                    Text(text = "+ve Click")
                }
            },
            dismissButton = {
                Button(
                    colors = ButtonDefaults.buttonColors(containerColor = Color.Blue),
                    onClick = {
                        onCloseDialog.invoke()
                        color.value = Color.White
                    }
                ) {
                    Text(text = "-ve Click")
                }
            }
        )
    }
}

@Preview
@Composable
fun ShowTestUI() {
    MyAlertDialog(onCloseDialog = {})
}
