package io.github.u1tramarinet.androidcomposeutility

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection

@Composable
operator fun PaddingValues.plus(another: PaddingValues): PaddingValues {
    val layoutDirection = LocalLayoutDirection.current
    return PaddingValues(
        top = calculateTopPadding() + another.calculateTopPadding(),
        start = calculateStartPadding(layoutDirection) + another.calculateStartPadding(
            layoutDirection
        ),
        end = calculateEndPadding(layoutDirection) + another.calculateEndPadding(layoutDirection),
        bottom = calculateBottomPadding() + another.calculateBottomPadding(),
    )
}