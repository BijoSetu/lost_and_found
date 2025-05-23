package com.example.lost_and_found.navigation


import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material.icons.automirrored.filled.Login
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.Details
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.Inventory
import androidx.compose.material.icons.filled.Person
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.input.key.Key.Companion.Home
import androidx.navigation.NavType
import androidx.navigation.navArgument

interface AppDestination {
    val icon: ImageVector
    val label: String
    val route: String
}

object Items : AppDestination {
    override val icon = Icons.Filled.Home
    override val label = "Items"
    override val route = "items"
}

object Post : AppDestination {
    override val icon = Icons.Filled.AddCircle
    override val label = "Post"
    override val route = "post"
}

object Profile : AppDestination {
    override val icon = Icons.Filled.Person
    override val label = "Profile"
    override val route = "profile"
}

object MyItems : AppDestination {
    override val icon = Icons.Filled.Inventory
    override val label = "MyItems"
    override val route = "myItems"
}

//object Details : AppDestination {
//    override val icon = Icons.Filled.Details
//    override val label = "Details"
//    const val idArg = "id"
//    override val route = "details/{$idArg}"
//    val arguments = listOf(
//        navArgument(idArg) { type = NavType.StringType }
//    )
//}
object HomeScreen : AppDestination {
    override val icon = Icons.Filled.Home
    override val label = "Home"
    override val route = "home"
}


object Login : AppDestination {
    override val icon = Icons.AutoMirrored.Filled.Login
    override val label = "Login"
    override val route = "login"
}
//
object SignUp : AppDestination {
    override val icon = Icons.Default.AccountCircle
    override val label = "SignUp"
    override val route = "SignUp"
}

val bottomAppBarDestinations = listOf(Items, Post, MyItems, Profile)
val userSignedOutDestinations = listOf(Login, SignUp)
val allDestinations = listOf(Items, Post, MyItems,
    HomeScreen,  Profile,)


