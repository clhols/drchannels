package dk.youtec.drchannels.util

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions
import com.bumptech.glide.request.RequestOptions
import dk.youtec.drchannels.R

typealias GlideOptions = RequestOptions.() -> RequestOptions

private val crossFade = DrawableTransitionOptions().crossFade(400)

fun ImageView.load(url: String,
                   options: GlideOptions = { this }) {
    Glide.with(context)
            .load(url)
            .transition(crossFade)
            .apply(RequestOptions()
                    .options()
                    .placeholder(R.drawable.image_placeholder)
                    .diskCacheStrategy(DiskCacheStrategy.ALL))
            .into(this)
}