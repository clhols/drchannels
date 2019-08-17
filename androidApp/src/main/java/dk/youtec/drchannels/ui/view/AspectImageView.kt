package dk.youtec.drchannels.ui.view

import android.content.Context
import android.util.AttributeSet
import com.facebook.drawee.view.SimpleDraweeView

class AspectImageView : SimpleDraweeView {

    private var measurer: ViewAspectRatioMeasurer? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    fun setAspectRatio(width: Int, height: Int) {
        val ratio = width.toDouble() / height
        if (measurer?.aspectRatio != ratio) {
            measurer = ViewAspectRatioMeasurer(ratio)
        }
    }

    fun setAspectRatio(ratio: Double) {
        if (measurer?.aspectRatio != ratio) {
            measurer = ViewAspectRatioMeasurer(ratio)
        }
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
      measurer?.run {
        measure(widthMeasureSpec, heightMeasureSpec)
        setMeasuredDimension(measuredWidth, measuredHeight)
      } ?: super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }
}
