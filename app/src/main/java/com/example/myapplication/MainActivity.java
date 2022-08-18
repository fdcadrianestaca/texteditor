package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.chinalwb.are.AREditText;
import com.chinalwb.are.styles.toolbar.IARE_Toolbar;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_FontColor;
import com.chinalwb.are.styles.toolitems.ARE_ToolItem_Strikethrough;
import com.chinalwb.are.styles.toolitems.IARE_ToolItem;
import com.example.myapplication.toolitems.ARE_ToolItem_MyBold;
import com.example.myapplication.toolitems.ARE_ToolItem_MyFontColor;


public class MainActivity extends AppCompatActivity {

    private IARE_Toolbar mToolbar;

    private AREditText mEditText;

    private WriteCustomButton mbold;
    private WriteCustomButton mstrike;
//    private CustomTextStyleEditTextView edittext;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mbold = findViewById(R.id.chat_button_bold);
        mstrike = findViewById(R.id.chat_button_strike);
//        edittext = findViewById(R.id.chat_editText_message);

//        DecorationButtonListener decorationButtonListener = new DecorationButtonListener();
//        mbold.setOnClickListener(decorationButtonListener);
//        mstrike.setOnClickListener(decorationButtonListener);   -8825528

        initToolbar();
    }

    private void initToolbar() {
        mToolbar = this.findViewById(R.id.areToolbar);
        IARE_ToolItem bold = new ARE_ToolItem_MyBold();
        IARE_ToolItem strikethrough = new ARE_ToolItem_Strikethrough();
        IARE_ToolItem blackColor = new ARE_ToolItem_MyFontColor(R.color.black,-16777216);
        IARE_ToolItem blueColor = new ARE_ToolItem_MyFontColor(R.color.black,-14575885);
        IARE_ToolItem redColor = new ARE_ToolItem_MyFontColor(R.color.black,-769226);

//        IARE_ToolItem fontColor = new ARE_ToolItem_FontColor();

        mToolbar.addToolbarItem(bold);
        mToolbar.addToolbarItem(strikethrough);
        mToolbar.addToolbarItem(blackColor);
        mToolbar.addToolbarItem(blueColor);
        mToolbar.addToolbarItem(redColor);
//        mToolbar.addToolbarItem(fontColor);

        mEditText = this.findViewById(R.id.arEditText);
        mEditText.setToolbar(mToolbar);
    }

    class DecorationButtonListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if (view instanceof WriteCustomButton) {
                WriteCustomButton button = (WriteCustomButton) view;


                if (button.getId() == R.id.chat_button_bold) {
                    button.switchCheckedState();
//                    edittext.setTextStyle(CustomTextStyleEditTextView.STYLE_BOLD);

                } else if (button.getId() == R.id.chat_button_strike) {
                    button.switchCheckedState();
//                    edittext.setTextStyle(CustomTextStyleEditTextView.STYLE_STRIKETHROUGH);

                }
//                else if (button.getId() ==R.id.btn0) {
//                    edittext.setTextStyle(CustomTextStyleEditTextView.STYLE_COLOR_BLACK);
//
//                    setFocus(btn_unfocus, btn[0]);
//                }
//
////
//                else if (button.getId() ==R.id.btn1){
//                    mMessageEditText.setTextStyle(CustomTextStyleEditTextView.STYLE_COLOR_BLUE);
//
//                    setFocus(btn_unfocus, btn[1]);
//
//                } else if (button.getId() == R.id.btn2){
//                    mMessageEditText.setTextStyle(CustomTextStyleEditTextView.STYLE_COLOR_RED);
//                    String getString = mMessageEditText.getText().toString();
//                    checkStyle();
//
//                    setFocus(btn_unfocus, btn[2]);
//                }
////                if (button.getCheckedState()) {
////                    if (button.getId() == R.id.chat_button_bold) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_darker_gray));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_bold_selected));
////                    }
////                    if (button.getId() == R.id.chat_button_strike) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_darker_gray));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_strike_selected));
////                    }
////                } else if (!button.getCheckedState() && firstClick) {
////                    if (button.getId() == R.id.chat_button_bold) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_white));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_bold));
////                    }
////                    if (button.getId() == R.id.chat_button_strike) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_white));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_strike));
////                    }
////                    firstClick = false;
////                } else {
////                    if (button.getId() == R.id.chat_button_bold) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_white));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_bold));
////                    }
////                    if (button.getId() == R.id.chat_button_strike) {
////                        button.setBackgroundColor(ContextCompat.getColor(getApplicationContext(), R.color.common_white));
////                        button.setImageDrawable(getResources().getDrawable(R.drawable.ic_strike));
////                    }
////                }
            }
        }
    }
}