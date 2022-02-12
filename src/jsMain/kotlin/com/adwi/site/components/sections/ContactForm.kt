package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.composables.ButtonIconStyle
import com.adwi.site.components.composables.ButtonMailto
import com.adwi.site.components.composables.EmSpacer
import com.adwi.site.components.composables.H2Subtitle
import com.adwi.site.components.theme.Colors
import com.adwi.site.components.theme.contentColor
import com.adwi.site.components.utils.Strings
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.css.Overflow
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.backgroundColor
import com.varabyte.kobweb.compose.ui.modifiers.border
import com.varabyte.kobweb.compose.ui.modifiers.borderColor
import com.varabyte.kobweb.compose.ui.modifiers.borderRadius
import com.varabyte.kobweb.compose.ui.modifiers.color
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.flexGrow
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.margin
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.minHeight
import com.varabyte.kobweb.compose.ui.modifiers.overflowX
import com.varabyte.kobweb.compose.ui.modifiers.overflowY
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.compose.ui.modifiers.transition
import com.varabyte.kobweb.silk.components.forms.Button
import com.varabyte.kobweb.silk.components.icons.fa.FaTelegramPlane
import com.varabyte.kobweb.silk.components.layout.breakpoint.displayIf
import com.varabyte.kobweb.silk.components.style.ComponentStyle
import com.varabyte.kobweb.silk.components.style.active
import com.varabyte.kobweb.silk.components.style.base
import com.varabyte.kobweb.silk.components.style.breakpoint.Breakpoint
import com.varabyte.kobweb.silk.components.style.toModifier
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.attributes.name
import org.jetbrains.compose.web.css.Color
import org.jetbrains.compose.web.css.LineStyle
import org.jetbrains.compose.web.css.em
import org.jetbrains.compose.web.css.px
import org.jetbrains.compose.web.dom.Input

@Composable
fun ContactForm(
    name: String,
    email: String,
    message: String,
    onNameChanged: (String) -> Unit,
    onEmailChanged: (String) -> Unit,
    onMessageChanged: (String) -> Unit,
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = ContactFormStyle.toModifier()
    ) {
        Row(modifier = Modifier.fillMaxWidth()) {
            Column(modifier = Modifier.flexGrow(1)) {
                H2Subtitle(
                    text = "Name",
                    fontSize = 1.2.em,
                    opacity = .8
                )
                Input(
                    type = InputType.Text,
                    attrs = listOf(InputTextStyle, InputStyle).toModifier().asAttributesBuilder() {
                        name(name)
                        onChange { onNameChanged(it.value) }
                    }
                )
            }
            EmSpacer(modifier = Modifier.displayIf(Breakpoint.SM))
            Column(modifier = Modifier.flexGrow(1)) {
                H2Subtitle(
                    text = "Email",
                    fontSize = 1.2.em,
                    opacity = .8
                )
                Input(
                    type = InputType.Email,
                    attrs = listOf(InputTextStyle, InputStyle).toModifier().asAttributesBuilder() {
                        name(email)
                        onChange { onEmailChanged(it.value) }
                    }
                )
            }
        }
        Column(modifier = Modifier.fillMaxWidth()) {
            H2Subtitle(
                text = "Message",
                fontSize = 1.2.em,
                opacity = .8
            )
            Input(
                type = InputType.Text,
                attrs = listOf(InputTextStyle, InputStyle, ResizableStyle).toModifier().asAttributesBuilder() {
                    name(message)
                    onChange { onMessageChanged(it.value) }
                }
            )
        }
        EmSpacer(2.0)
        ButtonMailto(
            href = "mailto:adrianwitaszak@gmail.com?subject=$name-$email&body=$message",
            text = Strings.Contact.submit,
            icon = { isHovered ->
                FaTelegramPlane(
                    modifier = ButtonIconStyle.toModifier()
                        .color(contentColor(isHovered))
                )
            }
        )
    }
}

// Sample https://github.com/varabyte/kobweb/blob/main/examples/todo/src/jsMain/kotlin/todo/components/widgets/TodoForm.kt

val ContactFormStyle = ComponentStyle.base("contact-form") {
    Modifier
        .padding(left = 1.em, right = 1.em, top = 0.em, bottom = 4.em)
        .fillMaxWidth()
        .maxWidth(800.px)
}

val InputTextStyle = ComponentStyle.base("input-text") {
    Modifier
        .fontSize(18.px)
        .fontWeight(FontWeight.Lighter)
        .overflowX(Overflow.Hidden)
        .overflowY(Overflow.Scroll)
        .margin(top = 1.em, bottom = 1.5.em)
}

val ResizableStyle = ComponentStyle("resizable") {
    base {
        Modifier
            .minHeight(200.px)
    }
    Breakpoint.SM {
        Modifier
            .minHeight(400.px)
    }
}

val InputStyle = ComponentStyle("form-input") {
    base {
        Modifier
            .fillMaxWidth()
            .padding(15.px)
            .backgroundColor(Color.white)
            .borderRadius(5.px)
            .border(1.px, LineStyle.Solid, Color.lightgray).transition("color 0.15s ease, border-color 0.15s ease")

    }
    active {
        Modifier.borderColor(Color(Colors.primary))
    }
}