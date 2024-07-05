package br.univali.eng2.santissimo.donations

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Chat
import androidx.compose.material.icons.automirrored.filled.Label
import androidx.compose.material.icons.automirrored.outlined.Chat
import androidx.compose.material.icons.automirrored.outlined.Label
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Chat
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Label
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material.icons.outlined.ShoppingCart
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.compose.rememberNavController
import br.univali.eng2.santissimo.donations.ui.theme.DonationsTheme

data class BottomNavigationItem(
	val title: String,
	val selectedIcon: ImageVector,
	val unselectedIcon: ImageVector,
	val navTarget: String
)

class MainActivity : ComponentActivity() {
	@OptIn(ExperimentalMaterial3Api::class)
	override fun onCreate(savedInstanceState: Bundle?) {
		super.onCreate(savedInstanceState)
		setContent {

			val navController = rememberNavController()
			val loggedIn = true

			DonationsTheme {
				val navItems = listOf(
					BottomNavigationItem(
						title = "Home",
						selectedIcon = Icons.Filled.Home,
						unselectedIcon = Icons.Outlined.Home,
						navTarget = "home"
					),
					BottomNavigationItem(
						title = "Pesquisa",
						selectedIcon = Icons.Filled.Search,
						unselectedIcon = Icons.Outlined.Search,
						navTarget = "search"
					),
					BottomNavigationItem(
						title = "Doações",
						selectedIcon = Icons.AutoMirrored.Filled.Label,
						unselectedIcon = Icons.AutoMirrored.Outlined.Label,
						navTarget = "mydons"
					),
					BottomNavigationItem(
						title = "Chat",
						selectedIcon = Icons.AutoMirrored.Filled.Chat,
						unselectedIcon = Icons.AutoMirrored.Outlined.Chat,
						navTarget = "chat"
					),
					BottomNavigationItem(
						title = "Perfil",
						selectedIcon = Icons.Filled.AccountCircle,
						unselectedIcon = Icons.Outlined.AccountCircle,
						navTarget = "profile"
					)
				)
				var navItemIndex by rememberSaveable {
					mutableIntStateOf(0)
				}
				Surface(
					modifier = Modifier.fillMaxSize(),
					color = MaterialTheme.colorScheme.background,
				) {
					Scaffold (
						bottomBar = {
							if (loggedIn) {
								NavigationBar {
									navItems.forEachIndexed { index, bottomNavigationItem ->
										NavigationBarItem(
											selected = index == navItemIndex,
											onClick = {
												navItemIndex = index
												navController.navigate(bottomNavigationItem.navTarget)
											},
											icon = {
												val icn = if (index == navItemIndex) {
													bottomNavigationItem.selectedIcon
												} else {
													bottomNavigationItem.unselectedIcon
												}
												Icon(
													imageVector = icn,
													contentDescription = bottomNavigationItem.title
												)
											},
											label = { Text(text = bottomNavigationItem.title) }
										)
									}
								}
							}
						}
					) { padding ->
						Nav(navController, padding)
					}
				}
			}
		}
	}
}