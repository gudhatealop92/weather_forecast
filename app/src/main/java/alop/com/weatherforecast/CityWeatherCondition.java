package alop.com.weatherforecast;

import java.util.List;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
/*
* contains all the data received from json response
*/
public class CityWeatherCondition {
    private  City city;
    private String cod;
    private String message;
    private int cnt;
    private List<CityWeatherMultipleDays> list;

    public CityWeatherCondition(City city, String cod, String message, int cnt, List<CityWeatherMultipleDays> list) {
        this.city = city;
        this.cod = cod;
        this.message = message;
        this.cnt = cnt;
        this.list = list;
    }

    public CityWeatherCondition() {
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public String getCod() {
        return cod;
    }

    public void setCod(String cod) {
        this.cod = cod;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public List<CityWeatherMultipleDays> getList() {
        return list;
    }

    public void setList(List<CityWeatherMultipleDays> list) {
        this.list = list;
    }
}
