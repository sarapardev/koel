package com.example.koel.navigation

import androidx.compose.runtime.Composable

import androidx.navigation3.runtime.entryProvider
import androidx.navigation3.runtime.rememberNavBackStack
import androidx.navigation3.ui.NavDisplay
import com.example.koel.screens.HomeScreen
import com.example.koel.screens.LoginScreen

@Composable
fun NavigationWrapper() {
    //backStack guarda pantalla

    val backStack = rememberNavBackStack(Routes.Login)
    NavDisplay(
        backStack = backStack,
        onBack = {
            backStack.removeAt(backStack.lastIndex)
        },
        entryProvider = entryProvider {

            entry<Routes.Login> {
                LoginScreen(
                    onLogin = { user ->
                        backStack.add(Routes.Home(user))
                    }
                )
            }
            entry<Routes.Home> { route ->
                HomeScreen(
                    user = route.user,
                    onBack = {
                        backStack.removeAt(backStack.lastIndex)
                    }
                )
            }
        }
    )
}