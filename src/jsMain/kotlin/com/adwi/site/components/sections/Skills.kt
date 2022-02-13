package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.ColoredText
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.composables.SectionBody
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Column
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
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.icons.fa.FaMobile
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

val tools = listOf("Android Studio", "IntelliJ IDEA", "Xcode")

@Composable
fun Skills(content: @Composable () -> Unit) {
    FullWidthLayout {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = SkillsColumnStyle.toModifier()
        ) {
            content()
        }
    }
}

@Composable
fun SkillsContent() {
    FaMobile(
        modifier = Modifier
            .fontSize(80.px)
            .color(Colors.primary)
    )
    H1Text(text = Strings.Home.welcomeHeader)
    H2Subtitle(
        text = Strings.Home.iLikeToCode,
    )
    ColoredText(text = Strings.Home.languages)
    SectionBody(text = Strings.Home.languagesList)
    ColoredText(text = Strings.Home.devTools)
    tools.forEach {
        SectionBody(text = it)
    }
}

val SkillsColumnStyle = ComponentStyle("skills-column") {
    base {
        Modifier
            .fillMaxWidth()
            .maxWidth(1000.px)
            .padding(leftRight = 2.em, topBottom = 3.em)
            .margin(top = (-7).em, bottom = 2.em)
            .backgroundColor(Colors.white)
            .borderRadius(20.px)
            .borderWidth(1.px)
            .borderColor(Color.lightgray)
            .boxShadow("0 5px 5px 0 rgb(233 240 243 / 50%), 0 0 0 1px #e6ecf8")
    }
}
