package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.size
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun PxSpacer(
    size: Int = 16,
    modifier: Modifier = Modifier,
) {
    Box(modifier.size(size.px))
}

@Composable
fun EmSpacer(
    size: Double = 1.0,
    modifier: Modifier = Modifier,
) {
    Box(modifier.size(size.em))
}