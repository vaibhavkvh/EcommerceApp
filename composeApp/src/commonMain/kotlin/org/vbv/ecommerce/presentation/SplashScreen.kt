package org.vbv.ecommerce.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import ecommerceapp.composeapp.generated.resources.Res

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier.fillMaxSize(),
        model = Res.getUri("files/img_splash.svg"),
        contentDescription = null,
    )
}