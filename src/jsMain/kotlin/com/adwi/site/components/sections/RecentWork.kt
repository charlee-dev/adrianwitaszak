package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.composables.AWButton
import com.adwi.site.components.composables.AWLink
import com.adwi.site.components.composables.ButtonIconStyle
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Box
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.boxShadow
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.onMouseEnter
import com.varabyte.kobweb.compose.ui.modifiers.onMouseLeave
import com.varabyte.kobweb.compose.ui.modifiers.opacity
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.navigation.Link
import com.varabyte.kobweb.silk.components.icons.fa.FaGithubAlt
import com.varabyte.kobweb.silk.components.layout.SimpleGrid
import com.varabyte.kobweb.silk.components.style.breakpoint.ResponsiveValues
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Img

@Composable
fun RecentWork() {
    FullWidthLayout {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
                .padding(topBottom = 1.em, leftRight = 1.em)
                .maxWidth(1200.px)
        ) {
            EmSpacer()
            H1Text(
                text = Strings.Home.recentWork,
            )
            H2Subtitle(text = Strings.Home.recentWorkDescription)
            EmSpacer()
            AWLink(
                text = Strings.Home.emailMe,
                href = ""
            )
            WorkGrid()
            AWButton(
                onClick = {},
                text = Strings.Home.seeMore,
                icon = { isHovered ->
                    FaGithubAlt(
                        modifier = ButtonIconStyle
                            .toModifier()
                            .color(if (isHovered) Colors.white else Colors.primary)
                    )
                }
            )
            EmSpacer(3.0)
        }
    }
}

@Composable
fun WorkGrid(
    modifier: Modifier = Modifier,
) {
    val workList = remember { works }

    SimpleGrid(
        numColumns = ResponsiveValues(1, 2, 3, 3, 3),
        modifier = modifier
            .padding(top = 3.em, bottom = 3.em)
            .maxWidth(1000.px)
    ) {
        workList.forEach { workItem(it) }
    }
}

@Composable
fun workItem(
    work: Work,
) {
    var isHovered by remember { mutableStateOf(false) }

    Link(
        href = work.url,
    ) {
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .margin(1.em)
                .borderRadius(20.px)
                .boxShadow("0 5px 5px 0 rgb(233 240 243 / 50%), 0 0 0 1px #e6ecf8")
        ) {
            Img(
                src = work.image,
                alt = work.title,
                attrs = Modifier
                    .onMouseEnter { isHovered = true }
                    .onMouseLeave { isHovered = false }
                    .borderRadius(18.px)
                    .width(300.px)
                    .height(200.px)
                    .asAttributesBuilder()
            )
        }
        Box(
            modifier = Modifier
                .backgroundColor(Color.darkslateblue)
                .opacity(if (isHovered) 100 else 0)
                .transition("all .2s ease-in-out")
        )
    }
}

data class Work(
    val title: String,
    val description: String,
    val image: String,
    val url: String,
)

val works = listOf(
    Work(
        "Pex Wallpapers",
        "Wallpaper app in Jetpack Compose",
        "/images/work/wallpapers.png",
        "https://github.com/adrianwitaszak/PexWallpapers"),
    Work(
        "Pex Walls XML",
        "Wallpaper app in Xml",
        "/images/work/walls.png",
        "https://github.com/adrianwitaszak/PexWallpapersXml"),
    Work(
        "Shoppe",
        "Shopping app - for Sellers",
        "/images/work/shoppe.png",
        "https://github.com/adrianwitaszak/shoppe"),
    Work(
        "Shoppe - backend",
        "Backend for Shoppe app",
        "/images/work/shoppe-backend.png",
        "https://github.com/adrianwitaszak/shoppe-backend"),
    Work(
        "Betty",
        "Odds Checking App",
        "images/work/betty.png",
        "https://github.com/adrianwitaszak/Betty"
    )
)