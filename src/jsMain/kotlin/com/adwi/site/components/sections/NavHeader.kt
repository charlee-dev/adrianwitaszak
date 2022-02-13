package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.AWLogo
import com.adwi.site.components.composables.ButtonIconStyle
import com.adwi.site.components.composables.ButtonLink
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.IconLink
import com.adwi.site.components.composables.TextLink
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontFamily
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.core.rememberPageContext
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaRedo
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegramPlane
import com.varabyte.kobweb.silk.components.icons.fa.FaWindowClose
import com.varabyte.kobweb.silk.components.icons.fa.IconStyle
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.hover
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

enum class NavSections(val title: String, val route: String) {
    HOME("Home", "/"),
    RESUME("Resume", "/resume"),
    CONTACT("Contact", "/contact"),
//    MARKDOWN("Markdown", "/markdown") // Kept it for now
}

@Composable
fun NavHeader(
    currentPage: NavSections,
    onClearClick: () -> Unit,
) {
    val ctx = rememberPageContext()

    FullWidthLayout {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = NavBarRowStyle.toModifier()
        ) {
            AWLogo()
            Spacer()
            if (currentPage != NavSections.RESUME && currentPage != NavSections.CONTACT) {
                TextLink(
                    text = NavSections.RESUME.title,
                    href = NavSections.RESUME.route,
                    color = Colors.gray
                )
            }
            if (currentPage != NavSections.CONTACT) {
                ButtonLink(
                    href = NavSections.CONTACT.route,
                    icon = { isHovered ->
                        FaTelegramPlane(
                            modifier = ButtonIconStyle
                                .toModifier()
                                .color(if (isHovered) Colors.white else Colors.primary)
                        )
                    }
                )
            } else {
                Button(
                    onClick = { onClearClick() },
                    modifier = Modifier.backgroundColor(Color.white)
                ) {
                    FaRedo(
                        modifier = IconLinkStyle.toModifier()
                            .onClick { onClearClick() }
                            .cursor(Cursor.Pointer)
                    )
                }
                EmSpacer(2.0)
                IconLink(
                    href = NavSections.HOME.route
                ) {
                    FaWindowClose(
                        style = IconStyle.OUTLINE,
                        modifier = IconLinkStyle.toModifier()
                    )
                }
            }
        }
    }
}

val NavBarRowStyle = ComponentStyle("navbar-row") {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 2.em, leftRight = 0.em)
            .padding(left = 2.em, right = 2.em)
    }
    Breakpoint.SM {
        Modifier.padding(left = 6.em, right = 6.em)
    }
    Breakpoint.MD {
        Modifier.padding(left = 6.em, right = 6.em)
    }
    Breakpoint.LG {
        Modifier.padding(left = 24.em, right = 24.em)
    }
}

val IconLinkStyle = ComponentStyle("icon-link-style") {
    base {
        Modifier
            .color(Colors.primary)
            .fontSize(24.px)
    }
}

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
