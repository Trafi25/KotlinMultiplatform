package com.plcoding.cmp_theming.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.displayCutout
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.adaptive.currentWindowAdaptiveInfo
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.DrawModifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.AlignmentLine
import androidx.compose.ui.text.input.TransformedText
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.window.core.layout.WindowSizeClass
import androidx.window.core.layout.WindowWidthSizeClass
import cmp_theming.composeapp.generated.resources.Res
import com.plcoding.cmp_theming.design_system.NoteMarkButton
import com.plcoding.cmp_theming.design_system.NoteMarkLink
import com.plcoding.cmp_theming.design_system.NoteMarkTextField
import com.plcoding.cmp_theming.util.DeviceConfiguration

@Composable
fun LoginScreen(
) {
    var emailText by remember { mutableStateOf("") }
    var passwordText by remember { mutableStateOf("") }
    Scaffold (
        modifier = Modifier.fillMaxSize(),
        contentWindowInsets = WindowInsets.statusBars
    )
    {
        innerPadding ->
        val rootModifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .clip(RoundedCornerShape(
                topStart = 15.dp,
                topEnd = 15.dp
            ) )
            .background(MaterialTheme.colorScheme.surfaceContainerLowest)
            .padding(horizontal = 16.dp,
                vertical = 24.dp)
            .consumeWindowInsets(WindowInsets.navigationBars)
        val windowSizeClass = currentWindowAdaptiveInfo().windowSizeClass
        val deviceConfiguration = DeviceConfiguration.fromWindowSizeClass(windowSizeClass)
        when (deviceConfiguration) {
            DeviceConfiguration.MOBILE_PORTRAIT ->{
                Column(
                    modifier = rootModifier,
                    verticalArrangement = Arrangement.spacedBy(32.dp)
                ) {
                    LogInHeaderSection(
                        modifier = Modifier.fillMaxWidth()
                    )
                    LoginFormSection(
                        emailText = emailText,
                        onEmailTextChange = { emailText = it },
                        passwordText = passwordText,
                        onPasswordTextChange = { passwordText = it },
                        modifier = Modifier
                            .fillMaxWidth()
                    )
                }
            }
            DeviceConfiguration.MOBILE_LANDSCAPE ->  Row (
            modifier = rootModifier
                .windowInsetsPadding(WindowInsets.displayCutout)
                .padding(horizontal = 32.dp),
            horizontalArrangement = Arrangement.spacedBy(32.dp)
        ){
            LogInHeaderSection(modifier = Modifier.weight(1f))
            LoginFormSection(
                emailText = emailText,
                onEmailTextChange = {emailText = it},
                passwordText = passwordText,
                onPasswordTextChange = {passwordText = it},
                modifier = Modifier.weight(2f)
                    .verticalScroll(rememberScrollState())
            )
        }
            DeviceConfiguration.TABLET_PORTRAIT,
            DeviceConfiguration.TABLET_LANDSCAPE,
            DeviceConfiguration.DESKTOP -> {
                Column(
                    modifier = rootModifier
                        .padding(top = 48.dp)
                        .verticalScroll(rememberScrollState()),
                    verticalArrangement = Arrangement.spacedBy(32.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    LogInHeaderSection(
                        modifier = Modifier.widthIn(max = 540.dp),
                        alignment = Alignment.CenterHorizontally
                    )
                    LoginFormSection(
                        emailText = emailText,
                        onEmailTextChange = { emailText = it },
                        passwordText = passwordText,
                        onPasswordTextChange = { passwordText = it },
                        modifier = Modifier
                            .widthIn(max = 540.dp)
                    )
                }
            }

        }
    }

}

@Composable
fun LogInHeaderSection(modifier: Modifier = Modifier,
                       alignment: Alignment.Horizontal = Alignment.Start
){
    Column (
        modifier = modifier,
        horizontalAlignment = alignment
    ){
        Text(
            text = "Log In",
            style = MaterialTheme.typography.titleLarge)
        Text(
            text = "Capture your thoughts and Ideas",
            style = MaterialTheme.typography.bodyLarge)

    }
}

@Composable
fun LoginFormSection(
    emailText: String,
    onEmailTextChange : (String) -> Unit,
    passwordText: String,
    onPasswordTextChange: (String) -> Unit,
    modifier: Modifier = Modifier){
        Column (
            modifier = modifier
        ) {
            NoteMarkTextField(
                text = emailText,
                onValueChange = onEmailTextChange,
                label = "Email",
                hint = "someEmail@gmail.com",
                isInputSecret = false,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            NoteMarkTextField(
                text = passwordText,
                onValueChange = onPasswordTextChange,
                label = "Password",
                hint = "Password",
                isInputSecret = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(24.dp))
            NoteMarkButton(
                text = "Log in",
                onClick = {},
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            NoteMarkLink(
                "Do not have an account", onClick = {}, modifier = Modifier.align(Alignment.CenterHorizontally)
            )
        }
}