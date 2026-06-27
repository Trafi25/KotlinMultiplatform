package com.plcoding.cmp_theming

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "CMP-Theming",
    ) {
        App()
    }
}