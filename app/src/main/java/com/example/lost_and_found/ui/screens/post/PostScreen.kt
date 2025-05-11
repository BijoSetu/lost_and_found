package com.example.lost_and_found.ui.screens.post

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lost_and_found.data.model.LostItemModel
import com.example.lost_and_found.ui.components.postItems.FoundDatePicker
import com.example.lost_and_found.ui.components.postItems.LostItemInputField
import com.example.lost_and_found.ui.screens.home.HomeViewModel
import java.util.Date
import java.util.UUID

@Composable
fun PostScreen(modifier: Modifier = Modifier,postViewModel: PostViewModel = hiltViewModel(),homeViewModel: HomeViewModel = hiltViewModel()) {
    var title by remember { mutableStateOf("") }
    var subtitle by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var category by remember { mutableStateOf("") }
    var foundLocation by remember { mutableStateOf("") }
    var imageUrl by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }
    var foundDate by remember { mutableStateOf(Date()) }

    val userId = homeViewModel.email.value


    Column(
        modifier = Modifier
            .fillMaxSize().verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        LostItemInputField(
            label = "Title",
            value = title,
            onValueChange = { title = it }
        )
//        LostItemInputField(
//            label = "Subtitle",
//            value = subtitle,
//            onValueChange = { subtitle = it }
//        )
        LostItemInputField(
            label = "Description",
            value = description,
            onValueChange = { description = it }
        )

        LostItemInputField(
            label = "Category",
            value = category,
            onValueChange = { category = it }
        )

        LostItemInputField(
            label = "Found Location",
            value = foundLocation,
            onValueChange = { foundLocation = it }
        )

        LostItemInputField(
            label = "Image URL",
            value = imageUrl,
            onValueChange = { imageUrl = it }
        )

        LostItemInputField(
            label = "Message",
            value = message,
            onValueChange = { message = it }
        )


        FoundDatePicker(foundDate) { foundDate = it }

        Spacer(modifier = Modifier.height(4.dp))

        Button(onClick = {
            val item = LostItemModel(
                title = title,
//                subtitle = subtitle,
                description = description,
                category = category,
                foundLocation = foundLocation,
                foundDate = foundDate,
                postedDate = Date(),
                imageUrl = imageUrl,
                userId = userId,
                message = message
            )
            postViewModel.postLostItem(item.copy(_id= UUID.randomUUID().toString()))
        }) {
            Text("Submit Lost Item")
        }
    }
}
