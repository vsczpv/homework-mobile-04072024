package br.univali.eng2.santissimo.donations

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun DonationCard(title: String, value: String, modifier: Modifier) {
	androidx.compose.material3.Card (
		shape = CardDefaults.elevatedShape,
		modifier = Modifier
			.padding(8.dp)
			.fillMaxWidth()
	) {
		Column (
			modifier = Modifier
				.fillMaxWidth()
		) {
			Text(
				text = title,
				modifier = Modifier
					.padding(4.dp)
					.padding(top=4.dp),
				style = MaterialTheme.typography.titleMedium
			)
			Row (
				horizontalArrangement = Arrangement.End,
				modifier = Modifier
					.fillMaxWidth()
			) {
				Text(
					text = value,
					modifier = Modifier
						.padding(4.dp)
						.padding(top=24.dp, bottom=4.dp)
						.padding(end=8.dp),
					style = MaterialTheme.typography.titleMedium
				)
			}
		}
	}
}