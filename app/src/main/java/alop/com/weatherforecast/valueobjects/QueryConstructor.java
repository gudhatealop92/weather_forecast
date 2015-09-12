package alop.com.weatherforecast.valueobjects;

import android.location.Location;

import alop.com.weatherforecast.system.Constants;

/**
 * Created by justbe on 12/9/15.
 */
public class QueryConstructor {
    public String getQuery(Location location) {
        StringBuffer query = new StringBuffer();
        query = query.append(Constants.QUERY_FIRST_PART).append("lat=").append(location.getLatitude()).append("&lon=").append(location.getLongitude()).append("&cnt=").append(Constants.COUNT).append("&units=").append(Constants.UNIT).append("&APPID=").append(Constants.APP_ID);
        return query.toString();
    }

    public String getQuery(String CityName) {
        StringBuffer query = new StringBuffer();
        query = query.append(Constants.QUERY_FIRST_PART).append("q=").append(CityName.replaceAll(" ", "%20")).append("&cnt=").append(Constants.COUNT).append("&units=").append(Constants.UNIT).append("&APPID=").append(Constants.APP_ID);
        return query.toString();
    }
}
