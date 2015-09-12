package alop.com.weatherforecast.valueobjects;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
/*
* contains geographic coordinates of location/city
* */
public class CityCoordinates {
    private float lon;
    private float lat;

    public CityCoordinates(float lon, float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public CityCoordinates() {
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }
}
