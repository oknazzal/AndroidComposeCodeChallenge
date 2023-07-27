package com.qpros.codechallenge.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.qpros.codechallenge.ui.news.News
import com.qpros.codechallenge.ui.newsdetails.NewsDetails


@Composable
fun NavigationView() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "news") {
        composable("news") {
            News(hiltViewModel(), navController)
        }
        composable("newsDetails") {
            NewsDetails(it.arguments?.getParcelable("news")!!)
        }

    }
}