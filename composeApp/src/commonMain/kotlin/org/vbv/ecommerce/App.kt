package org.vbv.ecommerce

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.vbv.ecommerce.presentation.RegistrationScreen
import org.vbv.ecommerce.util.AppColor.colorWhite

@Composable
fun App() {
    val appColorSchema = lightColorScheme(
    )
    MaterialTheme(colorScheme = appColorSchema) {
        Scaffold {
            RegistrationScreen(Modifier.padding(it))
        }
    }
}