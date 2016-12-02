package ac.kotlintest.view.fragments

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.widget.TextView

class TextViewOpenSans:TextView {

    constructor(context: Context) : super(context) {
        this.typeface = Typeface.createFromAsset(context.assets, "font/open-sans.regular.ttf")
    }

    constructor(context:Context, attrs: AttributeSet) : super(context, attrs) {
        this.typeface = Typeface.createFromAsset(context.assets, "font/open-sans.regular.ttf")
    }
}