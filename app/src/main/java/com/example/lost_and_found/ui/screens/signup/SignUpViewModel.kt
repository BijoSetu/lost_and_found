package com.example.lost_and_found.ui.screens.signup


import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lost_and_found.data.rules.Validators
import com.example.lost_and_found.firebase.auth.Response
import com.example.lost_and_found.firebase.services.AuthService
import com.example.lost_and_found.firebase.services.FirebaseSignInResponse
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class SignUpViewModel @Inject constructor(
    private val auth: FirebaseAuth,
    private val authService: AuthService,
)
    : ViewModel() {

    var registrationUIState = mutableStateOf(SignUpUiState())
    var allValidationsPassed = mutableStateOf(false)
    var signUpInProgress = mutableStateOf(false)

    private val _signupFlow = MutableStateFlow<FirebaseSignInResponse?>(null)
    val signupFlow: StateFlow<FirebaseSignInResponse?> = _signupFlow

    fun signUpUser() = viewModelScope.launch {
        _signupFlow.value = Response.Loading

        val result = authService.createUser(
            name = registrationUIState.value.firstName,
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
        _signupFlow.value = result
    }

    fun onEvent(event: RegisterUIEvent) {
        when (event) {
            is RegisterUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
            }

            is RegisterUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
            }

            is RegisterUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
            }

            is RegisterUIEvent.RegisterButtonClicked -> {
                signUpUser()
            }

            is RegisterUIEvent.PrivacyPolicyCheckBoxClicked -> {
                registrationUIState.value = registrationUIState.value.copy(
                    privacyPolicyAccepted = event.status
                )
            }
        }
        validateDataWithRules()
    }


    private fun validateDataWithRules() {
        val fNameResult = Validators.validateFirstName(
            fName = registrationUIState.value.firstName
        )

        val emailResult = Validators.validateEmail(
            email = registrationUIState.value.email
        )

        val passwordResult = Validators.validatePassword(
            password = registrationUIState.value.password
        )

        val privacyPolicyResult = Validators.validatePrivacyPolicyAcceptance(
            statusValue = registrationUIState.value.privacyPolicyAccepted
        )

        registrationUIState.value = registrationUIState.value.copy(
            firstNameError = fNameResult.status,
            emailError = emailResult.status,
            passwordError = passwordResult.status,
            privacyPolicyError = privacyPolicyResult.status
        )

        allValidationsPassed.value = fNameResult.status && emailResult.status &&
                passwordResult.status && privacyPolicyResult.status
    }

    fun resetRegisterFlow() {
        _signupFlow.value = null
    }
}
