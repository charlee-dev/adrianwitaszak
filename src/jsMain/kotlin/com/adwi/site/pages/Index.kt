package com.adwi.site.pages

import AboutMe
import androidx.compose.runtime.Composable
import com.adwi.site.components.sections.Footer
import com.adwi.site.components.sections.NavHeader
import com.adwi.site.components.sections.Skills
import com.adwi.site.components.sections.Welcome
import com.adwi.site.components.sections.RecentWork
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.core.Page

@Page("/")
@Composable
fun HomePage() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.fillMaxSize()
    ) {
        NavHeader()
        Welcome()
        AboutMe()
        Skills()
        RecentWork()
        Footer()
    }
}