package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.lineHeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.navigation.Link
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A
import org.jetbrains.compose.web.dom.Button

@Composable
fun TextLink(
    text: String,
    href: String,
    color: String = Colors.primary,
) {
    var isHovered by remember { mutableStateOf(false) }
    Link(
        href = href,
        attrs = Modifier.textDecorationLine(if (isHovered) TextDecorationLine.Underline else TextDecorationLine.None)
            .asAttributesBuilder()
    ) {
        Text(
            text = text,
            modifier = LinkTextStyle.toModifier()
                .color(color)
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
        )
    }
}

@Composable
fun TextMailto(
    text: String,
    href: String,
    color: String = Colors.primary,
) {
    var isHovered by remember { mutableStateOf(false) }
    A(
        href = href,
        attrs = Modifier.textDecorationLine(if (isHovered) TextDecorationLine.Underline else TextDecorationLine.None)
            .asAttributesBuilder()
    ) {
        Text(
            text = text,
            modifier = LinkTextStyle.toModifier()
                .color(color)
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
        )
    }
}

@Composable
fun ButtonLink(
    href: String,
    text: String = Strings.Navigation.sayHello,
    icon: @Composable (isHovered: Boolean) -> Unit,
) {
    var isHovered by remember { mutableStateOf(false) }

    Link(
        href = href,
        attrs = Modifier
            .textDecorationLine(TextDecorationLine.None)
            .asAttributesBuilder()
    ) {
        Button(
            onClick = {},
            modifier = OutlinedButtonStyle
                .toModifier()
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
                .backgroundColor(if (isHovered) Colors.primary else Colors.white)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                icon(isHovered)
                Text(
                    text = text,
                    variant = LightTextStyleVariant,
                    modifier = TextStyle.toModifier()
                        .color(if (isHovered) Colors.white else Colors.primary)
                )
            }
        }
    }
}

@Composable
fun ButtonMailto(
    href: String,
    text: String = Strings.Navigation.sayHello,
    icon: @Composable (isHovered: Boolean) -> Unit,
) {
    var isHovered by remember { mutableStateOf(false) }

    A(
        href = href,
        attrs = Modifier
            .textDecorationLine(TextDecorationLine.None)
            .asAttributesBuilder()
    ) {
        Button(
            onClick = {},
            modifier = OutlinedButtonStyle
                .toModifier()
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
                .backgroundColor(if (isHovered) Colors.primary else Colors.white)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
            ) {
                icon(isHovered)
                Text(
                    text = text,
                    variant = LightTextStyleVariant,
                    modifier = TextStyle.toModifier()
                        .color(if (isHovered) Colors.white else Colors.primary)
                )
            }
        }
    }
}

@Composable
fun IconLink(
    modifier: Modifier = Modifier,
    href: String,
    icon: @Composable () -> Unit,
) {
    val ctx = rememberPageContext()

    Button(
        onClick = { ctx.router.navigateTo(href)},
        modifier = modifier.backgroundColor(Color.white)
    ) {
        icon()
    }
}

@Composable
fun SocialLinkItem(
    modifier: Modifier = Modifier,
    href: String,
    icon: @Composable (Boolean) -> Unit,
) {
    var isHovered by remember { mutableStateOf(false) }
    Link(
        href = href,
        attrs = modifier.textDecorationLine(TextDecorationLine.None).asAttributesBuilder()
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = ButtonStyle.toModifier()
                .backgroundColor(if (isHovered) Colors.white else Colors.primary)
                .onMouseEnter { isHovered = true }
                .onMouseLeave { isHovered = false }
        ) {
            icon(isHovered)
        }
    }
}

val ButtonStyle = ComponentStyle("button-style") {
    base {
        Modifier
            .size(47.px)
            .borderRadius(100.percent)
            .border(
                width = 1.px,
                color = Color.white,
                style = LineStyle.Solid
            )
            .padding(4.px)
            .margin(.5.em)
    }
    Breakpoint.SM {
        Modifier.margin(1.em)
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