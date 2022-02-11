package com.adwi.site.pages

import AboutMe
import androidx.compose.runtime.Composable
import com.adwi.site.components.layouts.PageLayout
import com.adwi.site.components.sections.NavSections
import com.adwi.site.components.sections.RecentWork
import com.adwi.site.components.sections.Skills
import com.adwi.site.components.sections.Welcome
import com.varabyte.kobweb.core.Page

@Page("/")
@Composable
fun HomePage() {
    PageLayout(
        currentPage = NavSections.HOME
    ) {
        Welcome()
        AboutMe()
        Skills()
        RecentWork()
    }
}