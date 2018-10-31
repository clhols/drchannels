package dk.youtec.drchannels.util

import android.widget.ImageView
import com.squareup.picasso.Picasso
import dk.youtec.drchannels.R

fun ImageView.load(url: String) {
    Picasso.get()
            .load(url)
            .placeholder(R.drawable.image_placeholder)
            .into(this)
}