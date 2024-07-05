package br.univali.eng2.santissimo.donations

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MediumTopAppBar
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

data class DonationsOnDisplayItem(
	val title: String
)

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navController: NavHostController) {

	val items = buildList<DonationsOnDisplayItem> {
		for (i in 1..6) {
			this.add(
				DonationsOnDisplayItem(
					title = "Projeto de Doação $i"
				)
			)
		}
	}

	Scaffold (
		topBar = {
			MediumTopAppBar(title = { Text(text = "Home", style = MaterialTheme.typography.headlineMedium) })
		}
	) { padding ->
		LazyColumn(
			horizontalAlignment = Alignment.CenterHorizontally,
			modifier = Modifier
				.padding(padding)
				.fillMaxSize()
		) {
			items.mapIndexed { index, item ->
				item (key = index){
					DonationTargetCard(
						title = item.title,
						modifier = Modifier
							.padding(top = 16.dp)
					)
				}
			}
		}
	}
}