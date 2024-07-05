package br.univali.eng2.santissimo.donations

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class UserProfileItem(
	val which: String,
	val ue: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProfileScreen(navController: NavHostController) {
	val items = listOf(
		UserProfileItem(
			which = "Nome",
			ue = "John Doe",
		),
		UserProfileItem(
			which = "E-mail",
			ue = "john@doe.com",
		),
		UserProfileItem(
			which = "Telefone",
			ue = "(12) 3456 7890",
		)
	)
	Column (
		verticalArrangement = Arrangement.SpaceEvenly,
		horizontalAlignment = Alignment.CenterHorizontally,
		modifier = Modifier
			.fillMaxSize()
	) {
		Scaffold (
			topBar = {
				MediumTopAppBar(title = { Text(text = "Meu Perfil", style = MaterialTheme.typography.headlineMedium) })
			}
		) { padding ->
			Column (
				horizontalAlignment = Alignment.CenterHorizontally,
				modifier = Modifier
					.padding(padding)
					.padding(top = 48.dp)
					.fillMaxSize()
			) {
				Icon(
					imageVector = Icons.Filled.Person,
					contentDescription = null,
					modifier = Modifier
						.size(140.dp)
						.background(MaterialTheme.colorScheme.secondaryContainer, CircleShape)
				)
				items.map { item ->
					Row (
						horizontalArrangement = Arrangement.SpaceBetween,
						modifier = Modifier
							.fillMaxWidth()
							.padding(horizontal = 16.dp)
							.padding(top = 16.dp)
					) {
						Text(text = "${item.which}:", fontWeight = FontWeight.Bold)
						Text(text = item.ue)
					}
				}
			}
		}
	}
}