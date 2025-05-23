package com.example.lost_and_found.ui.screens.items

import FilterBottomSheet
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lost_and_found.R
import com.example.lost_and_found.data.model.fakeLostItems
import com.example.lost_and_found.ui.components.general.Centre
import com.example.lost_and_found.ui.components.general.LostItemCard
import com.example.lost_and_found.ui.components.general.ShowError
import com.example.lost_and_found.ui.components.general.ShowLoader
 import timber.log.Timber

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ItemsScreen(modifier: Modifier = Modifier, itemsViewModel: ItemsViewModel = hiltViewModel()) {
    val items = itemsViewModel.uiLostItems.collectAsState().value
    val filteredItems = itemsViewModel.filterItems.collectAsState().value
    val isError = itemsViewModel.iserror.value
    val error = itemsViewModel.error.value
    val isLoading = itemsViewModel.isloading.value

    Column {
        // Filter Bottom Sheet logic
        FilterBottomSheet(
            selected = itemsViewModel.selectedCategories, // Use selected categories
            onToggle = { category ->
                itemsViewModel.toggleCategory(category) // Toggle category
                itemsViewModel.filterItems() // Apply filter when toggling
            },
            onClose = {
                itemsViewModel.filterItems() // Reapply filter when closing
            }
        )

        if (isLoading) ShowLoader("Loading Items...")

        if (filteredItems.isEmpty() && !isError) {
            Centre(Modifier.fillMaxSize()) {
                Text(
                    color = MaterialTheme.colorScheme.secondary,
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    lineHeight = 34.sp,
                    textAlign = TextAlign.Center,
                    text = "No Items for the selected category",
                )
            }
        }

        if (!isError) {
            LazyColumn(modifier = modifier.fillMaxSize()) {
                items(filteredItems) { item ->
                    LostItemCard(item)
                }
            }
        }

        if (isError) {
            ShowError(
                headline = error.message ?: "Error",
                subtitle = error.toString(),
                onClick = { itemsViewModel.getAllLostItems() }
            )
        }
    }
}






//    LazyColumn(
//        modifier = modifier
//            .fillMaxSize()
//    ) {
//        items(fakeLostItems) { item ->
//            LostItemCard(item)
//        }
//    }
//}