package org.vbv.ecommerce.presentation

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import coil3.compose.AsyncImage
import ecommerceapp.composeapp.generated.resources.Res
import org.vbv.ecommerce.util.SPLASH_IMAGE

@Composable
fun SplashScreen(modifier: Modifier = Modifier) {
    AsyncImage(
        modifier = modifier.fillMaxSize(),
        model = Res.getUri(SPLASH_IMAGE),
        contentDescription = null,
    )
}