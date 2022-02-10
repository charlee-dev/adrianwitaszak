package com.adwi.site.components.style

import com.adwi.site.components.composables.TextStyle
import com.adwi.site.components.theme.Colors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

val NavItemTextStyle = ComponentStyle("nav-item-text") {
    base {
        Modifier
            .padding(topBottom = .5.em, leftRight = .25.em)
            .color(Colors.gray)
            .fontFamily("europa", "sans-serif")
            .fontWeight(FontWeight.Lighter)
            .transition("all .2s ease-in-out")
    }
    hover {
        Modifier
            .color(Colors.primary)
            .fontWeight(FontWeight.Normal)
    }
    Breakpoint.SM {
        Modifier.padding(topBottom = .5.em, leftRight = .75.em)
    }
}

val LinkTextStyle = ComponentStyle("link-item-text") {
    base {
        Modifier
            .padding(topBottom = (0.5).em, leftRight = (0.75).em)
            .lineHeight(1.5)
            .color(Colors.primary)
            .fontFamily("europa", "sans-serif")
            .fontWeight(FontWeight.Normal)
            .transition("all .2s ease-in-out")
    }
    hover {
        Modifier.color(Colors.gray)
    }
}

val OutlinedButtonStyle = ComponentStyle("white-button") {
    base {
        Modifier
            .margin(left = 1.em)
            .backgroundColor(Colors.white)
            .transition("all .2s ease-in-out")
            .padding(topBottom = 0.75.em, leftRight = 1.5.em)
            .borderRadius(32.px)
            .border(
                width = 2.px,
                style = LineStyle.Solid,
                color = Color(Colors.primary)
            )
    }
    hover {
        Modifier
            .backgroundColor(Colors.primary)
    }
}

val OutlinedButtonText = TextStyle.addVariant("button-text") {
    base {
        Modifier
            .color(Colors.primary)
            .transition("all .2s ease-in-out")
    }
    hover {
        Modifier.color(Colors.white)
    }
}
