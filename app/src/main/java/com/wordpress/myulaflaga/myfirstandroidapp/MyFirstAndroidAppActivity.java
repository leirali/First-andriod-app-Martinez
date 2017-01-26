package com.wordpress.myulaflaga.myfirstandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.media.MediaPlayer;
import android.net.Uri;
import android.location.Location;
import android.location.LocationManager;
import android.util.Log;


public class MyFirstAndroidAppActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_first_android_app);
    }

    public void forceError() {
        if(true) {
            throw new Error("Whoops");
        }
    }

    private MediaPlayer mp;
    public void playMusicFromWeb() {
        try {
            Uri file = Uri.parse("http://www.perlgurl.org/podcast/archives"
            + "/podcasts/PerlgurlPromo.mp3");
            mp = MediaPlayer.create(this, file);
            mp.start();
        } catch (Exception e) {
            //Log.e(DEBUG_TAG, "Player Failed", e);
        }
    }

    protected void onStop() {
        if (mp != null) {
            mp.stop();
            mp.release();
        } super.onStop();
    }

    public void getLocation() {
        try {
            LocationManager locMgr = (LocationManager)
                    this.getSystemService(LOCATION_SERVICE);
            Location recentLoc = locMgr.getLastKnownLocation(LocationManager.GPS_PROVIDER);
            Log.i(DEBUG_TAG, "loc: " + recentLoc.toString());
        } catch (Exception e) {
            Log.e(DEBUG_TAG, "location failed", e);
        }
    }
}
