package com.example.lost_and_found.ui.screens.profile

import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lost_and_found.firebase.services.AuthService
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor(
    private val authService: AuthService,
    private val auth: FirebaseAuth,
) : ViewModel() {

    val displayName get() = auth.currentUser?.displayName.toString()
    val photoUri get() = authService.customPhotoUri
    val email get() = auth.currentUser?.email.toString()

    fun signOut() {
        viewModelScope.launch { authService.signOut() }
    }

    fun updatePhotoUri(uri: Uri) {
        viewModelScope.launch { authService.updatePhoto(uri) }
    }
}