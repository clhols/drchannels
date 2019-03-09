package dk.youtec.drchannels.util

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.PorterDuff
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat

fun ViewGroup.inflate(@LayoutRes layoutRes: Int, attachToRoot: Boolean = false): View =
        LayoutInflater.from(context).inflate(layoutRes, this, attachToRoot)

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
    // If we don't mutate the drawable, then all drawables with this id will have the ColorFilter
    drawable?.mutate()
    if (color != null) {
        drawable?.setColorFilter(color, PorterDuff.Mode.SRC_ATOP)
    }
    if (alpha != null) {
        drawable?.alpha = alpha
    }
}

fun getBitmapFromVectorDrawable(context: Context, drawableId: Int): Bitmap {
    var drawable = ContextCompat.getDrawable(context, drawableId)!!
    drawable = DrawableCompat.wrap(drawable).mutate()

    val bitmap = Bitmap.createBitmap(
            drawable.intrinsicWidth,
            drawable.intrinsicHeight,
            Bitmap.Config.ARGB_8888)

    with(Canvas(bitmap)) {
        drawable.setBounds(0, 0, width, height)
        drawable.draw(this)
    }

    return bitmap
}