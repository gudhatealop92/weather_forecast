package alop.com.weatherforecast;

import java.util.Collection;
import java.util.List;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
public class CityWeatherMultipleDays {
    private long dt;
    private CityTemp temp;
    private float pressure;
    private int humidity;
    private float speed;
    private List<CityWeather> weather;
    private int deg;
    private int clouds;
    private float rain;

    public CityWeatherMultipleDays(long dt, CityTemp temp, float pressure, int humidity, List<CityWeather> weather, int deg, int clouds, float speed, float rain) {
        this.dt = dt;
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.weather = weather;
        this.deg = deg;
        this.clouds = clouds;
        this.speed = speed;
        this.rain = rain;
    }

    public CityWeatherMultipleDays() {
    }

    public long getDt() {
        return dt;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public CityTemp getTemp() {
        return temp;
    }

    public void setTemp(CityTemp temp) {
        this.temp = temp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public void setHumidity(int humidity) {
        this.humidity = humidity;
    }

    public List<CityWeather> getWeather() {
        return weather;
    }

    public void setWeather(List<CityWeather> weather) {
        this.weather = weather;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public int getDeg() {
        return deg;
    }

    public void setDeg(int deg) {
        this.deg = deg;
    }

    public int getClouds() {
        return clouds;
    }

    public void setClouds(int clouds) {
        this.clouds = clouds;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }
}
