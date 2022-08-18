package com.example.myapplication.toolitems;

import android.content.Context;
import android.text.Editable;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.Util;
import com.chinalwb.are.spans.AreForegroundColorSpan;
import com.chinalwb.are.styles.IARE_Style;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Abstract;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_FontColor;
import com.chinalwb.are.styles.toolitems.IARE_ToolItem_Updater;
import com.chinalwb.are.styles.toolitems.styles.ARE_Style_FontColor;
import com.example.myapplication.R;

public class ARE_ToolItem_MyFontColor extends ARE_ToolItem_Abstract {

    private int mDefaultColor;
    private int mTextColor;
    private boolean mState = false;

    public ARE_ToolItem_MyFontColor(int defaultColor, int color) {
        this.mDefaultColor = defaultColor;
        this.mTextColor = color;
    }

    public IARE_Style getStyle() {
        if (this.mStyle == null) {
            AREditText editText = this.getEditText();
            this.mStyle= new ARE_Style_MyFontColor(editText, (ImageView)this.mToolItemView,this.mDefaultColor,this.mTextColor);
        }

        return this.mStyle;
    }

    public View getView(Context context) {
        if (null == context) {
            return this.mToolItemView;
        } else {
            if (this.mToolItemView == null) {
                ImageView imageView = new ImageView(context);
                int size = Util.getPixelByDp(context, 35);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
                imageView.setBackgroundColor(mTextColor);
                imageView.setLayoutParams(params);
                imageView.bringToFront();
                this.mToolItemView = imageView;
            }

            return this.mToolItemView;
        }
    }

    public void onSelectionChanged(int selStart, int selEnd) {
        int spanColor = -1;
        AREditText editText = this.getEditText();
        Editable editable = editText.getEditableText();
        AreForegroundColorSpan[] styleSpans;
        if (selStart > 0 && selStart == selEnd) {
            styleSpans = (AreForegroundColorSpan[])editable.getSpans(selStart - 1, selStart, AreForegroundColorSpan.class);
            if (styleSpans.length > 0) {
                spanColor = styleSpans[styleSpans.length - 1].getForegroundColor();
            }

            ((ARE_Style_MyFontColor)this.mStyle).setColorChecked(spanColor);
        } else {
            styleSpans = (AreForegroundColorSpan[])editable.getSpans(selStart, selEnd, AreForegroundColorSpan.class);
            boolean multipleColor = false;

            for(int i = 0; i < styleSpans.length; ++i) {
                int thisSpanColor = styleSpans[i].getForegroundColor();
                if (spanColor == -1) {
                    spanColor = thisSpanColor;
                } else if (spanColor != thisSpanColor) {
                    multipleColor = true;
                    break;
                }
            }

            if (!multipleColor) {
                ((ARE_Style_FontColor)this.mStyle).setColorChecked(spanColor);
                return;
            }
        }

    }

    public IARE_ToolItem_Updater getToolItemUpdater() {
        return null;
    }
}
