package alop.com.weatherforecast.activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import alop.com.weatherforecast.R;
import alop.com.weatherforecast.system.Constants;
import alop.com.weatherforecast.system.RequestHandlerTask;
import alop.com.weatherforecast.valueobjects.QueryConstructor;

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
    private QueryConstructor queryConstructor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.current_city_forecast_activity);
        Location location;
        location = getCurrentLocation();
        String query = Constants.QUERY_FIRST_PART + "lat=" + location.getLatitude() + "&lon=" + location.getLongitude() + "&cnt=" + Constants.COUNT + "&units=" + Constants.UNIT + "&APPID=" + Constants.APP_ID;
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