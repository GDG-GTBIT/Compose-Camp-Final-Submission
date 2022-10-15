package com.example.zomatoclonegdsc.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.zomatoclonegdsc.ui.theme.PrimeOne
import com.example.zomatoclonegdsc.R

@Composable
fun TopAppBarComposable() {
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
            Icon(
                imageVector = Icons.Filled.LocationOn,
                contentDescription = "Location Icon",
                tint = PrimeOne,
                modifier = Modifier.padding(end = 5.dp)
            )
            Column {
                Row {
                    Text(
                        text = "Location",
                        fontWeight = FontWeight.Bold,
                        fontSize = 18.sp,
                        color = Color.Black
                    )
                    Icon(
                        imageVector = Icons.Filled.ArrowDropDown,
                        contentDescription = "Location Drop Down",
                        tint = Color.Black
                    )
                }
                Text(text = "New Delhi, India", fontSize = 12.sp, color = Color.DarkGray)
            }
        }
        Icon(
            painter = painterResource(id = R.drawable.ic_baseline_account_circle_24),
            contentDescription = "Menu",
            tint = Color.Black,
            modifier = Modifier
                .fillMaxHeight()
                .width(40.dp)
        )
    }
}

@Preview
@Composable
fun display() {
    TopAppBarComposable()
}