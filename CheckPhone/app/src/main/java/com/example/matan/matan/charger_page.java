package com.example.matan.matan;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class charger_page extends AppCompatActivity {

    MediaPlayer mp;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_charger_page);

        textView = (TextView) findViewById(R.id.status_charger);
        mp = MediaPlayer.create(this, R.raw.sound_charger);

        //Summon action//
        onCreate();

    }

    //What happen when receive electric//
    public void onCreate() {
        BroadcastReceiver receiver = new BroadcastReceiver() {
            public void onReceive(Context context, Intent intent) {
                int plugged = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
                if (plugged == BatteryManager.BATTERY_PLUGGED_AC | plugged == BatteryManager.BATTERY_PLUGGED_USB) {
                    textView.setText("Charge");
                    textView.setTextColor(Color.parseColor("#00ba03"));
                    mp.start();

                }
                else {
                    textView.setText("Not charge");
                    textView.setTextColor(Color.parseColor(	"#ff111d"));
                }
            }
        };
        IntentFilter filter = new IntentFilter(Intent.ACTION_BATTERY_CHANGED);
        registerReceiver(receiver, filter);
    }

    public void Move_mainactivity(View v)
    {
        mp.stop();
        super.onBackPressed();
    }
}
