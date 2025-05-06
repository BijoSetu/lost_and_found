package com.example.lost_and_found.ui.components.profile

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.Image
import androidx.compose.material3.Text


@Composable
fun ProfileHeader(userName: String, userDescription: String, profileImage: Int) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
            .background(Color(0xFFf7f7f7))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        // Profile Image
        Box(
            modifier = Modifier
                .size(120.dp)
                .border(2.dp, Color.Gray, shape = CircleShape)
                .padding(4.dp)
        ) {
            Image(painter = painterResource(id = profileImage), contentDescription = null)
        }

        Spacer(modifier = Modifier.height(16.dp))

        // User Name
        Text(text = userName, fontSize = 22.sp, fontWeight = FontWeight.Bold)

        // User Description
        Text(text = userDescription, fontSize = 14.sp, color = Color.Gray)
    }
}