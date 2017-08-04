package test.ghostofart.example.com.mytest;

/**
 * Created by ghostofart on 11/28/2016.
 */
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceActivity; //import android.preference.PreferenceFragment;

public class Pref extends PreferenceActivity
{
    @SuppressWarnings("deprecation")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        if(Build.VERSION.SDK_INT <Build.VERSION_CODES.HONEYCOMB)
        {
            addPreferencesFromResource(R.xml.pref);
        }
        else
        {
            getFragmentManager().beginTransaction().replace(android.R.id.content, new Pref2()).commit();
        }
    }
}

