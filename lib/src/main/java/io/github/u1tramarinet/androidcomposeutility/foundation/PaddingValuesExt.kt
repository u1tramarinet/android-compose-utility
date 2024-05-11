package io.github.u1tramarinet.androidcomposeutility.foundation

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.LayoutDirection

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

@Composable
fun PaddingValues.copy(
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    start: Dp = calculateStartPadding(layoutDirection),
    top: Dp = calculateTopPadding(),
    end: Dp = calculateEndPadding(layoutDirection),
    bottom: Dp = calculateBottomPadding(),
) = PaddingValues(
    top = top,
    start = start,
    end = end,
    bottom = bottom,
)

@Composable
fun PaddingValues.max(
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    start: Dp = calculateStartPadding(layoutDirection),
    top: Dp = calculateTopPadding(),
    end: Dp = calculateEndPadding(layoutDirection),
    bottom: Dp = calculateBottomPadding(),
) = PaddingValues(
    start = max(start, calculateStartPadding(layoutDirection)),
    top = max(top, calculateTopPadding()),
    end = max(end, calculateEndPadding(layoutDirection)),
    bottom = max(bottom, calculateBottomPadding()),
)

@Composable
fun PaddingValues.max(
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    all: Dp,
) = PaddingValues(
    start = max(all, calculateStartPadding(layoutDirection)),
    top = max(all, calculateTopPadding()),
    end = max(all, calculateEndPadding(layoutDirection)),
    bottom = max(all, calculateBottomPadding()),
)

@Composable
fun PaddingValues.max(
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    vertical: Dp,
    horizontal: Dp,
) = PaddingValues(
    start = max(horizontal, calculateStartPadding(layoutDirection)),
    top = max(vertical, calculateTopPadding()),
    end = max(horizontal, calculateEndPadding(layoutDirection)),
    bottom = max(vertical, calculateBottomPadding()),
)
