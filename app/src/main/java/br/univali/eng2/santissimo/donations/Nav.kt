package br.univali.eng2.santissimo.donations

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

@Composable
fun Nav(navController: NavHostController, padding: PaddingValues) {

	NavHost(
		navController = navController,
		startDestination = "home",
		modifier = Modifier
			.padding(padding)
	) {
		composable(
			route = "home"
		) {
			HomeScreen(navController = navController)
		}
		composable(
			route = "profile"
		) {
			ProfileScreen(navController = navController)
		}
		composable(
			route = "mydons"
		) {
			MyDonationsScreen(navController = navController)
		}
		composable(
			route = "search"
		) {
			SearchScreen(navController = navController)
		}
		composable(
			route = "chat"
		) {
			ChatScreen(navController = navController)
		}
	}
}