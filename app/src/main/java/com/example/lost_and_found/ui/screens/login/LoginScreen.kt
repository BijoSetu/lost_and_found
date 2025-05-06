//package com.example.lost_and_found.ui.screens.login
//
//import android.widget.Toast
//import androidx.compose.foundation.background
//import androidx.compose.foundation.layout.Box
//import androidx.compose.foundation.layout.Column
//import androidx.compose.foundation.layout.Spacer
//import androidx.compose.foundation.layout.fillMaxSize
//import androidx.compose.foundation.layout.height
//import androidx.compose.foundation.layout.padding
//import androidx.compose.foundation.rememberScrollState
//import androidx.compose.foundation.verticalScroll
//import androidx.compose.material.Surface
//import androidx.compose.runtime.Composable
//import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.remember
//import androidx.compose.runtime.setValue
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.contentcapture.ContentCaptureManager.Companion.isEnabled
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.input.key.Key.Companion.Home
//import androidx.compose.ui.platform.LocalContext
//import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.res.stringResource
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.dp
//import androidx.hilt.navigation.compose.hiltViewModel
//import androidx.navigation.NavController
//import com.example.lost_and_found.R
//import com.example.lost_and_found.ui.components.login.ButtonComponent
//import com.example.lost_and_found.ui.components.login.HeadingLogoComponent
//import com.example.lost_and_found.ui.components.login.HeadingTextComponent
//import com.example.lost_and_found.ui.components.login.MyTextFieldComponent
//import com.example.lost_and_found.ui.components.login.PasswordTextFieldComponent
//import com.example.lost_and_found.ui.components.login.UnderLinedTextComponent
//
//@Composable
//fun LoginScreen(
//
//) {
//
//    Box(
//        modifier = Modifier.fillMaxSize().verticalScroll(rememberScrollState()),
//        contentAlignment = Alignment.Center
//    ) {
//        Surface(
//            modifier = Modifier
//                .fillMaxSize()
//                .background(Color.White)
//                .padding(28.dp)
//        ) {
//            Column(
//                modifier = Modifier
//                    .fillMaxSize()
//            ) {
//                HeadingTextComponent(value = stringResource(id = R.string.welcome))
//                Spacer(modifier = Modifier.height(20.dp))
//                HeadingLogoComponent()
//                Spacer(modifier = Modifier.height(20.dp))
//
//                MyTextFieldComponent(labelValue = stringResource(id = R.string.email),
//                    painterResource(id = R.drawable.message),
//                    onTextChanged = {
////                        loginViewModel.onEvent(LoginUIEvent.EmailChanged(it))
//                    },
////                    errorStatus = loginViewModel.loginUIState.value.emailError
//                )
//
//                PasswordTextFieldComponent(
//                    labelValue = stringResource(id = R.string.password),
//                    painterResource(id = R.drawable.lock),
//                    onTextSelected = {
////                        loginViewModel.onEvent(LoginUIEvent.PasswordChanged(it))
//                    },
////                    errorStatus = loginViewModel.loginUIState.value.passwordError
//                )
//
//                Spacer(modifier = Modifier.height(20.dp))
//                UnderLinedTextComponent(value = stringResource(id = R.string.forgot_password))
//
//                Spacer(modifier = Modifier.height(30.dp))
//
////                ButtonComponent(
////                    value = stringResource(id = R.string.login),
////                    onButtonClicked = {
////                        loginViewModel.onEvent(LoginUIEvent.LoginButtonClicked)
////                        onLogin()
////                    },
////                    isEnabled = loginViewModel.allValidationsPassed.value
////                )
////                isEnabled = loginViewModel.allValidationsPassed.value
//            }
//        }
//    }
//
//}
//
//
//@Preview(showBackground = true)
//@Composable
//fun LoginScreenPreview() {
//    LoginScreen()
//}