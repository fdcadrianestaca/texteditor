package com.example.myapplication.toolitems;

import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.Util;
import com.chinalwb.are.colorpicker.ColorPickerListener;
import com.chinalwb.are.spans.AreForegroundColorSpan;
import com.chinalwb.are.styles.ARE_ABS_Dynamic_Style;
import com.chinalwb.are.styles.toolitems.styles.ARE_Style_FontColor;
import com.chinalwb.are.styles.windows.ColorPickerWindow;
import com.example.myapplication.R;

public class ARE_Style_MyFontColor extends ARE_ABS_Dynamic_Style<AreForegroundColorSpan> implements ColorPickerListener {
    private ImageView mFontColorImageView;
    private AREditText mEditText;
    private int mColor;
    private boolean mIsChecked;
    private int mDefaultColor;
    private int mTextColor;

    public ARE_Style_MyFontColor(AREditText editText, ImageView fontSizeImage, int defaultColor, int textColor) {
        super(editText.getContext());
        this.mEditText = editText;
        this.mFontColorImageView = fontSizeImage;
        this.setListenerForImageView(this.mFontColorImageView);
        this.mTextColor = textColor;
        this.mDefaultColor = defaultColor;
    }

    public void setEditText(AREditText editText) {
        this.mEditText = editText;
    }

    public EditText getEditText() {
        return this.mEditText;
    }

    public void setListenerForImageView(ImageView imageView) {
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                onPickColor(ARE_Style_MyFontColor.this.mTextColor);
            }
        });
    }

    public AreForegroundColorSpan newSpan() {
        return new AreForegroundColorSpan(this.mColor);
    }

    public ImageView getImageView() {
        return this.mFontColorImageView;
    }

    public void setChecked(boolean isChecked) {
        onPickColor(mTextColor);
    }

    public boolean getIsChecked() {
        return this.mIsChecked;
    }

    protected void featureChangedHook(int lastSpanFontColor) {
        this.mColor = lastSpanFontColor;
        this.setColorChecked(lastSpanFontColor);
    }

    public void setColorChecked(int color) {
//        onPickColor(color);
    }

    protected AreForegroundColorSpan newSpan(int color) {
        return new AreForegroundColorSpan(color);
    }

    public void onPickColor(int color) {
        this.mIsChecked = true;
        this.mColor = color;
        if (null != this.mEditText) {
            Editable editable = this.mEditText.getEditableText();
            int start = this.mEditText.getSelectionStart();
            int end = this.mEditText.getSelectionEnd();
            if (end >= start) {
                this.applyNewStyle(editable, start, end, color);
            }
        }

    }
}
