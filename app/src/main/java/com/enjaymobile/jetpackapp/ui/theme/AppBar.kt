package com.enjaymobile.jetpackapp.ui.theme

import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.enjaymobile.jetpackapp.R

@Composable
fun DrawAppBar(onNavigationIconClick: () -> Unit) {
    TopAppBar(
        title = {
            Text(text = stringResource(id = R.string.app_name))
        },
        backgroundColor = MaterialTheme.colors.primary,
        contentColor = MaterialTheme.colors.onPrimary,
        navigationIcon = {
            IconButton(onClick = onNavigationIconClick) {
             Icon(imageVector = Icons.Default.Menu ,contentDescription = "Toggle Drawer", tint =  MaterialTheme.colors.onPrimary)

            }
        }

    )

}