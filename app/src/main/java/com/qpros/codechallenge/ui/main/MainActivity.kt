package com.qpros.codechallenge.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.qpros.codechallenge.ui.navigation.NavigationView
import com.qpros.codechallenge.ui.theme.CodeChallengeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeChallengeTheme {
                NavigationView()
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun NewsPreview() {
    CodeChallengeTheme {
        //Greeting("Android")
    }
}