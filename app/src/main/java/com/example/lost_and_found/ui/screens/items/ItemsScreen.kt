package com.example.lost_and_found.ui.screens.items

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
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

@Composable
fun ItemsScreen(modifier: Modifier = Modifier,
                itemsviewModel: ItemsViewModel = hiltViewModel()
                )
{
    val items = itemsviewModel.uiLostItems.collectAsState().value
    val isError = itemsviewModel.iserror.value
    val error = itemsviewModel.error.value
    val isLoading = itemsviewModel.isloading.value

    Timber.i("RS : Donations List = $items")

    Column {
        Column(
            modifier = modifier.padding(
                start = 24.dp,
                end = 24.dp
            ),
        ) {
            if(isLoading) ShowLoader("Loading Items...")
//            if(!isError)
//                ShowRefreshList(onClick = { reportViewModel.getDonations() })
            if (items.isEmpty() && !isError)
                Centre(Modifier.fillMaxSize()) {
                    Text(
                        color = MaterialTheme.colorScheme.secondary,
                        fontWeight = FontWeight.Bold,
                        fontSize = 30.sp,
                        lineHeight = 34.sp,
                        textAlign = TextAlign.Center,
                        text = "Items not available",
                    )
                }
            if (!isError) {
                LazyColumn(
                    modifier = modifier.fillMaxSize()
                ) {
                    items(items) { item ->
                        LostItemCard(item)
                    }
                }
            }
            if (isError) {
                ShowError(headline = error.message!! + " error...",
                    subtitle = error.toString(),
                    onClick = { itemsviewModel.getAllLostItems() })
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
}