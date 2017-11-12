package dk.youtec.zapr.util

import android.graphics.PorterDuff
import android.view.MenuItem

/**
 * Sets the color filter and/or the alpha transparency on a [MenuItem]'s icon.

 * @param menuItem
 * *     The [MenuItem] to theme.
 * *
 * @param color
 * *     The color to set for the color filter or `null` for no changes.
 * *
 * @param alpha
 * *     The alpha value (0...255) to set on the icon or `null` for no changes.
 */
fun colorMenuItem(menuItem: MenuItem, color: Int?, alpha: Int?) {
    if (color == null && alpha == null) {
        return  // nothing to do.
    }
    val drawable = menuItem.icon
    if (drawable != null) {
        // If we don't mutate the drawable, then all drawables with this id will have the ColorFilter
        drawable.mutate()
        if (color != null) {
            drawable.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
        }
        if (alpha != null) {
            drawable.alpha = alpha
        }
    }
}