package com.qpros.codechallenge.ui.newsdetails

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.qpros.codechallenge.data.model.main.RemoteNewsResponse
import com.qpros.codechallenge.ui.components.RemoteImage
import com.qpros.codechallenge.ui.theme.CodeChallengeTheme


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewsDetails(newsResponse: RemoteNewsResponse) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Row {
                        Text("News Details")
                    }
                })
        },
        content = {

            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.Start,
                modifier = Modifier.padding(it),
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight(0.4f),
                ) {
                    RemoteImage(
                        modifier = Modifier.clip(
                            RoundedCornerShape(
                                topEnd = 3.dp,
                                topStart = 3.dp,
                                bottomEnd = 3.dp,
                                bottomStart = 3.dp
                            )
                        ),
                        contentScale = ContentScale.Crop,
                        data = newsResponse.urlToImage
                            ?: ""
                    )
                }
                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = newsResponse.title,
                    fontWeight = FontWeight.Bold,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )

                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Author: ${newsResponse.author}",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    modifier = Modifier.padding(start = 10.dp),
                    text = "Published At: ${newsResponse.publishedAt}",
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Spacer(modifier = Modifier.height(10.dp))

                Text(
                    modifier = Modifier.padding(start = 10.dp, end = 10.dp),
                    text = newsResponse.description
                )

            }


        }
    )
}


@Preview(showBackground = true)
@Composable
fun NewsDetailsPreview() {
    CodeChallengeTheme {

        NewsDetails(
            newsResponse = RemoteNewsResponse(
                "Odai",
                "Hello Title",
                "Test Description",
                "",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcRFanlOmUPGXYLCRZwDLCXp70zxlBp7fKyTsqbzauPP&s",
                "Text Content",
                "27-5-2023"
            )
        )
    }
}