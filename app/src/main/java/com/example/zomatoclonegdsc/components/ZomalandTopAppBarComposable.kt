package com.example.zomatoclonegdsc.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclonegdsc.R

@Composable
fun ZomalandTopAppBarComposable() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(top = 5.dp, start = 10.dp, end = 10.dp)
            .fillMaxWidth()
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 5.dp)
        ) {

            Card(
                modifier = Modifier
                    .size(35.dp)
                    .clip(CircleShape),
                backgroundColor = Color.Cyan
            ) {
                Image(
                    painter = painterResource(id = R.drawable.sports_cricket_bottom_nav),
                    contentDescription = "ZomalandLogo",
                    modifier = Modifier.size(25.dp),
                )
            }

            Column(
                modifier = Modifier.padding(start = 10.dp)
            ) {
                Row {
                    Text(
                        text = "Zomaland, New Delhi",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp,
                        color = Color.Black
                    )
                }
                Text(text = "JLN Stadium, Gate No. 2", fontSize = 12.sp, color = Color.DarkGray)
            }
        }
        Button(onClick = { /*TODO*/ }) {
            Text(
                text = "Buy Tickets",
                color = Color.White,
                fontSize = 14.sp,
            )
        }
    }
}