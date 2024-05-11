@file:Suppress("unused")

package io.github.u1tramarinet.androidcomposeutility.foundation

import androidx.compose.ui.unit.Dp

fun max(a: Dp, b: Dp) = if (a.value >= b.value) a else b

fun min(a: Dp, b: Dp) = if (a.value >= b.value) b else a