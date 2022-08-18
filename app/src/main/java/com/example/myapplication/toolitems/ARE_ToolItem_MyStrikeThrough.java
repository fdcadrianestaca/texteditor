package com.example.myapplication.toolitems;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.chinalwb.are.Util;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Bold;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Strikethrough;
import com.example.myapplication.R;

public class ARE_ToolItem_MyStrikeThrough extends ARE_ToolItem_Strikethrough {

    @Override
    public View getView(Context context) {
        if (null == context) {
            return mToolItemView;
        }
        if (mToolItemView == null) {
            ImageView imageView = new ImageView(context);
            int size = Util.getPixelByDp(context, 40);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(size, size);
            imageView.setLayoutParams(params);
            imageView.setImageResource(R.drawable.my_bold);
            imageView.bringToFront();
            mToolItemView = imageView;
        }

        return mToolItemView;
    }
}