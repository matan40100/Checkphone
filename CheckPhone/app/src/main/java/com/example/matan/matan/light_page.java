package com.example.matan.matan;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class light_page extends AppCompatActivity implements SensorEventListener {
    //Declare//
    SensorManager mSensorManager;
    Sensor mLight;
    TextView textView;
    TextView notsupport;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_page);

        mSensorManager = (SensorManager)getSystemService(SENSOR_SERVICE);
        mLight= mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        textView = (TextView) findViewById(R.id.text_light);
        notsupport = (TextView)findViewById(R.id.errorText);


        if (mLight == null) {
            notsupport.setText("Your Device does not have a gyroscope sensor ");
            textView.setVisibility(View.INVISIBLE);
        }
    }
    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mLight, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }


    @Override
    public void onSensorChanged(SensorEvent event) {
        textView.setText("Light level:\n " + event.values[0]+" lux");
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
