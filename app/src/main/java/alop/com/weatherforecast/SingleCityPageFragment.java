package alop.com.weatherforecast;

import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by justbe on 4/9/15.
 */
public class SingleCityPageFragment extends android.support.v4.app.Fragment {

    private String cityName;
    private ListView lv;
    String strDate;
    Calendar cal = Calendar.getInstance();

    public static SingleCityPageFragment newInstance(String city) {
        SingleCityPageFragment fragment = new SingleCityPageFragment();
        fragment.setCityName(city);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_multiple_city_wf, container, false);
        final String query = Constants.QUERY_FIRST_PART + "q=" + getCityName().replaceAll(" ", "%20") + "&cnt=" + Constants.COUNT + "&units=" + Constants.UNIT + "&APPID=" + Constants.APP_ID;
        // call AsynTask to perform network operation on separate thread
        lv = (ListView) view.findViewById(R.id.lvMultipleCities);
        new RequestHandlerTask(getActivity(), lv, view).execute(query);
        return view;

    }
}
