package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun Divider(
    marginVertical: Int = 0,
    marginHorizontal: Int = 0,
    color: CSSColorValue = Color.lightgray,
    opacity: Number = 50
) {
    Box(
        modifier = Modifier
            .height(1.px)
            .fillMaxWidth()
            .backgroundColor(color)
            .opacity(opacity)
            .margin(topBottom = marginVertical.em, leftRight = marginHorizontal.em)
    )
}