package io.github.u1tramarinet.androidcomposeutility.ui

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.safeContent
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.max

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
    val density = LocalDensity.current
    Log.d("SafeBox", "[density]density=${density.density}, fontScale=${density.fontScale}")
    val layoutDirection = LocalLayoutDirection.current
    Log.d("SafeBox", "[layoutDirection]${layoutDirection.name}")
    val innerPadding = with(density) {
        val safeContent = WindowInsets.safeContent
        val top = maxPadding(
            safeContent.getTop(density).toDp(),
            contentPadding.calculateTopPadding(),
            "top"
        )
        val bottom =
            maxPadding(
                safeContent.getBottom(density).toDp(),
                contentPadding.calculateBottomPadding(),
                "bottom"
            )
        val start = maxPadding(
            safeContent.getLeft(density, layoutDirection).toDp(),
            contentPadding.calculateStartPadding(layoutDirection),
            "start"
        )
        val end = maxPadding(
            safeContent.getRight(density, layoutDirection).toDp(),
            contentPadding.calculateEndPadding(layoutDirection),
            "end"
        )
        PaddingValues(start = start, top = top, end = end, bottom = bottom)
    }
    Box(modifier = modifier.fillMaxSize()) {
        content(innerPadding)
    }
}

private fun maxPadding(safeContentPadding: Dp, contentPadding: Dp, tag: String): Dp {
    val result = max(safeContentPadding, contentPadding)
    Log.d(
        "SafeBox",
        "[$tag]result=${result.value} dp, " +
                "safeContent=${safeContentPadding.value} dp, " +
                "contentPadding=${contentPadding.value} dp"
    )
    return result
}