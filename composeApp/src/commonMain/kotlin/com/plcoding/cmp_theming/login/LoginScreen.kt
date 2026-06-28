package com.plcoding.cmp_theming.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import cmp_theming.composeapp.generated.resources.Res
import com.plcoding.cmp_theming.design_system.NoteMarkButton
import com.plcoding.cmp_theming.design_system.NoteMarkLink
import com.plcoding.cmp_theming.design_system.NoteMarkTextField

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
        Column (
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .clip(RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 15.dp
                ) )
                .background(MaterialTheme.colorScheme.surfaceContainerLowest)
                .padding(horizontal = 16.dp,
                    vertical = 24.dp)
                .consumeWindowInsets(WindowInsets.navigationBars)){
            LogInHeaderSection(modifier = Modifier.fillMaxWidth())
            LoginFormSection(
                emailText = emailText,
                onEmailTextChange = {emailText = it},
                passwordText = passwordText,
                onPasswordTextChange = {passwordText = it},
                modifier = Modifier.fillMaxWidth()
            )
        }
    }

}

@Composable
fun LogInHeaderSection(modifier: Modifier = Modifier){
    Column (
        modifier = modifier
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