import com.varabyte.kobweb.navigation.Router
import kotlin.Unit
import kotlinx.browser.document
import kotlinx.browser.window
import org.jetbrains.compose.web.renderComposable

public fun main(): Unit {
    val router = Router()
    router.register("/") { com.adwi.site.pages.HomePage() }
    router.register("/markdown") { com.adwi.site.pages.MarkdownPage() }

    com.varabyte.kobweb.silk.initSilkHook = { ctx ->
        ctx.theme.registerComponentStyle(com.adwi.site.components.sections.NavBarRowStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.sections.SkillsColumnStyle)
        ctx.theme.registerComponentStyle(AboutMeColumnStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.composables.TextStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.composables.ButtonStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.composables.HeroStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.composables.ButtonIconStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.style.NavItemTextStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.style.LinkTextStyle)
        ctx.theme.registerComponentStyle(com.adwi.site.components.style.OutlinedButtonStyle)
        ctx.theme.registerComponentVariants(com.adwi.site.components.composables.LightTextStyleVariant)
        ctx.theme.registerComponentVariants(com.adwi.site.components.composables.BoldTextStyle)
        ctx.theme.registerComponentVariants(com.adwi.site.components.composables.NormalTextStyle)
        ctx.theme.registerComponentVariants(com.adwi.site.components.style.OutlinedButtonText)
        com.adwi.site.updateTheme(ctx)
    }

    router.navigateTo(window.location.href.removePrefix(window.location.origin))

    // For SEO, we may bake the contents of a page in at build time. However, we will overwrite them
    // the first time we render this page with their composable, dynamic versions. Think of this as
    // poor man's hydration :)
    // See also: https://en.wikipedia.org/wiki/Hydration_(web_development)
    val root = document.getElementById("root")!!
    while (root.firstChild != null) {
        root.removeChild(root.firstChild!!)
    }

    renderComposable(rootElementId = "root") {
        com.adwi.site.MyApp {
            router.renderActivePage()
        }
    }
}
