package io.github.u1tramarinet.androidcomposeutility.ui

import android.content.res.Configuration
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration

@Suppress("unused")
enum class Orientation(val value: Int) {
    PORTRAIT(value = Configuration.ORIENTATION_PORTRAIT),
    LANDSCAPE(value = Configuration.ORIENTATION_LANDSCAPE),
    ;

    fun toggle() = if (this == PORTRAIT) LANDSCAPE else PORTRAIT

    companion object {
        @Suppress("MemberVisibilityCanBePrivate")
        fun defaultValue() = PORTRAIT
        fun from(value: Int): Orientation {
            return try {
                Orientation.entries.first {
                    it.value == value
                }
            } catch (_: NoSuchElementException) {
                defaultValue()
            }
        }
    }
}

@Suppress("unused")
@Composable
fun getOrientation(): Orientation {
    val configuration = LocalConfiguration.current
    return Orientation.from(configuration.orientation)
}