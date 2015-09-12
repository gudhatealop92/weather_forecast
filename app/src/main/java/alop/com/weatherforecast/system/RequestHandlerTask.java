package alop.com.weatherforecast.system;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;

import alop.com.weatherforecast.R;
import alop.com.weatherforecast.adapters.WeatherListAdapter;
import alop.com.weatherforecast.valueobjects.CityWeatherCondition;
import alop.com.weatherforecast.valueobjects.ForecastDataListConstructor;
import alop.com.weatherforecast.valueobjects.WeatherData;

/**
 * Created by justbe on 10/9/15.
 */
public class RequestHandlerTask extends AsyncTask<String, Void, String> {
    private ListView lv;
    private Context context;
    private View view;

    public RequestHandlerTask(Context context, ListView lv, View view) {
        this.lv = lv;
        this.context = context;
        this.view = view;
    }


    @Override
    protected String doInBackground(String... urls) {
        String abc = urls[0];
        return getResponse(urls[0]);
    }

    // onPostExecute displays the results of the AsyncTask.
    @Override
    protected void onPostExecute(String result) {
        ObjectMapper objectMapper = new ObjectMapper();
        CityWeatherCondition cwc;
        ForecastDataListConstructor forecastDataListConstructor = new ForecastDataListConstructor();
        ArrayList<WeatherData> weatherDataList = null;
        try {
            cwc = objectMapper.readValue(result, CityWeatherCondition.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }

        if (cwc.getCity() == null) {
            TextView tv = (TextView) view.findViewById(R.id.emptyElement);
            lv.setAdapter(new WeatherListAdapter(context, weatherDataList));
            lv.setEmptyView(tv);
        } else {
            weatherDataList = forecastDataListConstructor.getDataList(cwc);
            lv.setAdapter(new WeatherListAdapter(context, weatherDataList));
        }
    }

    private static String getResponse(String url) {
        InputStream inputStream = null;
        String result = "";
        try {

            // create HttpClient
            HttpClient httpclient = new DefaultHttpClient();

            // make Get request to the given URL
            HttpResponse httpResponse = httpclient.execute(new HttpGet(url));

            // receive response as inputStream
            inputStream = httpResponse.getEntity().getContent();

            // convert inputstream to string
            if (inputStream != null)
                result = convertInputStreamToString(inputStream);

        } catch (Exception e) {
            Log.d("InputStream", e.getLocalizedMessage());
        }

        return result;
    }

    private static String convertInputStreamToString(InputStream inputStream) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String line = "";
        String result = "";
        while ((line = bufferedReader.readLine()) != null)
            result += line;
        inputStream.close();
        return result;

    }
}
