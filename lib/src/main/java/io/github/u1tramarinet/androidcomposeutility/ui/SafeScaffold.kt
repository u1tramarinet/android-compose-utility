package io.github.u1tramarinet.androidcomposeutility.ui

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.safeContent
import androidx.compose.material3.FabPosition
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.ScaffoldDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp

@Suppress("unused")
@Composable
fun SafeScaffold(
    modifier: Modifier = Modifier,
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    snackBarHost: @Composable () -> Unit = {},
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    containerColor: Color = MaterialTheme.colorScheme.background,
    contentColor: Color = contentColorFor(backgroundColor = containerColor),
    contentWindowInsets: WindowInsets = ScaffoldDefaults.contentWindowInsets,
    contentPadding: PaddingValues = PaddingValues(0.dp),
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        modifier = modifier,
        topBar = topBar,
        bottomBar = bottomBar,
        snackbarHost = snackBarHost,
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        containerColor = containerColor,
        contentColor = contentColor,
        contentWindowInsets = contentWindowInsets,
        content = { innerPadding ->
            content(
                calculateSafeContentPadding(
                    originalContentPadding = innerPadding,
                    userContentPadding = contentPadding,
                )
            )
        }
    )
}

@Composable
private fun calculateSafeContentPadding(
    density: Density = LocalDensity.current,
    layoutDirection: LayoutDirection = LocalLayoutDirection.current,
    safeContent: WindowInsets = WindowInsets.safeContent,
    originalContentPadding: PaddingValues,
    userContentPadding: PaddingValues
) = WindowInsets(
    left = max(
        safeContent.getLeft(density, layoutDirection).dp,
        userContentPadding.calculateLeftPadding(layoutDirection)
    ),
    top = originalContentPadding.calculateTopPadding() + userContentPadding.calculateTopPadding(),
    right = max(
        safeContent.getRight(density, layoutDirection).dp,
        userContentPadding.calculateRightPadding(layoutDirection)
    ),
    bottom = max(
        safeContent.getBottom(density).dp,
        originalContentPadding.calculateBottomPadding() + userContentPadding.calculateBottomPadding()
    ),
).asPaddingValues()