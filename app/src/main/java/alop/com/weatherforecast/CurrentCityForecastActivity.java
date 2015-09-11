package alop.com.weatherforecast;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Alop Gudhate on 8/25/15.
 */

/*
* finds current city and current date
* sets current city weather forecast for 14 days
* */
public class CurrentCityForecastActivity extends Activity implements LocationListener {

    private ListView lv;
    protected LocationManager locationManager;
    protected boolean gps_enabled, network_enabled;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_city_forecast_activity);
        Location location;
        location = getCurrentLocation();
        final String query = Constants.QUERY_FIRST_PART + "lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&cnt=" + Constants.COUNT + "&units=" + Constants.UNIT + "&APPID=" + Constants.APP_ID;
        // call AsynTask to perform network operation on separate thread
        lv = (ListView) findViewById(R.id.lv);
        new RequestHandlerTask(CurrentCityForecastActivity.this, lv, null).execute(query);
        Button searchButton = (Button) findViewById(R.id.btnSearch);
        searchButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                TextView tv = (TextView) findViewById(R.id.txtEnterCity);
                if (tv.getText().length() == 0) {
                    Toast.makeText(CurrentCityForecastActivity.this, Constants.NO_CITIES_ERROR, Toast.LENGTH_LONG).show();
                } else {
                    String[] cities = tv.getText().toString().split(",");
                    Intent intent = new Intent(CurrentCityForecastActivity.this, MultipleCitiesForecastActivity.class);
                    intent.putExtra(Constants.CITIES, cities);
                    startActivity(intent);
                }
            }
        });
    }




    @Override
    public void onLocationChanged(Location location) {
    }

    @Override
    public void onProviderDisabled(String provider) {
        Log.d("Latitude", "disable");
    }

    @Override
    public void onProviderEnabled(String provider) {
        Log.d("Latitude", "enable");
    }

    @Override
    public void onStatusChanged(String provider, int status, Bundle extras) {
        Log.d("Latitude", "status");
    }

    public Location getCurrentLocation() {
        Location location;
        locationManager = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        locationManager.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, this);
        location = locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
        return location;
    }
}