package com.adwi.site.components.layouts

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import com.adwi.site.components.sections.Footer
import com.adwi.site.components.sections.NavHeader
import com.adwi.site.components.sections.NavSections
import com.varabyte.kobweb.compose.css.TextAlign
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxSize
import com.varabyte.kobweb.compose.ui.modifiers.textAlign
import kotlinx.browser.document

@Composable
fun PageLayout(
    currentPage: NavSections = NavSections.HOME,
    content: @Composable () -> Unit,
) {
    LaunchedEffect(currentPage) {
        document.title = "AW | ${currentPage.title}"
    }

    Column(
        modifier = Modifier.fillMaxSize().textAlign(TextAlign.Center),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        NavHeader(currentPage = currentPage)
        content()
        Footer()
    }
}