package io.github.u1tramarinet.androidcomposeutility.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Suppress("unused")
@Composable
fun SafeBox(
    modifier: Modifier = Modifier,
    content: @Composable (BoxScope.() -> Unit)
) {
    Box(
        modifier = modifier
            .fillMaxSize()
            .safeContentPadding(),
    ) {
        content()
    }
}