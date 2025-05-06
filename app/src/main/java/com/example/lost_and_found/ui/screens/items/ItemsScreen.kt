package com.example.lost_and_found.ui.screens.items

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.lost_and_found.data.model.fakeLostItems
import com.example.lost_and_found.ui.components.general.LostItemCard

@Composable
fun ItemsScreen(modifier: Modifier = Modifier,
                viewModel: ItemsViewModel = hiltViewModel()
                )
{
    val items by viewModel.uiLostItems.collectAsState()
    LazyColumn(
        modifier = modifier.fillMaxSize()
    ) {
        items(items) { item ->
            LostItemCard(item)
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