package com.adwi.site.pages

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.layouts.PageLayout
import com.adwi.site.components.sections.ContactForm
import com.adwi.site.components.sections.LogoHeader
import com.adwi.site.components.sections.NavSections
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Page()
@Composable
fun ContactPage() {

    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    var message by remember { mutableStateOf("") }

    PageLayout(
        currentPage = NavSections.CONTACT,
        onClearClick = {
            name = ""
            email = ""
            message = ""
            println("cleared")
        }
    ) {
        LogoHeader()
        Text(
            text = Strings.Contact.howCanIHelp,
            modifier = ContactHeaderStyle.toModifier()
        )
        ContactForm(
            name = name,
            email = email,
            message = message,
            onNameChanged = { name = it },
            onEmailChanged = { email = it },
            onMessageChanged = { message = it }
        )
        EmSpacer(4.0)
    }
}

val ContactHeaderStyle = ComponentStyle("contact-header-style") {
    base {
        Modifier
            .maxWidth(800.px)
            .color(Colors.darkGray)
            .fontSize(1.5.em)
            .margin(leftRight = .5.em, topBottom = 2.em)
    }
    Breakpoint.SM {
        Modifier
            .fontSize(2.em)
            .margin(leftRight = .5.em, topBottom = 2.em)
    }
    Breakpoint.LG {
        Modifier
            .fontSize(3.em)
            .margin(leftRight = 1.em, topBottom = 3.em)
    }
}