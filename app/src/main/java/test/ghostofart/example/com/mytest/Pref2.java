package test.ghostofart.example.com.mytest;

/**
 * Created by ghostofart on 11/28/2016.
 */
import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceFragment;

public class Pref2 extends PreferenceFragment
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {   // TODO Auto-generated method stub   super.onCreate(savedInstanceState);   addPreferencesFromResource(R.xml.prefs);  }

    }
}
