package dk.youtec.drchannels.ui.view

import android.content.Context
import android.support.v7.widget.AppCompatTextView
import android.util.AttributeSet

open class AutoMaxLinesTextView : AppCompatTextView {
    protected var limitedMaxLines = Integer.MAX_VALUE

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        val mode = MeasureSpec.getMode(heightMeasureSpec)

        if (mode == MeasureSpec.EXACTLY || mode == MeasureSpec.AT_MOST) {
            val height = MeasureSpec.getSize(heightMeasureSpec)
            val heightWithoutPadding = height - (paddingBottom + paddingTop)
            val lineHeight = lineHeight
            val newMaxLines = heightWithoutPadding / lineHeight

            if (limitedMaxLines != newMaxLines) {
                maxLines = newMaxLines
            }
        }

        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
    }

    override fun onLayout(changed: Boolean, left: Int, top: Int, right: Int, bottom: Int) {
        super.onLayout(changed, left, top, right, bottom)

        //In case that the layout height is different from the measured height, we adjust max lines again.
        val heightWithoutPadding = height - (paddingBottom + paddingTop)
        val lineHeight = lineHeight
        val newMaxLines = heightWithoutPadding / lineHeight

        if (limitedMaxLines != newMaxLines) {
            maxLines = newMaxLines
        }
    }

    override fun setMaxLines(maxLines: Int) {
        super.setMaxLines(maxLines)
        limitedMaxLines = maxLines
    }
}