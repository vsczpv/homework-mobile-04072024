package br.univali.eng2.santissimo.donations

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class UserDonationsOnDisplayItem(
	val title: String,
	val amount: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MyDonationsScreen(navController: NavHostController) {

	val context = LocalContext.current

	var squery by remember {
		mutableStateOf("")
	}

	val items = buildList<UserDonationsOnDisplayItem> {
		for (i in 1..16) {
			this.add(
				UserDonationsOnDisplayItem(
					title = "Doação $i",
					amount = "R$1'500,00"
				)
			)
		}
	}

	Scaffold (
		topBar = {
			MediumTopAppBar(title = { Text(text = "Minhas Doações", style = MaterialTheme.typography.headlineMedium) })
		}
	) { padding ->
		Column(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.padding(padding)
				.padding(horizontal = 16.dp)
		) {
			SearchBar(
				query = squery,
				onQueryChange = { squery = it },
				onSearch = { Toast.makeText(context,"A ser implementado", Toast.LENGTH_SHORT).show() } ,
				active = false,
				onActiveChange = { /* BLANK */ },
				placeholder = { Text(text = "Buscar...") },
				modifier = Modifier
					.padding(bottom = 16.dp)
			) {}
			LazyColumn {
				items.mapIndexed() { index, item ->
					item(key = index) {
						DonationCard(title = item.title, value = item.amount, modifier = Modifier)
					}
				}
			}
		}
	}
}