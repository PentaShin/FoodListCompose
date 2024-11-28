package com.example.foodlistcompose.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable


@Composable
fun Navigation(
    navController: NavHostController,
    modifier: Modifier = Modifier,
){

   NavHost(
       navController = navController,
       startDestination = "FoodPage",
       modifier = modifier
   ) {
       composable("FoodPage") {
           FoodPage(modifier , navController)
       }
       composable("ShopAddScreen") {
           ShopAddScreen(modifier , navController)
       }
   }
}



