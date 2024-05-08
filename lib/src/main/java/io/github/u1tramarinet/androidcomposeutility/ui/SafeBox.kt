package io.github.u1tramarinet.androidcomposeutility.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

/**
 * SafeContentなPaddingと[contentPadding]を比較して、広い方を採用します.
 */
@Suppress("unused")
@Composable
fun SafeBox(
    modifier: Modifier = Modifier,
    contentPadding: PaddingValues,
    content: @Composable (BoxScope.(innerPadding: PaddingValues) -> Unit)
) {
    val innerPadding = WindowInsets.safeContent.overlap(paddingValues = contentPadding)
    Box(modifier = modifier.fillMaxSize()) {
        content(innerPadding.asPaddingValues())
    }
}