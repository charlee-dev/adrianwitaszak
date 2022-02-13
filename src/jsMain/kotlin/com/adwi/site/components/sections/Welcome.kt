package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.AWAvatar
import com.adwi.site.components.composables.AWHeroImage
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.padding
import org.jetbrains.compose.web.css.em

@Composable
fun Welcome() {
    FullWidthLayout {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.padding(topBottom = 3.em, leftRight = 2.em)
        ) {
            H1Text(text = Strings.Contact.name)
            H2Subtitle(text = Strings.Home.welcomeHeaderSubtitle)
            AWAvatar()
            AWHeroImage()
        }
    }
}
