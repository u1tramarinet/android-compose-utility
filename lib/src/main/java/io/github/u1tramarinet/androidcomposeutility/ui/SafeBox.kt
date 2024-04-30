package io.github.u1tramarinet.androidcomposeutility.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SafeBox(
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)
) {
    val systemBarsPadding = WindowInsets.systemBars.asPaddingValues()
    Box(modifier = modifier.padding(systemBarsPadding)) {
        content()
    }
}