package org.vbv.ecommerce.util.customwidget

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import org.vbv.ecommerce.util.AppColor.colorBlack
import org.vbv.ecommerce.util.AppColor.colorDividerGrey
import org.vbv.ecommerce.util.AppColor.colorHintGrey
import org.vbv.ecommerce.util.AppColor.colorTransparent
import org.vbv.ecommerce.util.AppColor.colorWhite

@Composable
fun BlackButton(modifier: Modifier, buttonText: String, onClick: () -> Unit) {
    return ElevatedButton(
        modifier = modifier,
        onClick = onClick,
        shape = RoundedCornerShape(10.dp),
        colors = ButtonDefaults.buttonColors(containerColor = Color.Black)
    ) {
        Text(text = buttonText)
    }
}

@Composable
fun TextViewH2SemiBold(modifier: Modifier = Modifier, label: String, mColor: Color = colorBlack) {
    return Text(
        modifier = modifier,
        text = label,
        style = TextStyle(
            fontWeight = FontWeight.SemiBold,
            fontSize = 32.sp,
            color = mColor
        )
    )
}


@Composable
fun TextViewB1Regular(modifier: Modifier = Modifier, label: String, mColor: Color = colorBlack) {
    return Text(
        modifier = modifier,
        text = label,
        style = TextStyle(
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            color = mColor
        )
    )
}


@Composable
fun TextViewB1Medium(modifier: Modifier = Modifier, label: String, mColor: Color = colorBlack) {
    return Text(
        modifier = modifier,
        text = label,
        style = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 16.sp,
            color = mColor
        )
    )
}

@Composable
fun CustomTextField(
    modifier: Modifier = Modifier,
    label: String,
    hint: String,
    onValueChange: (String) -> Unit,
    mColor: Color = colorBlack,
    keyboardType: KeyboardType = KeyboardType.Text,
    imeAction: ImeAction = ImeAction.Next,
) {
    return TextField(

        singleLine = true,

        colors = TextFieldDefaults.colors(
            focusedContainerColor = colorWhite,
            disabledContainerColor = colorWhite,
            unfocusedContainerColor = colorWhite,
            errorIndicatorColor = colorTransparent,
            focusedIndicatorColor = colorTransparent,
            disabledIndicatorColor = colorTransparent,
            unfocusedIndicatorColor = colorTransparent
        ),
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType, imeAction = imeAction),
        visualTransformation = if (keyboardType == KeyboardType.Password)
            PasswordVisualTransformation()
        else
            VisualTransformation.None,

        modifier = modifier.fillMaxWidth()
            .border(width = 1.dp, shape = RoundedCornerShape(12.dp), color = colorDividerGrey),
        placeholder = {
            TextViewB1Regular(
                label = hint,
                mColor = colorHintGrey
            )
        },
        value = label,
        onValueChange = onValueChange
    )
}


@Composable
fun AppBlackButton(
    modifier: Modifier,
    buttonText: String,
    onClick: () -> Unit,
    buttonColor: Color = colorBlack
) {
    return OutlinedButton(
        shape = RoundedCornerShape(14.dp),
        modifier = modifier,
        onClick = onClick,
        colors = ButtonDefaults.buttonColors(containerColor = buttonColor)
    ) {
        Text(buttonText)
    }
}

