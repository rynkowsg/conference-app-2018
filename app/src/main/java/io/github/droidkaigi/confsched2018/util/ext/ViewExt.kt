package io.github.droidkaigi.confsched2018.util.ext

import android.os.Build
import android.view.View

fun View.setVisible(visible: Boolean) {
    if (visible) {
        toVisible()
    } else {
        toGone()
    }
}

fun View.toVisible() {
    visibility = View.VISIBLE
}

fun View.toGone() {
    visibility = View.GONE
}

fun View.isGone() = visibility == View.GONE

fun View.isVisible() = visibility == View.VISIBLE

var View.elevationForPostLollipop: Float
    get() = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
        elevation
    } else {
        0F
    }
    set(value) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            elevation = value
        }
    }

fun View.setPaddingWithLayoutDirction(start: Int, top: Int, end: Int, bottom: Int) =
        if (resources.configuration.layoutDirection == View.LAYOUT_DIRECTION_RTL) {
            setPadding(end, top, start, bottom)
        } else {
            setPadding(start, top, end, bottom)
        }
