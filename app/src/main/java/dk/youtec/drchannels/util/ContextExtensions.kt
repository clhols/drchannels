package dk.youtec.drchannels.util

import android.content.Context
import android.content.pm.PackageManager

fun Context.isTv(): Boolean = packageManager.hasSystemFeature(PackageManager.FEATURE_TELEVISION)
        || packageManager.hasSystemFeature(PackageManager.FEATURE_LEANBACK)