package com.example.lost_and_found.ui.screens.profile

import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lost_and_found.R
import com.example.lost_and_found.ui.components.general.ShowPhotoPicker
import com.example.lost_and_found.ui.components.profile.PersonalInfoSection
import com.example.lost_and_found.ui.components.profile.ProfileActions
import com.example.lost_and_found.ui.components.profile.ProfileHeader
import com.example.lost_and_found.ui.screens.login.LoginViewModel
import com.example.lost_and_found.ui.screens.signup.SignUpViewModel


@Composable
fun ProfileScreen(onSignOut: () -> Unit = {},
                  profileViewModel: ProfileViewModel = hiltViewModel(),
                  loginViewModel: LoginViewModel = hiltViewModel(),
                  signUpViewModel: SignUpViewModel = hiltViewModel()) {

    var photoUri: Uri? by remember { mutableStateOf(profileViewModel.photoUri) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF1F1F1))
            .padding(bottom = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Header Section
        if(photoUri.toString().isNotEmpty())
        ProfileHeader(userName = profileViewModel.displayName, userDescription = "Android Developer",profileImage = R.drawable.profile_image ,photoUri=photoUri)
        else
            ProfileHeader(userName = profileViewModel.displayName, userDescription = "Android Developer", profileImage = R.drawable.profile_image)

        // Personal Info Section
        PersonalInfoSection(name = profileViewModel.displayName, email = profileViewModel.email
            , location = "New York, USA")
        // Center the picker in the screen
        ShowPhotoPicker(
            onPhotoUriChanged = {
                photoUri = it
                profileViewModel.updatePhotoUri(photoUri!!)
            },
        )

        // Profile Actions Section
        ProfileActions(
            onPhotoUriChanged = {
//                photoUri = it
//                profileViewModel.updatePhotoUri(photoUri!!)
            },
            onLogoutClicked = {
                profileViewModel.signOut()
                onSignOut()
                loginViewModel.resetLoginFlow()
                signUpViewModel.resetRegisterFlow()
            }
        )

    }
}

