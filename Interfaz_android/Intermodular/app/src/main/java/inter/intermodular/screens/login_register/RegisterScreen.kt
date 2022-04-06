package inter.intermodular.screens.login_register

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.orhanobut.logger.Logger
import inter.intermodular.R
import inter.intermodular.ScreenNav
import inter.intermodular.support.backRegister
import inter.intermodular.support.clientCreated
import inter.intermodular.view_models.LoginRegisterViewModel
import androidx.compose.material.OutlinedTextField as OutlinedTextField1

@Composable
fun Register(navController: NavController, loginRegisterViewModel: LoginRegisterViewModel){

    val name = remember { mutableStateOf("")}
    val email = remember { mutableStateOf("")}
    val password1 = remember { mutableStateOf("")}
    val password2 = remember { mutableStateOf("")}

    var passwordVisibility by remember { mutableStateOf(false) }

    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 50.dp)

    ){

        Spacer(modifier = Modifier.height(5.dp))

        Text(text = "REGISTRO",
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField1(
            value = name.value,
            onValueChange = { name.value = it },
            label = { Text(text = "Nombre", style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            placeholder = { Text(text = "Nombre",style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            singleLine = true,
            trailingIcon = {
                val image = Icons.Filled.AccountCircle
                Icon(imageVector = image, "Nombre")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.azul_oscuro),
                unfocusedBorderColor = colorResource(id = R.color.gris_claro),
                focusedLabelColor = colorResource(id = R.color.azul_oscuro),
                unfocusedLabelColor = colorResource(id = R.color.gris_claro),
                cursorColor = colorResource(id = R.color.azul)
            ),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField1(
            value = email.value,
            onValueChange = { email.value = it },
            label = { Text(text = "Email", style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            placeholder = { Text(text = "Email",style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            singleLine = true,
            trailingIcon = {
                val image = Icons.Filled.Email
                Icon(imageVector = image, "Email")
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.azul_oscuro),
                unfocusedBorderColor = colorResource(id = R.color.gris_claro),
                focusedLabelColor = colorResource(id = R.color.azul_oscuro),
                unfocusedLabelColor = colorResource(id = R.color.gris_claro),
                cursorColor = colorResource(id = R.color.azul)
            ),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField1(
            value = password1.value,
            onValueChange = { password1.value = it },
            label = { Text(text = "Password", style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            placeholder = { Text(text = "Password",style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisibility = !passwordVisibility }
                ) { Icon(imageVector  = image, "Password") }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.azul_oscuro),
                unfocusedBorderColor = colorResource(id = R.color.gris_claro),
                focusedLabelColor = colorResource(id = R.color.azul_oscuro),
                unfocusedLabelColor = colorResource(id = R.color.gris_claro),
                cursorColor = colorResource(id = R.color.azul)
            ),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(18.dp))

        OutlinedTextField1(
            value = password2.value,
            onValueChange = { password2.value = it },
            label = { Text(text = "Repite Password", style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            placeholder = { Text(text = "Repite Password",style = TextStyle(
                color = colorResource(id = R.color.gris_claro)),) },
            singleLine = true,
            visualTransformation = if (passwordVisibility) VisualTransformation.None else PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
            trailingIcon = {
                val image = if (passwordVisibility) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
                IconButton(onClick = { passwordVisibility = !passwordVisibility }
                ) { Icon(imageVector  = image, "Repite Password") }
            },
            colors = TextFieldDefaults.outlinedTextFieldColors(
                focusedBorderColor = colorResource(id = R.color.azul_oscuro),
                unfocusedBorderColor = colorResource(id = R.color.gris_claro),
                focusedLabelColor = colorResource(id = R.color.azul_oscuro),
                unfocusedLabelColor = colorResource(id = R.color.gris_claro),
                cursorColor = colorResource(id = R.color.azul)
            ),
            modifier = Modifier.fillMaxWidth(),
        )

        Spacer(modifier = Modifier.height(40.dp))

        Button(
            onClick = {
                if(email.value.isEmpty() || password1.value.isEmpty() || password2.value.isEmpty()){
                    Logger.e("Email or password Register is null or empty")
                }else{
                    if(password1.value == password2.value){
                        clientCreated = false
                        backRegister = true
                        loginRegisterViewModel.checkEmail(email.value)
                        navController.navigate(ScreenNav.ValidateRegisterScreen.withArgs(name.value,email.value,password1.value))
                    }
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.azul)),

            ){
            Text(
                text = "REGISTRO",
                fontWeight = FontWeight.ExtraBold,
                color = Color.White
            )
        }
    }
}

