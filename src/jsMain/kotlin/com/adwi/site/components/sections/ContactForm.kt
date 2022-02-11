package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.theme.Colors
import com.varabyte.kobweb.compose.css.FontStyle
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.TextDecorationLine
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontStyle
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.height
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.textDecorationLine
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.compose.ui.modifiers.width
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.placeholderShown
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.attributes.placeholder
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.cssRem
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.EmailInput
import org.jetbrains.compose.web.dom.Input
import org.jetbrains.compose.web.dom.TextArea
import org.jetbrains.compose.web.dom.TextInput

@Composable
fun ContactForm(
) {
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .maxWidth(800.px)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth()
        ) {
            FormItem(
                title = "Name",
                onValueChanged = { name = it },
                value = name
            )
            FormItem(
                title = "Email",
                onValueChanged = { email = it },
                value = email
            )
        }
    }
}

@Composable
fun FormItem(
    modifier: Modifier = Modifier,
    title: String,
    onValueChanged: (String) -> Unit,
    value: String = "Emailsdasdad",
) {
    var todo by remember { mutableStateOf("") }

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fontWeight(FontWeight.Lighter)
        )
        EmSpacer()

        Input(
            InputType.Text,
            attrs = listOf(TodoStyle, TodoTextStyle, TodoInputStyle).toModifier()
                .asAttributesBuilder() {
                    placeholder(value = "test")
                    name("todo")
                    onChange { todo = it.value }
                }
        )
    }
}

// https://github.com/varabyte/kobweb/blob/main/examples/todo/src/jsMain/kotlin/todo/components/widgets/TodoForm.kt

val TodoStyle = ComponentStyle.base("todo") {
    Modifier
        .width(85.percent)
        .height(5.cssRem)
        .border(1.px, LineStyle.Solid, Color("#7510F7"))
        .borderRadius(10.px)
        .transition("color 0.15s ease, border-color 0.15s ease")
        .textDecorationLine(TextDecorationLine.None)
}

val TodoTextStyle = ComponentStyle.base("todo-text") {
    Modifier
        .padding(1.5.cssRem)
        .fontSize(1.25.cssRem)
        // We use "A" tags for accessibility, but we want our colors to come from our container
        .color("inherit")
}

val TodoInputStyle = ComponentStyle("todo-input") {
    base {
        Modifier
            .fillMaxWidth()
            .backgroundColor(Color.transparent)
            .border(0.px)
    }

    placeholderShown {
        Modifier.fontStyle(FontStyle.Italic)
    }
}