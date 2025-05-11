package com.example.lost_and_found.ui.components.myItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.lost_and_found.data.model.LostItemModel
import com.example.lost_and_found.ui.components.postItems.LostItemInputField

@Composable
fun EditLostItemBottomSheet(
    item: LostItemModel,
    onDismiss: () -> Unit,
    onSave: (LostItemModel) -> Unit
) {
    var title by remember { mutableStateOf(item.title) }
    var description by remember { mutableStateOf(item.description) }
    var category by remember { mutableStateOf(item.category) }
    var location by remember { mutableStateOf(item.foundLocation) }
    var imageUrl by remember { mutableStateOf(item.imageUrl) }
    var message by remember { mutableStateOf(item.message ?: "") }

    Column(modifier = Modifier.padding(16.dp)) {
        Text("Edit Item", style = MaterialTheme.typography.headlineSmall)

        Spacer(modifier = Modifier.height(12.dp))

        LostItemInputField(label = "Title", value = title, onValueChange = { title = it })
        LostItemInputField(label = "Description", value = description, onValueChange = { description = it })
        LostItemInputField(label = "Category", value = category, onValueChange = { category = it })
        LostItemInputField(label = "Location", value = location, onValueChange = { location = it })
        LostItemInputField(label = "Image URL", value = imageUrl, onValueChange = { imageUrl = it })
        LostItemInputField(label = "Message", value = message, onValueChange = { message = it })

        Spacer(modifier = Modifier.height(16.dp))

        Row(horizontalArrangement = Arrangement.End, modifier = Modifier.fillMaxWidth()) {
            TextButton(onClick = onDismiss) {
                Text("Cancel")
            }
            Button(onClick = {
                val updated = item.copy(
                    title = title,
                    description = description,
                    category = category,
                    foundLocation = location,
                    imageUrl = imageUrl,
                    message = message
                )
                onSave(updated)
            }) {
                Text("Save")
            }
        }
    }
}
