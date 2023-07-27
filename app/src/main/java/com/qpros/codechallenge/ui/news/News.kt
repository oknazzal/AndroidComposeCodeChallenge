package com.qpros.codechallenge.ui.news

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.core.os.bundleOf
import androidx.navigation.NavHostController
import com.qpros.codechallenge.ui.components.RemoteImage
import com.qpros.codechallenge.ui.main.NewsViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun News(viewModel: NewsViewModel, navHostController: NavHostController) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("News")
                    }
                })
        },
        content = {

            Column(modifier = Modifier.padding(it)) {
                LazyColumn(modifier = Modifier.fillMaxHeight()) {
                    items(viewModel.responseNewsState.size) { index ->
                        Column(
                            modifier = Modifier
                                .padding(
                                    top = 8.dp,
                                    bottom = 8.dp,
                                    start = 16.dp,
                                    end = 16.dp
                                )
                                .clickable {
                                    val destination =
                                        navHostController.graph.findNode("newsDetails")
                                    if (destination != null) {
                                        navHostController.navigate(
                                            destination.id,
                                            bundleOf("news" to viewModel.responseNewsState[index])
                                        )
                                    }
                                }
                        ) {
                            Row() {
                                Box(
                                    modifier = Modifier
                                        .width(100.dp)
                                        .aspectRatio(1f)
                                ) {
                                    RemoteImage(
                                        modifier = Modifier.clip(
                                            RoundedCornerShape(
                                                topEnd = 8.dp,
                                                topStart = 8.dp,
                                                bottomEnd = 8.dp,
                                                bottomStart = 8.dp
                                            )
                                        ),
                                        contentScale = ContentScale.Crop,
                                        data = viewModel.responseNewsState[index].urlToImage
                                            ?: ""
                                    )
                                }
                                Spacer(modifier = Modifier.width(16.dp))
                                Column() {
                                    Text(
                                        viewModel.responseNewsState[index].title,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                    Spacer(modifier = Modifier.height(6.dp))
                                    Text(
                                        viewModel.responseNewsState[index].publishedAt,
                                        maxLines = 2,
                                        overflow = TextOverflow.Ellipsis
                                    )
                                }

                            }

                        }
                    }
                }
            }

        }
    )
}