package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import com.adwi.site.components.theme.Colors
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1

@Composable
fun H1Text(
    text: String,
    color: String = Colors.darkGray,
) {
    H1 {
        Text(
            text = text,
            modifier = TextStyle.toModifier(BoldTextStyle)
                .color(color)
        )
    }
}

@Composable
fun H2Subtitle(
    text: String,
    color: String = Colors.darkGray,
    fontSize: CSSNumeric = 1.em,
    opacity: Number = 1
) {
    Text(
        text = text,
        modifier = TextStyle
            .toModifier(LightTextStyleVariant)
            .color(color)
            .fontSize(fontSize)
            .opacity(opacity)
    )
}

@Composable
fun ColoredText(
    text: String,
    color: String = Colors.primary,
) {
    Text(
        text = text,
        modifier = TextStyle.toModifier(NormalTextStyle)
            .color(color)
            .margin(top = 50.px, bottom = 1.em)
    )
}

@Composable
fun SectionBody(
    text: String,
    color: String = Colors.darkGray,
) {
    Text(text = text,
        modifier = TextStyle.toModifier(LightTextStyleVariant)
            .color(color)
            .margin(left = .83.em, right = .83.em, bottom = .5.em)
    )
}

val TextStyle = ComponentStyle("text") {
    base {
        Modifier
            .fontFamily("europa", "sans-serif")
            .fontSize(1.em)
            .textAlign(TextAlign.Center)
            .maxWidth(1000.px)
    }
    Breakpoint.SM {
        Modifier.fontSize(1.2.em)
    }
    Breakpoint.MD {
        Modifier.fontSize(1.5.em)
    }
    Breakpoint.LG {
        Modifier.fontSize(1.75.em)
    }
}

val LightTextStyleVariant = TextStyle.addVariant("light-text") {
    base {
        Modifier
            .fontWeight(FontWeight.Lighter)
            .fontSize(1.em)
    }

}

val BoldTextStyle = TextStyle.addVariant("bold-text") {
    base {
        Modifier
            .fontWeight(FontWeight.Bold)
            .fontSize(.85.em)
            .textAlign(TextAlign.Justify)
    }
}

val NormalTextStyle = TextStyle.addVariant("normal-text") {
    base {
        Modifier.fontWeight(FontWeight.Normal)
    }
}