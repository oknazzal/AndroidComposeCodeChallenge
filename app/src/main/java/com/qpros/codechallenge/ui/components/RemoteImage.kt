package com.qpros.codechallenge.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.qpros.codechallenge.R


@Composable
fun RemoteImage(
    modifier: Modifier,
    contentScale: ContentScale = ContentScale.Fit,
    data: String,
) {

    AsyncImage(
        model = ImageRequest.Builder(LocalContext.current)
            .data(data)
            .crossfade(true)
            .build(),
        placeholder = painterResource(R.drawable.ic_error),
        contentDescription = "",
        modifier = modifier,
        error =  painterResource(R.drawable.ic_error),
        contentScale=contentScale
    )


}