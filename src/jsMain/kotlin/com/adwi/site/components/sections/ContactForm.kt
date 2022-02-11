package com.adwi.site.components.sections

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.adwi.site.components.composables.EmSpacer
import com.varabyte.kobweb.compose.css.FontWeight
import com.varabyte.kobweb.compose.foundation.layout.Column
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.asAttributesBuilder
import com.varabyte.kobweb.compose.ui.modifiers.fillMaxWidth
import com.varabyte.kobweb.compose.ui.modifiers.fontSize
import com.varabyte.kobweb.compose.ui.modifiers.fontWeight
import com.varabyte.kobweb.compose.ui.modifiers.maxWidth
import com.varabyte.kobweb.compose.ui.modifiers.padding
import com.varabyte.kobweb.silk.components.text.Text
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.em
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
    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        Text(
            text = title,
            modifier = Modifier
                .fontWeight(FontWeight.Lighter)
        )
        EmSpacer()

        TextInput(value = value) {
            onInput { onValueChanged(it.value) }
            Modifier.fontSize(6.em)
        }
        var inputState by remember { mutableStateOf("Some Text") }

        Input(type = InputType.Text) {
            value(inputState)
            onInput { inputState =  it.value }

        }
        EmSpacer()
        val text = remember { mutableStateOf("") }

        TextArea(
            value = text.value,
            attrs = {
                onInput {
                    text.value = it.value
                }
            }
        )
    }
}