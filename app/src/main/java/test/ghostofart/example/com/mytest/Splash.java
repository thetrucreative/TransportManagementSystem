package test.ghostofart.example.com.mytest;

/**
 * Created by ghostofart on 11/28/2016.
 */
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.preference.PreferenceManager;

public class Splash extends Activity
{
    MediaPlayer mySong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

        mySong = MediaPlayer.create(Splash.this, R.raw.lose);      //Using set Preference on Checkbox to decide on whether to play the song
        SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        boolean music = getPref.getBoolean("playMusic", true);

        if (music)
            mySong.start();
        Thread timer = new Thread() {

            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    Intent i = new Intent("test.ghostofart.example.com.mytest.TRIPDATA");
                    startActivity(i);
                }
            }
        };
        timer.start();
    }


        @Override
        protected void onPause()
        {
            // TODO Auto-generated method stub
            super.onPause();
            finish();   //mySong.release();   } }
        }
}

