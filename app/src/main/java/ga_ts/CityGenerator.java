package ga_ts;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;
import java.io.FileWriter;

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

    /**
     * Method to write our ArrayList of newly generated cities to a .csv file. This avoids us having to keep generating
     * different lists of cities. It also helps to test methods.
     * @throws IOException
     *
     */
    public void writeToCSVFile() throws IOException {
        File csvFile = new File("cities.csv");
        FileWriter fileCSVWriter = new FileWriter(csvFile);

        int counter = 0;
        for(int i=0; i<generatedCities.size(); i++){
            City city = generatedCities.get(i);

            //Make city coordinates into strings as CSV takes strings
            String city_x = Integer.toString(city.x_coordinate);
            String city_y = Integer.toString(city.y_coordinate);

            //Write to file and go to next line so that each city has its own line
            fileCSVWriter.write(city_x);
            fileCSVWriter.write(city_y);
            fileCSVWriter.write(System.getProperty("line.separator"));

            counter++;
        }

        fileCSVWriter.close();
    }

    //Read method

    //Save method
}
