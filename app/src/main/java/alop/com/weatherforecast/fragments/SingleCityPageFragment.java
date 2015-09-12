package alop.com.weatherforecast.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.Calendar;

import alop.com.weatherforecast.QueryConstructor;
import alop.com.weatherforecast.R;
import alop.com.weatherforecast.system.Constants;
import alop.com.weatherforecast.system.RequestHandlerTask;

/**
 * Created by justbe on 4/9/15.
 */
public class SingleCityPageFragment extends android.support.v4.app.Fragment {

    private String cityName;
    private ListView lv;
    private QueryConstructor queryConstructor;

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
        final String query = queryConstructor.getQuery(cityName);
        // call AsynTask to perform network operation on separate thread
        lv = (ListView) view.findViewById(R.id.lvMultipleCities);
        new RequestHandlerTask(getActivity(), lv, view).execute(query);
        return view;

    }
}
