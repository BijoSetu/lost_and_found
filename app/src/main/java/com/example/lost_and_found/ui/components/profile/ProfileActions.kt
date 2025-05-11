package com.example.lost_and_found.ui.components.profile

import android.content.Intent
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext


//@Composable
//fun ProfileActions(onEditClicked: () -> Unit, onLogoutClicked: () -> Unit) {
//    Column(
//        modifier = Modifier
//            .fillMaxWidth()
//            .padding(16.dp)
//    ) {
//        // Edit Profile Button
//        Button(
//            onClick = onEditClicked,
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
//        ) {
//            Text(text = "Edit Profile Picture", color = Color.White)
//        }
//
//        // Log Out Button
//        OutlinedButton(
//            onClick = onLogoutClicked,
//            modifier = Modifier.fillMaxWidth(),
//            border = BorderStroke(1.dp, Color.Gray)
//        ) {
//            Text(text = "Log Out", color = Color.Gray)
//        }
//    }
//}

@Composable
fun ProfileActions(
    onPhotoUriChanged: (Uri) -> Unit,
    onLogoutClicked: () -> Unit
) {
    val context = LocalContext.current
//    var photoUri: Uri? by remember { mutableStateOf(null) }
//    val launcher = rememberLauncherForActivityResult(
//        ActivityResultContracts.PickVisualMedia()
//    ) { uri ->
//        uri?.let {
//            context.grantUriPermission(
//                context.packageName,
//                it,
//                Intent.FLAG_GRANT_READ_URI_PERMISSION
//            )
//            onPhotoUriChanged(it)
//        }
//        photoUri = uri
//    }

    Column(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp)
    ) {
        // Edit Profile Picture Button (launches picker)
//        Button(
//            onClick = {
//                launcher.launch(
//                    PickVisualMediaRequest(
//                        mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly
//                    )
//                )
//            },
//            modifier = Modifier
//                .fillMaxWidth()
//                .padding(bottom = 8.dp),
//            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF6200EE))
//        ) {
//            Text(text = "Edit Profile Picture", color = Color.White)
//        }

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
