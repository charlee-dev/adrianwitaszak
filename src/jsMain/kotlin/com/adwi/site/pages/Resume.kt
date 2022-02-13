package com.adwi.site.pages

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.BulletMark
import com.adwi.site.components.composables.BulletPoint
import com.adwi.site.components.composables.ColoredText
import com.adwi.site.components.composables.Divider
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.GoHomeButton
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.layouts.PageLayout
import com.adwi.site.components.sections.LogoHeader
import com.adwi.site.components.sections.NavSections
import com.adwi.site.components.sections.WorkItem
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.adwi.site.model.Education
import com.adwi.site.model.Experience
import com.adwi.site.model.educations
import com.adwi.site.model.experiences
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.borderWidth
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.core.Page
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.A

@Page()
@Composable
fun Resume() {
    PageLayout(currentPage = NavSections.RESUME) {
        LogoHeader()
        EmSpacer(3.0)
        ResumeHeader()
        EmSpacer(5.0)
        Box(contentAlignment = Alignment.Center,
            modifier = Modifier.fillMaxWidth().backgroundColor(Colors.primary).padding(top = 0.em, bottom = 98.em)) {
            EmSpacer(6.0)
            H1Text(text = "Experience", color = Colors.white)
        }
        ExperienceCard(items = experiences)
        EmSpacer(3.0)
        EducationLayout()
        EmSpacer(6.0)
        GoHomeButton()
        EmSpacer(5.0)
    }
}

@Composable
fun EducationLayout() {
    Column(modifier = Modifier.margin(bottom = .3.em)) {
        H1Text(text = "Education")
        EmSpacer()
        educations.forEach {
            EducationItem(it)
            EmSpacer()
        }
    }
}

@Composable
fun EducationItem(
    item: Education,
) {
    Row {
        Box(modifier = Modifier.padding(top = 0.5.em)) {
            BulletMark()
        }
        EmSpacer()
        Column {
            Text(text = item.date,
                modifier = Modifier.fontSize(1.25.em).fontWeight(FontWeight.Normal).color(Color.darkgray))
            A(href = item.link) {
                Text(text = item.schoolName, modifier = Modifier.fontSize(1.5.em).fontWeight(FontWeight.Normal))
            }
            if (item.specialization.isNotEmpty()) {
                Text(text = item.specialization, modifier = Modifier.fontSize(1.25.em))
            }
        }
    }
}

@Composable
private fun ExperienceCard(
    items: List<Experience>,
) {
    FullWidthLayout(modifier = Modifier.margin(bottom = 3.em)) {
        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = ExperienceColumnStyle.toModifier()) {
            items.forEachIndexed() { index, exp ->
                if (index != 0) {
                    Divider(marginVertical = 2)
                }
                ExperienceItem(item = exp)
            }
        }
    }
}

@Composable
private fun ResumeHeader() {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier) {
        H1Text(
            text = Strings.Contact.name,
//            color = Colors.white
        )
        Row(verticalAlignment = Alignment.CenterVertically) {
            H2Subtitle(
                text = Strings.Contact.address,
//                color = Colors.white
            )
            EmSpacer(2.0)
            H2Subtitle(
                text = Strings.Contact.email,
//                color = Colors.white
            )
        }
    }
}

@Composable
private fun ExperienceItem(
    item: Experience,
) {
    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth().margin(1.em)) {
        WorkItem(item = item)
        EmSpacer(2.0)
        TitleWithDate(title = item.title, date = item.date)
        EmSpacer()
        Text(text = item.description, modifier = Modifier)
        Row {
            StackColumn(title = "Stack", items = item.stack)
            EmSpacer(3.0)
            StackColumn(title = "Features", items = item.features)
        }
    }
}

@Composable
fun TitleWithDate(
    title: String,
    date: String,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Text(text = title, modifier = Modifier.fontSize(1.5.em).fontWeight(FontWeight.Bold))
        EmSpacer()
        Text(text = date, modifier = Modifier.fontSize(1.25.em).fontWeight(FontWeight.Normal).color(Color.darkgray))
    }
}

@Composable
private fun StackColumn(
    title: String,
    items: List<String>,
) {
    Column(horizontalAlignment = Alignment.Start, modifier = Modifier.width(300.px)) {
        ColoredText(text = title)
        items.forEach {
            BulletPoint(it)
        }
    }
}

val ExperienceColumnStyle = ComponentStyle("experience-column") {
    base {
        Modifier.fillMaxWidth(90.percent).maxWidth(1000.px).padding(leftRight = 2.em, topBottom = 3.em)
            .margin(top = (-92).em, bottom = 2.em).backgroundColor(Colors.white).borderRadius(20.px).borderWidth(1.px)
            .borderColor(Color.lightgray).boxShadow("0 5px 5px 0 rgb(233 240 243 / 50%), 0 0 0 1px #e6ecf8")
    }
}