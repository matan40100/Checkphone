package com.example.matan.matan;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class speaker_page extends AppCompatActivity {
    //Declare//
    MediaPlayer mp;
    Button button_start;
    Button button_cancel;
    ImageButton imageButton_check;
    ImageButton imageButton_cancel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speaker_page);



        //Create mediaplayer//
        mp = MediaPlayer.create(this, R.raw.sample);


        button_start = (Button) findViewById(R.id.button_speaker);
        button_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(mp.isPlaying()== false){
                    mp.start();
                    button_start.setText("Pause");
                }
                else {
                    mp.pause();
                    button_start.setText("Start");
                }
            }
        });

        button_cancel = (Button) findViewById(R.id.button_cancel);
        button_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                speaker_page.super.onBackPressed();
            }
        });




    }




}
