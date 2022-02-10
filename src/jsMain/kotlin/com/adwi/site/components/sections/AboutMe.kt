import androidx.compose.runtime.Composable
import com.adwi.site.components.composables.H1Text
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.layouts.FullWidthLayout
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px

@Composable
fun AboutMe() {
    FullWidthLayout(backgroundColor = Colors.primary) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = AboutMeColumnStyle.toModifier()
        ) {
            H1Text(
                text = Strings.Home.aboutTitle,
                color = Colors.white
            )
            H2Subtitle(
                text = Strings.Home.aboutSubtitle,
                color = Colors.white
            )
        }
    }
}

val AboutMeColumnStyle = ComponentStyle("about-column") {
    base {
        Modifier
            .maxWidth(300.px)
            .padding(bottom = 13.em, top = 6.em)
    }
    Breakpoint.SM {
        Modifier.maxWidth(660.px)
    }
    Breakpoint.MD {
        Modifier.maxWidth(860.px)
    }
    Breakpoint.LG {
        Modifier.maxWidth(1060.px)
    }
}