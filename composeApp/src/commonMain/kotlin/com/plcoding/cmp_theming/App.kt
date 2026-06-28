package com.plcoding.cmp_theming

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.TextStyle
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import cmp_theming.composeapp.generated.resources.Res
import cmp_theming.composeapp.generated.resources.compose_multiplatform
import com.plcoding.cmp_theming.login.LoginScreen
import com.plcoding.cmp_theming.theme.NoteMarkTheme
import com.plcoding.cmp_theming.theme.extraColor

@Composable
@Preview
fun App() {
    NoteMarkTheme {
        LoginScreen()
    }
}