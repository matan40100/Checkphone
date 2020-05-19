package com.example.matan.matan;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;


public class MainActivity extends AppCompatActivity {
    //Declare//
    Toolbar toolbar;
    TextView company;
    TextView model;
    TextView sdk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String manu= android.os.Build.MANUFACTURER;
        company = (TextView) findViewById(R.id.brandname);
        company.setText(manu.substring(0,1).toUpperCase() + manu.substring(1));

        model = (TextView) findViewById(R.id.devicemodel);
        model.setText(android.os.Build.MODEL);

        sdk = (TextView) findViewById(R.id.sdkname);
        sdk.setText(android.os.Build.VERSION.RELEASE +" , API " + android.os.Build.VERSION.SDK  );
    }



    //Switch between activites//

    public void Move_light (View v)
    {
        Intent i = new Intent(MainActivity.this, light_page.class);
        startActivity(i);
    }

    public void Move_vibration (View v)
    {
        Intent i = new Intent(MainActivity.this, vibration_page.class);
        startActivity(i);
    }

    public void Move_charger(View v)
    {
        Intent i = new Intent(MainActivity.this, charger_page.class);
        startActivity(i);
    }

    public void Move_flashlight(View v)
    {
        Intent i = new Intent(MainActivity.this, flashlight_page.class);
        startActivity(i);
    }

    public void Move_speaker(View v)
    {
        Intent i = new Intent(MainActivity.this, speaker_page.class);
        startActivity(i);
    }

    public void Move_fingerprint(View v)
    {
        Intent i = new Intent(MainActivity.this, fingerprint_page.class);
        startActivity(i);
    }

    public void Move_volume_button(View v)
    {
        Intent i = new Intent(MainActivity.this, volume_button_page.class);
        startActivity(i);
    }

    public void Move_proximity(View v)
    {
        Intent i = new Intent(MainActivity.this, proximity_page.class);
        startActivity(i);
    }

    public void Move_gyroscope(View v)
    {
        Intent i = new Intent(MainActivity.this, gyroscope_page.class);
        startActivity(i);
    }

    public void Move_html(View v)
    {
        Intent i = new Intent(MainActivity.this, webview.class);
        startActivity(i);
    }


}
