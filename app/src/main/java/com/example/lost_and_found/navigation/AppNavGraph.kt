package com.example.lost_and_found.navigation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.lost_and_found.ui.screens.items.ItemsScreen
import com.example.lost_and_found.ui.screens.chat.ChatScreen
import com.example.lost_and_found.ui.screens.home.HomeScreen
//import com.example.lost_and_found.ui.screens.login.LoginScreen
import com.example.lost_and_found.ui.screens.post.PostScreen
import com.example.lost_and_found.ui.screens.profile.ProfileScreen
import com.example.lost_and_found.ui.screens.signup.SignUpScreen
import ie.setu.donationx.ui.screens.login.LoginScreen

//import com.example.lost_and_found.ui.screens.signup.RegisterScreen


@Composable
fun NavHostProvider(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: AppDestination,
    paddingValues: PaddingValues
) {
    NavHost(
        navController = navController,
        startDestination = startDestination.route,
        modifier = Modifier.padding(paddingValues = paddingValues)) {

        composable(route = Profile.route) {
            //call our 'Profile' Screen Here
            ProfileScreen(modifier = modifier)
        }

        composable(route = HomeScreen.route) {
            //call our 'Profile' Screen Here
            HomeScreen(modifier = modifier)
        }

        composable(route = Items.route) {
            //call our 'Items' Screen Here
            ItemsScreen(modifier = modifier)
        }
//        composable(route = Report.route) {
//            //call our 'Report' Screen Here
//            ReportScreen(modifier = modifier,
//                onClickDonationDetails = {
//                        donationId : String ->
//                    navController.navigateToDonationDetails(donationId)
//                },
//            )
//        }
        composable(route = Chat.route) {
            //call our 'Chat' Screen Here
            ChatScreen(modifier = modifier)
        }

        composable(route = Post.route) {
            //call our 'Post' Screen Here
            PostScreen(modifier = modifier)
        }
//
        composable(route = Login.route) {
            //call our 'Login' Screen Here
            LoginScreen(
                navController = navController,
                onLogin = { navController.popBackStack() }
            )
        }

        composable(route = SignUp.route) {
            //call our 'Register' Screen Here
            SignUpScreen(
                navController = navController,
                onRegister = { navController.popBackStack() }
            )
        }

//        composable(
//            route = Details.route,
//            arguments = Details.arguments
//        )
//        { navBackStackEntry ->
//            val id = navBackStackEntry.arguments?.getString(Details.idArg)
//            if (id != null) {
//                DetailsScreen()
//            }
//        }

//        composable(route = Profile.route) {
//            ProfileScreen(
//                onSignOut = {
//                    navController.popBackStack()
//                    navController.navigate(Login.route) {
//                        popUpTo(Home.route) { inclusive = true }
//                    }
//                },
//            )
//        }
    }
}

private fun NavHostController.navigateToDonationDetails(donationId: String) {
    this.navigate("details/$donationId")
}

