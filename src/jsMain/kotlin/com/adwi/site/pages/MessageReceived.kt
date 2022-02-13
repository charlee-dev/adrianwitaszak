package com.adwi.site.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adwi.site.components.composables.BoldTextStyle
import com.adwi.site.components.composables.ButtonLink
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.composables.TextStyle
import com.adwi.site.components.sections.NavSections
import com.adwi.site.components.theme.contentColor
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Spacer
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.size
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.icons.fa.FaHome
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import kotlinx.browser.document
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.H1
import org.jetbrains.compose.web.dom.Img

@Page("/success")
@Composable
fun MessageReceived() {

    LaunchedEffect(NavSections.MESSAGE_RECEIVED.title) {
        document.title = "AW | ${NavSections.MESSAGE_RECEIVED.title}"
    }

    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Img(
                src = "images/success.svg",
                alt = "Message received image",
                attrs = Modifier
                    .size(200.px)
                    .asAttributesBuilder()
            )
            H1 {
                Text(
                    text = Strings.Contact.messageReceived,
                    modifier = TextStyle.toModifier(BoldTextStyle)
                )
            }
            H2Subtitle(
                text = Strings.Contact.inTouch
            )
            EmSpacer(4.0)
            ButtonLink(
                href = NavSections.HOME.route,
                text = Strings.Navigation.backToHome
            ) { isHovered ->
                FaHome(
                    modifier = Modifier
                        .color(contentColor(isHovered))
                        .margin(right = 1.em)
                )
            }
        }
    }
}
