package com.example.lost_and_found.ui.screens.myItems

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lost_and_found.data.model.LostItemModel
import com.example.lost_and_found.ui.components.general.Centre
import com.example.lost_and_found.ui.components.general.LostItemCard
import com.example.lost_and_found.ui.components.general.ShowError
import com.example.lost_and_found.ui.components.general.ShowLoader
import com.example.lost_and_found.ui.components.myItems.EditLostItemBottomSheet
import com.example.lost_and_found.ui.components.myItems.SlidableLostItemCard
import com.example.lost_and_found.ui.screens.items.ItemsViewModel
import timber.log.Timber


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyItemsScreen(
    modifier: Modifier = Modifier,
    myItemsviewModel: MyItemsViewModel = hiltViewModel()
) {
    val items = myItemsviewModel.uiMyItems.collectAsState().value
    val isError = myItemsviewModel.iserror.value
    val error = myItemsviewModel.error.value
    val isLoading = myItemsviewModel.isloading.value

    val sheetState = rememberModalBottomSheetState(skipPartiallyExpanded = true)
    var selectedItem by remember { mutableStateOf<LostItemModel?>(null) }

    if (selectedItem != null) {
        ModalBottomSheet(
            onDismissRequest = { selectedItem = null },
            sheetState = sheetState
        ) {
            EditLostItemBottomSheet(
                item = selectedItem!!,
                onDismiss = { selectedItem = null },
                onSave = { updatedItem ->
                    myItemsviewModel.updateLostItem(updatedItem)
                    selectedItem = null
                }
            )
        }
    }

    Column {
        Column(
            modifier = modifier.padding(start = 24.dp, end = 24.dp)
        ) {
            if (isLoading) ShowLoader("Loading Items...")

            if (items.isEmpty() && !isError) {
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = "No Items Added by You Yet"
                    )
                }
            }

            if (!isError) {
                LazyColumn(modifier = Modifier.fillMaxSize()) {
                    items(items) { item ->
                        SlidableLostItemCard(
                            item = item,
                            onEdit = { selectedItem = it },
                            onDelete = { myItemsviewModel.deleteLostItem(item) }
                        )
                    }
                }
            }

            if (isError) {
                ShowError(
                    headline = error.message + " error...",
                    subtitle = error.toString(),
                    onClick = { myItemsviewModel.getMyLostItems() }
                )
            }
        }
    }
}
