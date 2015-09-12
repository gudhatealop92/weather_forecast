package alop.com.weatherforecast.valueobjects;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
/*
* contains weather which is used in cityWeatherCondition after getting api response
* */
public class CityWeather {
    private int id;
    private String main;
    private String description;
    private String icon;

    public CityWeather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public CityWeather() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }
}
