package ga_ts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class CityGenerator {

    public int cityNumber;
    public int minValue;
    public int maxValue;
    public double minDistanceRadius;
    public ArrayList<City> generatedCities;

    /**
     * Constructor method which creates a list of cityNumber of cities, with a minimum distance between them.
     * These cities are then written onto a file.
     * @param cityNumber, the number of city to be created by our generator.
     * @param minValue, the minimum value for our x and y values.
     * @param maxValue, the maximum value for our x and y values.
     * @param minDistanceRadius, the minimum distance between each city.
     */
    public CityGenerator(int cityNumber, int minValue, int maxValue, double minDistanceRadius){
        this.cityNumber = cityNumber;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minDistanceRadius = minDistanceRadius;
        generatedCities = generateListOfCities();
    }

    /**
     * Creates a random list of cityNumber cities. Each city's x and y value is set between minValue and maxValue.
     * Each city has to be positioned with a minimum distance between previously created cities, following the
     * minDistanceRadius.
     * @return generatedCities, an ArrayList of cities.
     *
     */
    public ArrayList<City> generateListOfCities(){
        ArrayList<City> generatedCities = new ArrayList<>();

        return generatedCities;
    }

    /**
     * Randomly sets a x and y value in order to create a city.
     * @return city, a City with a position of (x,y)
     *
     */
    public City generateNewCity(){
        Random rand = new Random();
        int randomX = rand.nextInt(minValue, maxValue+1);
        int randomY = rand.nextInt(minValue, maxValue+1);

        City city = new City(randomX, randomY);
        return city;
    }
}
