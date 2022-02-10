package com.adwi.site.components.layouts

import androidx.compose.runtime.Composable
import com.adwi.site.components.theme.Colors
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth

@Composable
fun FullWidthLayout(
    modifier: Modifier = Modifier,
    backgroundColor: String = Colors.white,
    isCentered: Boolean = true,
    content: @Composable () -> Unit
) {
    Box(
        contentAlignment = if (isCentered) Alignment.Center else Alignment.TopStart,
        modifier = modifier
            .fillMaxWidth()
            .backgroundColor(backgroundColor)
    ) {
        content()
    }
}