package com.example.matan.matan;



import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class flashlight_page extends AppCompatActivity {
    Button turn_on_off;
    CameraManager mCameraManager;
    Boolean isLightOn = false;
    String mCameraId;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flashlight_page);

        //Declare the camera manager and get the back facing camera.//
        mCameraManager = (CameraManager) getSystemService(Context.CAMERA_SERVICE);
        try {
            mCameraId = mCameraManager.getCameraIdList()[0];
        } catch (CameraAccessException e) {
            e.printStackTrace();
        }


        turn_on_off = (Button) findViewById(R.id.button_flashlight);


        turn_on_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isLightOn){
                    //Turn OFF flashlight
                    isLightOn = false;
                    turnOffLight();
                    turn_on_off.setText("Turn ON");
                }else{
                    //Turn ON flashlight
                    isLightOn = true;
                    turnOnLight();
                    turn_on_off.setText("Turn OFF");
                }
            }
        });
    }

    //Turn on flashlight
    public void turnOnLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //Turn off flashlight method
    public void turnOffLight() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                mCameraManager.setTorchMode(mCameraId, false);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Move_mainactivity(View v)
    {
        super.onBackPressed();
    }

}
