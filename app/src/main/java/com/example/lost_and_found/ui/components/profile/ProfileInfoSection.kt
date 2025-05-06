package com.example.lost_and_found.ui.components.profile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp


// Personal Info Section Composable
@Composable
fun PersonalInfoSection(name: String, email: String, location: String) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Name
        InfoRow(label = "Name", value = name)

        // Email
        InfoRow(label = "Email", value = email)

        // Location
        InfoRow(label = "Location", value = location)
    }
}