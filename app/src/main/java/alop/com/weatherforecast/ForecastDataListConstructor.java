package alop.com.weatherforecast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by justbe on 10/9/15.
 */
/*
* Consructing data list to set to the forecast list
* */
public class ForecastDataListConstructor {

    public ArrayList<WeatherData> getDataList(CityWeatherCondition cwc) {
        ArrayList<WeatherData> weatherDataList = new ArrayList<>();
        Calendar cal = Calendar.getInstance();
        String strDate;
        Date d = new Date();
        SimpleDateFormat form = new SimpleDateFormat(Constants.DATE_FORMAT);
        System.out.println(form.format(d));
        strDate = form.format(d);
        if(cwc.getCity().getName()!=null){
            for (int i = 0; i < 14; i++) {
                WeatherData wd = new WeatherData();
                wd.setCity(cwc.getCity().getName());
                wd.setCountry(cwc.getCity().getCountry());
                wd.setDayTemp(cwc.getList().get(i).getTemp().getDay());
                wd.setMinTemp(cwc.getList().get(i).getTemp().getMin());
                wd.setMaxTemp(cwc.getList().get(i).getTemp().getMax());
                wd.setMorningTemp(cwc.getList().get(i).getTemp().getMorn());
                wd.setEveningTemp(cwc.getList().get(i).getTemp().getEve());
                wd.setNightTemp(cwc.getList().get(i).getTemp().getNight());
                wd.setLatitude(cwc.getCity().getCoord().getLat());
                wd.setLongitude(cwc.getCity().getCoord().getLon());
                wd.setPressure(cwc.getList().get(i).getPressure());
                wd.setHumidity(cwc.getList().get(i).getHumidity());
                wd.setWindSpeed(cwc.getList().get(i).getSpeed());
                wd.setCloud(cwc.getList().get(i).getClouds());
                wd.setRain(cwc.getList().get(i).getRain());
                wd.setDescription(cwc.getList().get(i).getWeather().get(0).getDescription());
                wd.setDate(strDate);
                weatherDataList.add(wd);
                cal.add(Calendar.DAY_OF_MONTH, 1);
                Date date = cal.getTime();
                form = new SimpleDateFormat(Constants.DATE_FORMAT);
                System.out.println(form.format(date));
                strDate = new String(form.format(date));

            }
        }
        return weatherDataList;
    }
}