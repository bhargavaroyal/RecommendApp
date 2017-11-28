package com.droid.tv.recommendapp;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by hp on 28-11-2017.
 */

public class DualTextHeader extends LinearLayout {
    LinearLayout layout = null;
    TextView titleTextView = null;
    TextView subTitleTextView = null;
    Context mContext = null;


    public DualTextHeader(Context context) {
        this(context, null);
        mContext = context;
    }

    public DualTextHeader(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext =context;
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.DoubleHeaderText);

        String titleText = typedArray.getString(R.styleable.DoubleHeaderText_titleText);
        String subTitleText = typedArray.getString(R.styleable.DoubleHeaderText_subTitleText);

        titleText = titleText == null ? "" : titleText;
        subTitleText = subTitleText == null ? "" : subTitleText;

        String service = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(service);

        layout = (LinearLayout) li.inflate(R.layout.dual_text_header, this, true);

        titleTextView = (TextView) layout.findViewById(R.id.title_text);
        subTitleTextView = (TextView) layout.findViewById(R.id.sub_title_text);

        titleTextView.setText(titleText);
        subTitleTextView.setText(subTitleText);

        typedArray.recycle();
    }

    public DualTextHeader(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void setTitleText(String text) {
        titleTextView.setText(text);
    }

    public void setSubTitleText(String text) {
        subTitleTextView.setText(text);
    }

}
