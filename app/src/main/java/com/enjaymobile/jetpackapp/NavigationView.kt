package com.enjaymobile.jetpackapp

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enjaymobile.jetpackapp.ui.theme.MenuItem


@Composable
fun DrawerHeader() {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 30.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Text(
            text = "Shop My Taste",
            modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp, 5.dp, 5.dp, 5.dp),
            style = TextStyle(color = colorResource(id = R.color.colorPrimaryDark)),
            fontSize = 20.sp,
            fontWeight = FontWeight.ExtraBold
        )
    }
}

@Composable
fun DrawerBody(
    items: List<MenuItem>,
    modifier: Modifier = Modifier,
    itemtextStyle: TextStyle = TextStyle(fontSize = 16.sp),
    onItemClick: (MenuItem) -> Unit
) {
    LazyColumn(modifier) {
        items(items) { item ->
            Row(modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onItemClick(item)
                }
                .padding(16.dp)) {
                Icon(
                    imageVector = item.icon,
                    contentDescription = item.title,
                    tint = colorResource(id = R.color.colorPrimaryDark)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Text(text = item.title, style = itemtextStyle, modifier = Modifier.weight(1f))

            }
        }
    }
}