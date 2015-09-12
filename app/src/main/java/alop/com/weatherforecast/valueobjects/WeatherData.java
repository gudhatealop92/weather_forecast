package alop.com.weatherforecast.valueobjects;

/**
 * Created by Alop Gudhate on 8/28/15.
 */
/*
* constructing data object for assigning to the forecast list item
* */
public class WeatherData {
    private String city;
    private String country;
    private float dayTemp;
    private float minTemp;
    private float maxTemp;
    private float morningTemp;
    private float eveningTemp;
    private float nightTemp;
    private float latitude;
    private float longitude;
    private float pressure;
    private float humidity;
    private float windSpeed;
    private float cloud;
    private String date;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;

    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    private String description;

    public String getCountry() {
        return country;
    }

    public float getLatitude() {
        return latitude;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getDayTemp() {
        return dayTemp;
    }

    public void setDayTemp(float dayTemp) {
        this.dayTemp = dayTemp;
    }

    public float getMorningTemp() {
        return morningTemp;
    }

    public void setMorningTemp(float morningTemp) {
        this.morningTemp = morningTemp;
    }

    public float getEveningTemp() {
        return eveningTemp;
    }

    public void setEveningTemp(float eveningTemp) {
        this.eveningTemp = eveningTemp;
    }

    public float getNightTemp() {
        return nightTemp;
    }

    public void setNightTemp(float nightTemp) {
        this.nightTemp = nightTemp;
    }

    public float getPressure() {
        return pressure;
    }

    public void setPressure(float pressure) {
        this.pressure = pressure;
    }

    public float getHumidity() {
        return humidity;
    }

    public void setHumidity(float humidity) {
        this.humidity = humidity;
    }

    public float getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(float windSpeed) {
        this.windSpeed = windSpeed;
    }

    public float getCloud() {
        return cloud;
    }

    public void setCloud(float cloud) {
        this.cloud = cloud;
    }

    public float getRain() {
        return rain;
    }

    public void setRain(float rain) {
        this.rain = rain;
    }

    private float rain;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public float getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(float minTemp) {
        this.minTemp = minTemp;
    }

    public float getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(float maxTemp) {
        this.maxTemp = maxTemp;
    }
}
