package alop.com.weatherforecast;

/**
 * Created by Alop Gudhate on 8/25/15.
 */
/*
* contains description about city
* */
public class City {
    private long id;
    private String name;
    private CityCoordinates coord;
    private String country;
    private int population;

    public City(long id, String name, CityCoordinates coord, String country, int population) {
        this.id = id;
        this.name = name;
        this.coord = coord;
        this.country = country;
        this.population = population;
    }

    public City() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CityCoordinates getCoord() {
        return coord;
    }

    public void setCoord(CityCoordinates coord) {
        this.coord = coord;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

}
