package dk.youtec.drchannels.util

import android.widget.ImageView
import com.squareup.picasso.Picasso
import com.squareup.picasso.RequestCreator
import dk.youtec.drchannels.R

fun ImageView.load(
        url: String,
        options: RequestCreator.() -> RequestCreator = { this }
) {
    Picasso.get()
            .load(url)
            .options()
            .placeholder(R.drawable.image_placeholder)
            .into(this)
}