package com.example.koel

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.koel.navigation.NavigationWrapper
import com.example.koel.ui.theme.KoelTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            KoelTheme {
                NavigationWrapper()
            }
        }
    }
}