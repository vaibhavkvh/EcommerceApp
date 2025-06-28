package org.vbv.ecommerce.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.vbv.ecommerce.util.AppColor.colorBlack
import org.vbv.ecommerce.util.AppColor.colorTextGrey
import org.vbv.ecommerce.util.AppColor.colorWhite
import org.vbv.ecommerce.util.MAX_PADDING
import org.vbv.ecommerce.util.MEDIUM_PADDING
import org.vbv.ecommerce.util.MIN_PADDING
import org.vbv.ecommerce.util.customwidget.AppBlackButton
import org.vbv.ecommerce.util.customwidget.CustomTextField
import org.vbv.ecommerce.util.customwidget.TextViewB1Medium
import org.vbv.ecommerce.util.customwidget.TextViewB1Regular
import org.vbv.ecommerce.util.customwidget.TextViewH2SemiBold


@Composable
fun RegistrationScreen(modifier: Modifier) {
    Column(modifier = modifier.fillMaxSize().background(colorWhite).padding(MAX_PADDING)) {

        var fullName by remember { mutableStateOf("") }
        var email by remember { mutableStateOf("") }
        var password by remember { mutableStateOf("") }

        TextViewH2SemiBold(label = "Create an account")

        TextViewB1Regular(
            Modifier.padding(vertical = MIN_PADDING),
            "Let's create your account.",
            colorTextGrey
        )


        TextViewB1Medium(Modifier.padding(top = 20.dp), "Full Name")
        CustomTextField(
            modifier = Modifier.padding(top = MEDIUM_PADDING),
            hint = "Please enter full name",
            label = fullName,
            onValueChange = {
                fullName = it
            })

        TextViewB1Medium(Modifier.padding(top = 20.dp), "Email")
        CustomTextField(
            modifier = Modifier.padding(top = MEDIUM_PADDING),
            hint = "Please enter email",
            label = email,
            keyboardType = KeyboardType.Email,
            onValueChange = {
                email = it
            })

        TextViewB1Medium(Modifier.padding(top = 20.dp), "Password")
        CustomTextField(
            modifier = Modifier.padding(top = MEDIUM_PADDING),
            hint = "Please enter password",
            label = password,
            keyboardType = KeyboardType.Password,
            imeAction = ImeAction.Done,
            onValueChange = {
                password = it
            })

        LegalAgreementText(
            modifier = Modifier.padding(top = MEDIUM_PADDING).fillMaxWidth(),
            onTermsClick = {
                // Navigate to Terms screen or open Terms URL
                println("Signup=>Navigate to Terms")
            },
            onPrivacyClick = {
                // Navigate to Privacy Policy screen or open Privacy URL
                println("Signup=>Navigate to Privacy Policy")
            },
            onCookieClick = {
                // Navigate to Cookie Use screen or open Cookie URL
                println("Signup=>Navigate to Cookie Use")
            }
        )

        AppBlackButton(Modifier.padding(
            vertical = 16.dp
        ).fillMaxWidth().padding(
            vertical = 16.dp
        ).height(52.dp), buttonText = "Create an account", onClick = {
            println("tap on create account")
        })

    }
}

const val ANNOTATION_TAG_TERMS = "terms"
const val ANNOTATION_TAG_PRIVACY = "privacy"
const val ANNOTATION_TAG_COOKIE = "cookie"

@Composable
fun LegalAgreementText(
    modifier: Modifier = Modifier,
    onTermsClick: () -> Unit,
    onPrivacyClick: () -> Unit,
    onCookieClick: () -> Unit,
    normalTextStyle: TextStyle = TextStyle.Default.copy(fontSize = 14.sp),
    linkTextStyle: TextStyle = TextStyle.Default.copy(
        fontWeight = FontWeight.Medium,
        textDecoration = TextDecoration.Underline,
        color = colorBlack, // Or your desired link color
        fontSize = 14.sp // Match normal text or adjust as needed
    )
) {
    val annotatedString = buildAnnotatedString {
        withStyle(style = normalTextStyle.toSpanStyle()) {
            append("By signing up you agree to our ")
        }

        // Terms
        pushStringAnnotation(
            tag = ANNOTATION_TAG_TERMS,
            annotation = "https://example.com/terms"
        ) // URL or identifier
        withStyle(style = linkTextStyle.toSpanStyle()) {
            append("Terms")
        }
        pop()

        withStyle(style = normalTextStyle.toSpanStyle()) {
            append(", ")
        }

        // Privacy Policy
        pushStringAnnotation(
            tag = ANNOTATION_TAG_PRIVACY,
            annotation = "https://example.com/privacy"
        )
        withStyle(style = linkTextStyle.toSpanStyle()) {
            append("Privacy Policy")
        }
        pop()

        withStyle(style = normalTextStyle.toSpanStyle()) {
            append(", and ")
        }

        // Cookie Use
        pushStringAnnotation(
            tag = ANNOTATION_TAG_COOKIE,
            annotation = "https://example.com/cookies"
        )
        withStyle(style = linkTextStyle.toSpanStyle()) {
            append("Cookie Use")
        }
        pop()
    }

    ClickableText(
        text = annotatedString,
        style = normalTextStyle, // Base style for the entire ClickableText
        onClick = { offset ->
            annotatedString.getStringAnnotations(
                tag = ANNOTATION_TAG_TERMS,
                start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    onTermsClick()
                }

            annotatedString.getStringAnnotations(
                tag = ANNOTATION_TAG_PRIVACY,
                start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    onPrivacyClick()
                }

            annotatedString.getStringAnnotations(
                tag = ANNOTATION_TAG_COOKIE,
                start = offset,
                end = offset
            )
                .firstOrNull()?.let { annotation ->
                    onCookieClick()
                }
        },
        modifier = modifier
    )
}