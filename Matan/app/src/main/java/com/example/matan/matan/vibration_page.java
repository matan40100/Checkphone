package com.example.matan.matan;


import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;


public class vibration_page extends AppCompatActivity {
    //Declare//
    Button button_start;
    Vibrator vibrator;

    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vibration_page);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        textView = (TextView) findViewById(R.id.errorText);
        if(vibrator.hasVibrator() == false){
            textView.setText("Your Device does not have a vibration");
        }

        button_start = (Button)findViewById(R.id.button_vibrtion);
        button_start.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                int action = event.getActionMasked();

                if (action == MotionEvent.ACTION_DOWN) {
                    long[] pattern = { 0, 200, 0 }; //0 to start now, 200 to vibrate 200 ms, 0 to sleep for 0 ms.
                    vibrator.vibrate(pattern, 0); // 0 to repeat endlessly.
                } else if (action == MotionEvent.ACTION_UP || action == MotionEvent.ACTION_CANCEL) {
                    vibrator.cancel();
                }

                return true;
            }
        });
    }




    public void Move_mainactivity(View v)
    {
        super.onBackPressed();
    }



}
