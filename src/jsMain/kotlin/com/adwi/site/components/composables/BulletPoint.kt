package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

@Composable
fun BulletPoint(
    text: String,
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .margin(bottom = 1.em)
    ) {
        BulletMark()
        EmSpacer()
        if (text.contains("http://")) {
            A(
                href = text
            ) {
                Text(text = text.drop(7))
            }
        } else {
            Text(text = text)
        }
    }
}

@Composable
fun BulletMark() {
    Box(
        modifier = Modifier
            .borderRadius(100.percent)
            .border(width = 1.px, style = LineStyle.Solid, color = Color.darkgray)
            .size(10.px)
    )
}