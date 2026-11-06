package com.example.koel.screens

import android.app.Activity
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import com.example.koel.R


@Composable
fun LoginScreen(onLogin: (String) -> Unit){

    var user by remember {mutableStateOf("")}
    var password by remember {mutableStateOf("")}
    var mostrarPassword by remember {mutableStateOf(false)}

    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize().padding(20.dp)
    ) {

        Text(
            text = "KOEL v1.0 Sara Paraschiv",
            modifier = Modifier.align(Alignment.TopCenter)
                .padding(top = 8.dp),
            style = MaterialTheme.typography.bodySmall
        )
        Column(
            modifier = Modifier.fillMaxWidth().align(Alignment.Center),
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            Image(
                painter = painterResource(id = R.drawable.logo_k),
                contentDescription = "Logo KOEL",
                modifier = Modifier.size(100.dp)
            )
            Spacer(modifier = Modifier.height(20.dp))
            Text(
                text = "Bienvenido a KOEL",
                style = MaterialTheme.typography.headlineSmall
            )

            Spacer(modifier = Modifier.height(35.dp))


            OutlinedTextField(
                value= user,
                onValueChange = {user = it},
                label={Text("Usuario")},
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(13.dp))

            OutlinedTextField(
                value= password,
                onValueChange = { password = it },
                label = { Text("Contraseña") },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = if (mostrarPassword) {
                    VisualTransformation.None
                } else {
                    PasswordVisualTransformation()
                },
                trailingIcon = {
                    TextButton(
                        onClick = {mostrarPassword = !mostrarPassword }
                    ) {
                        Text(if (mostrarPassword) "Ocultar" else "Mostrar")
                    }
                }
            )
            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick={},
                modifier = Modifier.fillMaxWidth()
            ){
                Text("Registro")
            }
            Spacer(modifier = Modifier.height(10.dp))
            Button(
                onClick = {
                    if(user.isEmpty() || password.isBlank()){
                        Toast.makeText(context, "Introduce tu USUARIO y CONTRASEÑA", Toast.LENGTH_SHORT).show()
                    } else{
                        onLogin(user)
                    }
                }, modifier = Modifier.fillMaxWidth()
            ){Text("Iniciar sesión")}
            Spacer(modifier = Modifier.height(10.dp))
            Text("O inicia sesión con")

            Row(
                horizontalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                OutlinedButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "No implementado",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Text("Google")
                }

                OutlinedButton(
                    onClick = {
                        Toast.makeText(
                            context,
                            "No implementado",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                ) {
                    Text("Facebook")
                }


            }
        }
        FloatingActionButton(
            onClick = {
                (context as? Activity)?.finish()
            }, modifier = Modifier.align(Alignment.BottomEnd)
        ){
            Text("X")
        }

        }
    }



