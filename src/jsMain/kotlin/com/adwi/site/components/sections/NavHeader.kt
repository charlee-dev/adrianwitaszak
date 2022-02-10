package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.AWButton
import com.adwi.site.components.composables.AWLink
import com.adwi.site.components.composables.AWLogo
import com.adwi.site.components.composables.ButtonIconStyle
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegramPlane
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.em

@Composable
fun NavHeader() {
    FullWidthLayout {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = NavBarRowStyle.toModifier()
        ) {
            AWLogo()
            Spacer()
            AWLink(
                text = Strings.Navigation.resume,
                href = "",
                color = Colors.gray
            )
            AWButton(onClick = {
                // TODO()
            },
                icon = { isHovered ->
                    FaTelegramPlane(
                        modifier = ButtonIconStyle
                            .toModifier()
                            .color(if (isHovered) Colors.white else Colors.primary)
                    )
                }
            )
        }
    }
}

val NavBarRowStyle = ComponentStyle("navbar") {
    base {
        Modifier
            .fillMaxWidth()
            .margin(topBottom = 2.em, leftRight = 0.em)
            .padding(left = 2.em, right = 2.em)
    }
    Breakpoint.SM {
        Modifier.padding(left = 4.em, right = 4.em)
    }
    Breakpoint.MD {
        Modifier.padding(left = 6.em, right = 6.em)
    }
    Breakpoint.LG {
        Modifier.padding(left = 10.em, right = 10.em)
    }
}
