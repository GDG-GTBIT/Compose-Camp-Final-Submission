package com.example.zomatoclonegdsc.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import com.example.zomatoclonegdsc.ui.theme.*

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun FilterRowCard(
    text: String,
    leadingIcon: ImageVector? = null,
    trailingIcon: ImageVector? = null,
    leadingIconContentDescription: String? = "",
    trailingIconContentDescription: String? = ""
) {
    var isSelected by remember {
        mutableStateOf(false)
    }

    Card(
        modifier = Modifier.padding(top = 5.dp, bottom = 5.dp, end = 10.dp),
        shape = RoundedCornerShape(10.dp),
        border = if (isSelected) {
            BorderStroke(0.5.dp, zRedColor)
        } else {
            BorderStroke(0.5.dp, zLightGray)
        },
        onClick = { isSelected = !isSelected },
        backgroundColor = if (isSelected) {
            zSelectedFilterRowItemBg
        } else {
            zWhite
        }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier.padding(horizontal = 5.dp)
        ) {
            if (leadingIcon != null) {
                Icon(
                    imageVector = leadingIcon,
                    contentDescription = leadingIconContentDescription,
                    tint = zRedColor
                )
            }
            Text(text = text, color = zBlack, modifier = Modifier.padding(6.dp))
            if (trailingIcon != null) {
                Icon(
                    imageVector = trailingIcon,
                    contentDescription = trailingIconContentDescription,
                    tint = zRedColor
                )
            }
        }
    }
}