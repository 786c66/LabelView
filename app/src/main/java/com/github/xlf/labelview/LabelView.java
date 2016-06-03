package com.github.xlf.labelview;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.widget.TextView;

/**
 * Created by xlf on 2016/6/3.
 */
public class LabelView extends TextView {

    private GradientDrawable drawable;
    @ColorInt
    private int b_color;
    private int b_width;        //px
    private float b_radius;     //px

    public LabelView(Context context) {
        super(context);
        init();
    }

    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();

    }

    @TargetApi(14)
    private void init() {
        drawable = new GradientDrawable();
        b_color = Color.BLACK;
        b_width = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,1,getResources().getDisplayMetrics());
        b_radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,5,getResources().getDisplayMetrics());

        drawable.setCornerRadius(b_radius);
        drawable.setStroke(b_width,b_color);

        setBackgroundDrawable(drawable);
    }

    @TargetApi(14)
    public void setBorderColor(@ColorInt int c){
        b_color = c;
        drawable.setStroke(b_width,b_color);

        setBackgroundDrawable(drawable);
    }

    @TargetApi(14)
    public void setBorderWidth(int w){// dp
        b_width = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,w,getResources().getDisplayMetrics());
        drawable.setStroke(b_width,b_color);

        setBackgroundDrawable(drawable);
    }

    @TargetApi(14)
    public void setBorderRadius(int r){// dp
        b_radius = TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP,r,getResources().getDisplayMetrics());
        drawable.setCornerRadius(b_radius);

        setBackgroundDrawable(drawable);
    }
}
