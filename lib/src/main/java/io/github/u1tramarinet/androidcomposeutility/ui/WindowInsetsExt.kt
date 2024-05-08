package io.github.u1tramarinet.androidcomposeutility.ui

import android.util.Log
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Suppress("unused")
@Composable
fun WindowInsets.copy(
    density: Density = LocalDensity.current,
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    left: Dp = this.getLeft(density, layoutDirection).dp,
    top: Dp = this.getTop(density).dp,
    right: Dp = this.getRight(density, layoutDirection).dp,
    bottom: Dp = this.getBottom(density).dp,
) = WindowInsets(left = left, top = top, right = right, bottom = bottom)

@Composable
fun WindowInsets.overlap(
    density: Density = LocalDensity.current,
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    paddingValues: PaddingValues,
) = WindowInsets(
    left = max(
        this.getLeft(density, layoutDirection).dp,
        paddingValues.calculateLeftPadding(layoutDirection)
    ),
    top = max(this.getTop(density).dp, paddingValues.calculateTopPadding()),
    right = max(
        this.getRight(density, layoutDirection).dp,
        paddingValues.calculateRightPadding(layoutDirection)
    ),
    bottom = max(this.getBottom(density).dp, paddingValues.calculateBottomPadding())
)

fun max(a: Dp, b: Dp) = if (a.value >= b.value) {
    Log.d("max", "$a >= $b")
    a
} else {
    Log.d("max", "$a < $b")
    b
}