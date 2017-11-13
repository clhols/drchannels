package dk.youtec.drchannels.ui.view

import android.content.Context
import android.support.v7.widget.AppCompatImageView
import android.util.AttributeSet

class AspectImageView : AppCompatImageView {

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
        if (measurer != null) {
            measurer!!.measure(widthMeasureSpec, heightMeasureSpec)
            setMeasuredDimension(measurer!!.measuredWidth, measurer!!.measuredHeight)
        } else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        }
    }
}
