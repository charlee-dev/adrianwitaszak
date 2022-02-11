package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.AWAvatar
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun LogoHeader() {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .height(120.px)
            .margin(top = ((-4).em), bottom = 2.em)
    ) {
        Box(
            modifier = Modifier
                .height(1.px)
                .flexGrow(1)
                .backgroundColor(Color.lightgray)
                .opacity(50.percent)
        )
        AWAvatar(
            size = 100.px,
        )
        Box(
            modifier = Modifier
                .height(1.px)
                .flexGrow(1)
                .backgroundColor(Color.lightgray)
                .opacity(50.percent)
        )
    }
}