package br.univali.eng2.santissimo.donations

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
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
fun DonationTargetCard(title: String, modifier: Modifier) {
	androidx.compose.material3.OutlinedCard (
		shape = CardDefaults.elevatedShape,
		border = BorderStroke(1.dp, Color.Black),
		modifier = Modifier
			.padding(8.dp)
			.fillMaxWidth()
			.background(Color.White)
	) {
		Column (
			modifier = Modifier
				.fillMaxWidth()
		) {
			Image(
				imageVector = Icons.Outlined.Info,
				contentDescription = null,
				modifier = modifier
					.height(140.dp)
					.fillMaxWidth()
			)
			Text(
				text = title,
				modifier = Modifier.padding(4.dp),
				style = MaterialTheme.typography.titleSmall
			)
		}
	}
}