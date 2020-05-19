package com.example.matan.matan;


import android.content.Intent;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import android.widget.ImageView;
import android.widget.TextView;

public class volume_button_page extends AppCompatActivity {

    TextView textView;
    ImageView img;
    int click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.volume_button_page);

        textView = (TextView) findViewById(R.id.textView2);
        img = (ImageView) findViewById(R.id.imageView_button);

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if ((keyCode == KeyEvent.KEYCODE_VOLUME_UP)){
            textView.setText("Prees Volume down button");
            img.setImageResource(R.drawable.volume_down_icon);
            click=1;
        }
        if(click ==1) {
            if ((keyCode == KeyEvent.KEYCODE_VOLUME_DOWN)) {
                setContentView(R.layout.volume_button_page_2);
            }
        }
        return true;


    }





    public void Move_mainactivity(View v)
    {
        super.onBackPressed();
    }
}
