package com.example.recorditemprice.item_price_feature.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.recorditemprice.item_price_feature.presentation.addEditItem.AddEditItemScreen
import com.example.recorditemprice.item_price_feature.presentation.addEditItem.AddEditItemScreenDestination
import com.example.recorditemprice.item_price_feature.presentation.addEditItem.AddEditItemViewModel
import com.example.recorditemprice.item_price_feature.presentation.items.ItemsScreen
import com.example.recorditemprice.item_price_feature.presentation.items.ItemsScreenDestination

@Composable
fun ItemNavHost(
    navController: NavHostController = rememberNavController(),
    modifier: Modifier = Modifier
) {
   NavHost(
       navController = navController,
       startDestination = ItemsScreenDestination.rout
   ) {
       composable(route = ItemsScreenDestination.rout) {
           ItemsScreen(
               navigateToAddEditScreen = {
                   navController.navigate("${AddEditItemScreenDestination.rout}/${-1}")
               },
               navigateToEditScreen = {
                   navController.navigate("${AddEditItemScreenDestination.rout}/${it}")
               }
           )
       }

       composable(
           route = AddEditItemScreenDestination.routeArg,
           arguments = listOf(
               navArgument(name = AddEditItemScreenDestination.itemId) {
                   type = NavType.IntType
                   defaultValue = -1
               }
           )
       ) {
           AddEditItemScreen(
               navigateToItemsScreen = {
                   navController.popBackStack()
               }
           )
       }
   }
}