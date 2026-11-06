
package com.example.koel.navigation

import androidx.navigation3.runtime.NavKey
import kotlinx.serialization.Serializable

@Serializable
sealed class Routes : NavKey {

    @Serializable
    data object Login : Routes()
    @Serializable
    data class Home(val user: String) : Routes()
}
