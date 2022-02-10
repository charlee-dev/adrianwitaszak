import com.varabyte.kobweb.navigation.Router
import kotlin.Unit
import kotlinx.browser.document
import kotlinx.browser.window
import kotlinx.dom.hasClass
import kotlinx.dom.removeClass
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.EventSource
import org.w3c.dom.EventSourceInit
import org.w3c.dom.MessageEvent
import org.w3c.dom.`get`

private fun forceReloadNow(): Unit {
    window.stop()
    window.location.reload()
}

private fun handleServerStatusEvents(): Unit {
    val status = document.getElementById("status")!!
    var lastVersion: Int? = null
    var shouldReload = false

    val warningIcon = status.children[0]!!
    val spinnerIcon = status.children[1]!!
    val statusText = status.children[2]!!

    status.addEventListener("transitionend", {
        if (status.hasClass("fade-out")) {
            status.removeClass("fade-out")
            if (shouldReload) {
                forceReloadNow()
            }
        }
    })

    val eventSource = EventSource("/api/kobweb-status", EventSourceInit(true))
    eventSource.addEventListener("version", { evt ->
        val version = (evt as MessageEvent).data.toString().toInt()
        if (lastVersion == null) {
            lastVersion = version
        }
        if (lastVersion != version) {
            lastVersion = version
            if (status.className.isNotEmpty()) {
                shouldReload = true
            } else {
                // Not sure if we can get here but if we can't rely on the status transition
                // to reload we should do it ourselves.
                forceReloadNow()
            }
        }
    })

    eventSource.addEventListener("status", { evt ->
        val values: dynamic = JSON.parse<Any>((evt as MessageEvent).data.toString())
        val text = values.text as String
        val isError = (values.isError as String).toBoolean()
        if (text.isNotBlank()) {
            warningIcon.className = if (isError) "visible" else "hidden"
            spinnerIcon.className = if (isError) "hidden" else "visible"
            statusText.innerHTML = "<i>$text</i>"
            status.className = "fade-in"
        } else {
            if (status.className == "fade-in") {
                status.className = "fade-out"
            }
        }
    })

    eventSource.onerror = { eventSource.close() }
}

public fun main(): Unit {
    handleServerStatusEvents()

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
