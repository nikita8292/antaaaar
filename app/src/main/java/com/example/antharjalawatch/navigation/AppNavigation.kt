package com.example.antharjalawatch.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument

import com.example.antharjalawatch.screens.*

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "dashboard"
    ) {

        composable("dashboard") {

            DashboardScreen(navController)
        }

        composable("borewell_log") {

            BorewellLogScreen(navController)
        }

        composable(

            route =
                "borewell_details/{latitude}/{longitude}/{depth}/{yield}/{year}",

            arguments = listOf(

                navArgument("latitude") {
                    type = NavType.StringType
                },

                navArgument("longitude") {
                    type = NavType.StringType
                },

                navArgument("depth") {
                    type = NavType.StringType
                },

                navArgument("yield") {
                    type = NavType.StringType
                },

                navArgument("year") {
                    type = NavType.StringType
                }
            )

        ) { backStackEntry ->

            val latitude =
                backStackEntry.arguments
                    ?.getString("latitude") ?: ""

            val longitude =
                backStackEntry.arguments
                    ?.getString("longitude") ?: ""

            val depth =
                backStackEntry.arguments
                    ?.getString("depth") ?: ""

            val yield =
                backStackEntry.arguments
                    ?.getString("yield") ?: ""

            val year =
                backStackEntry.arguments
                    ?.getString("year") ?: ""

            BorewellDetailsScreen(

                latitude = latitude,

                longitude = longitude,

                depth = depth,

                yieldValue = yield,

                year = year,

                navController = navController
            )
        }

        composable("water_map") {

            WaterMapScreen(navController)
        }

        composable("recharge_guide") {

            RechargeGuideScreen(navController)
        }

        composable("alerts") {

            AlertsScreen(navController)
        }
    }
}