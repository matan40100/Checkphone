package com.example.matan.matan;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class fingerprint_page_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fingerprint_page_2);
    }



    public void Move_mainactivity(View v)
    {
        Intent i = new Intent(fingerprint_page_2.this, MainActivity.class);
        startActivity(i);
    }
}
