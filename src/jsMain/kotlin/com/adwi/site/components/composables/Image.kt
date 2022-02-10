package com.adwi.site.components.composables

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun AWLogo(
    modifier: Modifier = Modifier,
    link: String = "/",
) {
    Link(
        href = link,
        attrs = Modifier.textDecorationLine(TextDecorationLine.None).asAttributesBuilder()
    ) {
        FaDev(
            modifier = modifier
                .fontSize(48.px)
        )
    }
}

@Composable
fun AWAvatar(
    image: String = "/images/avatar.png",
) {
    Img(
        src = image,
        alt = Strings.Home.logoAlt,
        attrs = Modifier
            .size(210.px)
            .margin(2.em)
            .asAttributesBuilder()
    )
}

@Composable
fun AWHeroImage(
    image: String = "/images/hero.svg",
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
//            .maxWidth(280.px)
            .margin(bottom = (-3.0).em, top = 2.em)
    }
    Breakpoint.SM {
        Modifier
//            .maxWidth(660.px)
    }
    Breakpoint.MD {
        Modifier
//            .maxWidth(860.px)
    }
    Breakpoint.LG {
        Modifier
//            .maxWidth(1060.px)
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