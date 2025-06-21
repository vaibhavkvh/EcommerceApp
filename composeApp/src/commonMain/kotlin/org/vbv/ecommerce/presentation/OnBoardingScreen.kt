package org.vbv.ecommerce.presentation


import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import ecommerceapp.composeapp.generated.resources.Res
import org.vbv.ecommerce.util.ON_BOARD_IMAGE
import org.vbv.ecommerce.util.customwidget.BlackButton

@Composable
fun OnBoardingScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.fillMaxSize().background(Color.White),
        contentAlignment = Alignment.BottomCenter
    ) {
        AsyncImage(
            modifier = Modifier.fillMaxSize(),
            model = Res.getUri(ON_BOARD_IMAGE),
            contentDescription = null,
        )

        Box(
            modifier = Modifier.fillMaxWidth().height(100.dp)
                .background(color = Color.White)
        ) {
            BlackButton(Modifier.fillMaxWidth().padding(horizontal = 20.dp, vertical = 24.dp),
                "Get Started ->",{

            })
        }
    }
}