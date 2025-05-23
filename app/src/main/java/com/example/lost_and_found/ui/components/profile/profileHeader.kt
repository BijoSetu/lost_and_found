package com.example.lost_and_found.ui.components.profile

import android.net.Uri
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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Text
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale.Companion.Crop
import androidx.compose.ui.platform.LocalContext
import coil.compose.AsyncImage
import coil.request.ImageRequest


@Composable
fun ProfileHeader(userName: String, userDescription: String, profileImage: Int?=null,photoUri: Uri?= null) {
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
        ) {if(photoUri.toString().isNotEmpty())
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(photoUri)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                contentScale = Crop,
                modifier = Modifier.clip(CircleShape).width(180.dp).height(180.dp)
            )else
                Image(
                painter = painterResource(id = profileImage!!),
                contentDescription = null,
                contentScale = Crop,
                modifier = Modifier.clip(CircleShape).width(180.dp).height(180.dp))
        }

        Spacer(modifier = Modifier.height(16.dp))

        // User Name
        Text(text = userName, fontSize = 22.sp, fontWeight = FontWeight.Bold)

        // User Description
        Text(text = userDescription, fontSize = 14.sp, color = Color.Gray)
    }
}