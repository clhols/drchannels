package dk.youtec.drchannels.util

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics

fun FirebaseAnalytics.logItemEvent(id: String, name: String, contentType: String) {
    logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, Bundle().apply {
        putString(FirebaseAnalytics.Param.ITEM_ID, id)
        putString(FirebaseAnalytics.Param.ITEM_NAME, name)
        putString(FirebaseAnalytics.Param.CONTENT_TYPE, contentType)
    })
}