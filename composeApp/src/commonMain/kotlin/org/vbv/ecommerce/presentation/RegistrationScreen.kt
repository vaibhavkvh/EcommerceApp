package org.vbv.ecommerce.presentation

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import org.vbv.ecommerce.util.AppColor.colorGrey
import org.vbv.ecommerce.util.LARGE_PADDING
import org.vbv.ecommerce.util.MEDIUM_PADDING
import org.vbv.ecommerce.util.MIN_PADDING


@Composable
fun RegistrationScreen(modifier: Modifier) {
    Column(modifier = modifier.padding(LARGE_PADDING)) {
        Text(
            "Create an account",
            style = TextStyle(
                fontWeight = FontWeight.SemiBold,
                fontSize = 32.sp,
                color = Color.Black
            )
        )

        Text(
            modifier= Modifier.padding(vertical = MIN_PADDING),
            text="Let's create your account",
            style = TextStyle(
                fontWeight = FontWeight.Normal,
                fontSize = 16.sp,
                color = colorGrey
            )
        )
    }
}