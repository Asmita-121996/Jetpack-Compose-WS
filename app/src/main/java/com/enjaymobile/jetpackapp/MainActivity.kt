package com.enjaymobile.jetpackapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.*
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.TextStyle
import com.enjaymobile.jetpackapp.ui.theme.DrawAppBar
import com.enjaymobile.jetpackapp.ui.theme.JetpackAppTheme
import com.enjaymobile.jetpackapp.ui.theme.MenuItem
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JetpackAppTheme {
                val scaffoldState = rememberScaffoldState()
                val scope = rememberCoroutineScope()
                Scaffold(
                    scaffoldState = scaffoldState,
                    topBar = {
                        DrawAppBar(onNavigationIconClick = {
                            scope.launch {
                                scaffoldState.drawerState.open()
                            }

                        })
                    },
                    drawerContent = {
                        DrawerHeader()
                        DrawerBody(
                            items = listOf(
                                MenuItem(
                                    id = "profile",
                                    title = "Profile",
                                    icon = Icons.Default.AccountBox
                                ),
                                MenuItem(
                                    id = "home",
                                    title = "Home",
                                    icon = Icons.Default.Home
                                ),
                                MenuItem(
                                    id = "shoppingcart",
                                    title = "My Cart",
                                    icon = Icons.Default.ShoppingCart

                                ),
                                MenuItem(
                                    id = "settings",
                                    title = "Settings",
                                    icon = Icons.Default.Settings
                                ),
                                MenuItem(
                                    id = "help",
                                    title = "Help",
                                    icon = Icons.Default.Info

                                ),
                                MenuItem(
                                    id = "logout",
                                    title = "Log-Out",
                                    icon = Icons.Default.ExitToApp
                                )
                            ),
                            itemtextStyle = TextStyle(colorResource(id = R.color.colorPrimaryDark)),
                            onItemClick = {
                                println("Clicked on ${it.title}")
                            }
                        )
                    }) {

                }
            }
        }
    }
}

