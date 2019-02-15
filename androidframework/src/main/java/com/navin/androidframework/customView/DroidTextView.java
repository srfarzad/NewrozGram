package com.navin.androidframework.customView;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatTextView;

public class DroidTextView extends AppCompatTextView {

    public DroidTextView(Context context) {
        super(context);
        setFont(context);
    }

    public DroidTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont(context);
    }

    public DroidTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont(context);
    }

    private void setFont(Context context){
        Typeface typeface = Typeface.createFromAsset(context.getAssets(),"fonts/irsans.ttf");
        setTypeface(typeface);
    }
}
