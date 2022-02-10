package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.style.LinkTextStyle
import com.adwi.site.components.style.OutlinedButtonStyle
import com.adwi.site.components.style.OutlinedButtonText
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
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
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.navigation.Link
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px

@Composable
fun AWLink(
    text: String,
    href: String,
    color: String = Colors.primary,
) {
    var isHovered by remember { mutableStateOf(false) }
    Link(
        href = href,
        attrs = Modifier.textDecorationLine(if (isHovered) TextDecorationLine.Underline else TextDecorationLine.None).asAttributesBuilder()
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
fun AWButton(
    onClick: () -> Unit,
    text: String = Strings.Navigation.sayHello,
    icon: @Composable (isHovered: Boolean) -> Unit,
) {
    var isHovered by remember { mutableStateOf(false) }
    Button(
        onClick = onClick,
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
                modifier = TextStyle.toModifier(OutlinedButtonText)
                    .color(if (isHovered) Colors.white else Colors.primary)
            )
        }
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