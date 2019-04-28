package com.example.matan.matan;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;


public class proximity_page extends AppCompatActivity implements SensorEventListener {
    //Declare//
    SensorManager mSensorManager;
    Sensor mProximity;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_proximity_page);


        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mProximity = mSensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);

        textView =(TextView) findViewById(R.id.textView2);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mProximity, mSensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
    if(event.sensor.getType() == Sensor.TYPE_PROXIMITY){
        if(event.values[0] ==0.0){

               textView.setText("Excellent, proximity sensor work");
        }
    }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    public void Move_mainactivity(View v)
    {
        super.onBackPressed();
    }
}

