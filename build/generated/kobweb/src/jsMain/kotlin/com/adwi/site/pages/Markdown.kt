package com.adwi.site.pages

import androidx.compose.runtime.*
import com.varabyte.kobweb.core.*
import com.varabyte.kobwebx.markdown.*

@Page
@Composable
fun MarkdownPage() {
    CompositionLocalProvider(LocalMarkdownContext provides MarkdownContext("Markdown.md", mapOf("root" to listOf(".components.layouts.PageLayout(\"MARKDOWN\")")))) {
        com.adwi.site.components.layouts.PageLayout("MARKDOWN") {
            org.jetbrains.compose.web.dom.H2(attrs = { id("markdown-example") }) {
                com.varabyte.kobweb.silk.components.text.Text("Markdown Example")
            }
            org.jetbrains.compose.web.dom.P {
                com.varabyte.kobweb.silk.components.text.Text("This site is generated from markdown.")
            }
            org.jetbrains.compose.web.dom.P {
                com.varabyte.kobweb.silk.components.text.Text("Create rich, dynamic web apps with ease, leveraging ")
                com.varabyte.kobweb.silk.components.navigation.Link("https://kotlinlang.org/", "Kotlin")
                com.varabyte.kobweb.silk.components.text.Text(" and ")
                com.varabyte.kobweb.silk.components.navigation.Link("https://compose-web.ui.pages.jetbrains.team/", "Web Compose")
                com.varabyte.kobweb.silk.components.text.Text(".")
            }
            org.jetbrains.compose.web.dom.P {
                com.varabyte.kobweb.silk.components.text.Text("Markdown also supports")
            }
            org.jetbrains.compose.web.dom.Pre { org.jetbrains.compose.web.dom.Code { org.jetbrains.compose.web.dom.Text("""Multi-line
code blocks
""") } }
            org.jetbrains.compose.web.dom.P {
                com.varabyte.kobweb.silk.components.text.Text("and ")
                org.jetbrains.compose.web.dom.Code {
                    com.varabyte.kobweb.silk.components.text.Text("inline")
                }
                com.varabyte.kobweb.silk.components.text.Text(" code as well.")
            }
            com.adwi.site.components.widgets.GoHomeLink()
        }
    }
}
