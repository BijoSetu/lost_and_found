package com.example.lost_and_found.ui.components.profile

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.material3.OutlinedButton


@Composable
fun ProfileActions(onEditClicked: () -> Unit, onLogoutClicked: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Edit Profile Button
        Button(
            onClick = onEditClicked,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 8.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
        ) {
            Text(text = "Edit Profile Picture", color = Color.White)
        }

        // Log Out Button
        OutlinedButton(
            onClick = onLogoutClicked,
            modifier = Modifier.fillMaxWidth(),
            border = BorderStroke(1.dp, Color.Gray)
        ) {
            Text(text = "Log Out", color = Color.Gray)
        }
    }
}