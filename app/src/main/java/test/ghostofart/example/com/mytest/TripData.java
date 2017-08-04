package test.ghostofart.example.com.mytest;

/**
 * Created by ghostofart on 11/28/2016.
 */
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.TimeZone;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class TripData extends Activity implements View.OnClickListener
{
    EditText  emailAddr, driverName, vehNum, currDate, currTime, currMileage, tripPurpose, tripFrom, tripTo;

    Button sendMail;
    String strEmailAddr, strDriverName, strVehNum, strCurrDate, strCurrTime, strCurrMileage, strTripPurpose, strTripFrom, strTripTo;


    @Override  protected void onCreate(Bundle savedInstanceState)
    {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tripdata);
        intialize();
        SharedPreferences getPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        emailAddr.setText(getPref.getString("transOfficeEmail", "johnk1963@gmail.com"));
        strEmailAddr = emailAddr.getText().toString();
        driverName.setText(getPref.getString("driverName", "Ahenda John"));
        strDriverName = driverName.getText().toString();
        vehNum.setText(getPref.getString("vehicleNumber", "KXX 123 Y"));
        strVehNum = vehNum.getText().toString();
        Calendar cal = Calendar.getInstance(TimeZone.getDefault());
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss a", Locale.getDefault());
        SimpleDateFormat theDate = new SimpleDateFormat("EEE, MMM d, yyy", Locale.getDefault());
        currDate.setText(getPref.getString("tripDate", theDate.format(cal.getTime())));
        strCurrDate = currDate.getText().toString();
        currTime.setText(getPref.getString("startTime", sdf.format(cal.getTime())));
        strCurrTime = currTime.getText().toString();
        strCurrMileage=currMileage.getText().toString();
        strTripPurpose=tripPurpose.getText().toString();
        strTripFrom= tripFrom.getText().toString();
        strTripTo = tripTo.getText().toString();
        sendMail.setOnClickListener(this);
    }

    private void intialize()
    {
        // TODO Auto-generated method stub
        emailAddr = (EditText)findViewById(R.id.etTransEmailAddr);
        driverName = (EditText)findViewById(R.id.etDriverName);
        vehNum = (EditText)findViewById(R.id.etVehicleNumber);
        currDate = (EditText)findViewById(R.id.etTripDate);
        currTime = (EditText)findViewById(R.id.etStartTime);
        currMileage = (EditText)findViewById(R.id.etMileage);
        tripPurpose = (EditText)findViewById(R.id.etPurpose);
        tripFrom = (EditText)findViewById(R.id.etFrom);
        tripTo = (EditText)findViewById(R.id.etTo);
        sendMail = (Button)findViewById(R.id.bSendMail);
    }  //Get the inflated menu

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // TODO Auto-generated method stub
        super.onCreateOptionsMenu(menu);
        MenuInflater blowUp =getMenuInflater();
        blowUp.inflate(R.menu.prefmenu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // TODO Auto-generated method stub
        switch(item.getItemId())
        {
            case R.id.preference:Intent p = new Intent("test.ghostofart.example.com.mytest.PREFS");
                startActivity(p);
            case R.id.exit:
                finish();
        }
        return false;
    }

    @Override
    public void onClick(View v)
    {
        // TODO Auto-generated method stub
        setEmailText();
        String sendAddr[] = {strEmailAddr};
        String emailBody = "Hi Kennedy,\n"   +" I am on a trip with vehicle registration number " + strVehNum+"\n "  + "Its mileage currently read "+  strCurrMileage+"\n"        + "The trip is from "+ strTripFrom +" to "+strTripTo + '\n'  + "Departure date "+ strCurrDate + " at " + strCurrTime + '\n'         + "Trip purporse: " + strTripPurpose+ '\n'         +" Yours faithfully,\n"         + strDriverName;
        Intent emailIntent = new Intent(android.content.Intent.ACTION_SEND);
        emailIntent.putExtra(android.content.Intent.EXTRA_EMAIL, sendAddr);
        emailIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "My Trial Email");
        emailIntent.setType("plain/text");
        emailIntent.putExtra(android.content.Intent.EXTRA_TEXT, emailBody);
        startActivity(emailIntent);
    }

    private void setEmailText()
    {
        // TODO Auto-generated method stub
        strEmailAddr = emailAddr.getText().toString();
        strDriverName = driverName.getText().toString();
        strVehNum = vehNum.getText().toString();
        strCurrDate= currDate.getText().toString();
        strCurrTime= currTime.getText().toString();
        strCurrMileage= currMileage.getText().toString();
        strTripPurpose= tripPurpose.getText().toString();
        strTripFrom= tripFrom.getText().toString();
        strTripTo= tripTo.getText().toString();
    }
}
