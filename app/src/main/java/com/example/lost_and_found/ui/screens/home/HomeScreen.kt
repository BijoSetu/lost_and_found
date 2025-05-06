package com.example.lost_and_found.ui.screens.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.lost_and_found.data.model.fakeLostItems
import com.example.lost_and_found.navigation.HomeScreen
import com.example.lost_and_found.navigation.Items
import com.example.lost_and_found.navigation.Login
//import com.example.lost_and_found.navigation.Login
import com.example.lost_and_found.navigation.NavHostProvider
import com.example.lost_and_found.navigation.allDestinations
import com.example.lost_and_found.navigation.bottomAppBarDestinations
import com.example.lost_and_found.navigation.userSignedOutDestinations
//import com.example.lost_and_found.navigation.userSignedOutDestinations
import com.example.lost_and_found.ui.components.general.BottomAppBarProvider
import com.example.lost_and_found.ui.components.general.LostItemCard
import com.example.lost_and_found.ui.components.general.TopBar


@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    homeViewModel: HomeViewModel = hiltViewModel(),
    navController: NavHostController = rememberNavController(),
) {
    val currentNavBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = currentNavBackStackEntry?.destination
    val currentBottomScreen =
        allDestinations.find { it.route == currentDestination?.route } ?: Login

    var startScreen = currentBottomScreen
    val currentUser = homeViewModel.currentUser
    val isActiveSession = homeViewModel.isAuthenticated()
    val userEmail = if (isActiveSession) currentUser?.email else ""
    val userName = if (isActiveSession) currentUser?.displayName else ""
    val userDestinations = if (!isActiveSession)
        userSignedOutDestinations
    else bottomAppBarDestinations

    if (isActiveSession) startScreen = Items

    Scaffold(
        modifier = modifier,
        topBar = {
            TopBar(
                navController = navController,
                currentScreen = currentBottomScreen,
                canNavigateBack = navController.previousBackStackEntry != null,
                email = userEmail!!,
                name = userName!!,
            ) { navController.navigateUp() }
        },
        content = { paddingValues ->
            NavHostProvider(
                modifier = modifier,
                navController = navController,
                startDestination = startScreen,
                paddingValues = paddingValues
            )

        },
        bottomBar = {
            BottomAppBarProvider(
                navController,
                currentScreen = currentBottomScreen,
                userDestinations
            )
        }
    )
}
