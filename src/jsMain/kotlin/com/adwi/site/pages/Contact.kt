package com.adwi.site.pages

import androidx.compose.runtime.Composable
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
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Page()
@Composable
fun ContactPage() {
    PageLayout(
        currentPage = NavSections.CONTACT
    ) {
        LogoHeader()
        EmSpacer(4.0)
        Text(
            text = Strings.Contact.howCanIHelp,
            modifier = Modifier
                .maxWidth(800.px)
                .color(Colors.darkGray)
                .fontSize(3.em)
//                .fontWeight(FontWeight.Lighter)
        )
        EmSpacer(4.0)
        ContactForm()
        EmSpacer(4.0)
    }
}