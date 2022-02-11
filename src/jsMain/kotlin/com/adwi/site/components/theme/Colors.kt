package com.adwi.site.components.theme

import org.jetbrains.compose.web.css.Color

object Colors {
    const val primary = "#7510F7"
    val white = Color.white.toString()
    val gray = Color.gray.toString()
    const val darkGray = "#141c3a"
}

fun contentColor(
    isHovered: Boolean = false,
    enabledColor: String = Colors.white,
    disabledColor: String = Colors.primary
) = if (isHovered) enabledColor else disabledColor