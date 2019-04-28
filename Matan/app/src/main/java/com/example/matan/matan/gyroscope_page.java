package com.example.matan.matan;



import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;


import java.util.ArrayList;

public class gyroscope_page extends AppCompatActivity implements SensorEventListener {
    //Declare//
    SensorManager mSensorManager;
    Sensor mGyroscope;
    TextView textView;
    TextView notsupport;
    int sum;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gyroscope_page);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mGyroscope= mSensorManager.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        textView = (TextView) findViewById(R.id.textView2);
        notsupport = (TextView)findViewById(R.id.errorText);

        if (mGyroscope == null) {
            notsupport.setText("Your Device does not have a gyroscope sensor ");
            textView.setVisibility(View.INVISIBLE);
        }


    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mGyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        textView.setText("Shake the phone for 3 seconds\n " + event.values[0]+"\n " + event.values[1]+"\n " + event.values[2]);
        Log.d("myTagg", Float.toString(event.values[0]));



       for(int i=0; i<50; i++)
        {
            if (event.values[0] != 0.00)
            {
               sum++;
                Log.d("myTag", ""+sum);
                if(sum>10)
                {

                    Intent p = new Intent(gyroscope_page.this, gyroscope_page_2.class);
                    startActivity(p);
                }
            }
            break;
        }

    }


    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // Do something here if sensor accuracy changes.
    }



    public void Move_mainactivity(View v)
    {
        super.onBackPressed();
    }
}
