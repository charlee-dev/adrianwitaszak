package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
import com.adwi.site.components.sections.NavSections
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.navigation.Link
import com.varabyte.kobweb.silk.components.icons.fa.FaDev
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.CSSNumeric
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun AWLogo(
    modifier: Modifier = Modifier,
    link: String = NavSections.HOME.route,
) {
    Link(
        href = link,
        attrs = LinkStyle.toModifier().asAttributesBuilder()
    ) {
        FaDev(
            modifier = modifier
                .fontSize(48.px)
                .color(Colors.primary)
        )
    }
}

@Composable
fun AWAvatar(
    modifier: Modifier = Modifier,
    image: String = "images/avatar.png",
    size: CSSNumeric = 210.px,
    margin: CSSNumeric = 2.em
) {
    Img(
        src = image,
        alt = Strings.Home.logoAlt,
        attrs = modifier
            .size(size)
            .margin(margin)
            .asAttributesBuilder()
    )
}

@Composable
fun AWHeroImage(
    image: String = "images/hero.svg",
) {
    Img(
        src = image,
        attrs = HeroStyle.toModifier().asAttributesBuilder()
    )
}

val HeroStyle = ComponentStyle("hero") {
    base {
        Modifier
            .fillMaxWidth(90.percent)
            .margin(bottom = (-3.0).em, top = 2.em)
    }
}

val ButtonIconStyle = ComponentStyle("button-icon") {
    base {
        Modifier
            .fontSize(18.px)
            .color(Colors.primary)
            .padding(right = 1.em)
    }
    hover {
        Modifier.color(Colors.white)
    }
}

val LinkStyle = ComponentStyle("link-icon") {
    base {
        Modifier.textDecorationLine(TextDecorationLine.None)
    }
    hover {
        Modifier.textDecorationLine(TextDecorationLine.Underline)
    }
}