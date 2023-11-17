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
    public double minDistance;
    public ArrayList<City> generatedCities;

    /**
     * Constructor method which creates a list of cityNumber of cities, with a minimum distance between them.
     * These cities are then written onto a file.
     * @param cityNumber, the number of city to be created by our generator.
     * @param minValue, the minimum value for our x and y values.
     * @param maxValue, the maximum value for our x and y values.
     * @param minDistance, the minimum distance between each city.
     */
    public CityGenerator(int cityNumber, int minValue, int maxValue, double minDistance){
        this.cityNumber = cityNumber;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minDistance = minDistance;
        generatedCities = generateListOfCities();
    }

    /**
     * Creates a random list of cityNumber cities. Each city's x and y value is set between minValue and maxValue.
     * Each city has to be positioned with a minimum distance between previously created cities, following the
     * minDistance.
     * @return generatedCities, an ArrayList of cities.
     *
     */
    public ArrayList<City> generateListOfCities(){
        ArrayList<City> generatedCities = new ArrayList<>();

        int counter=0;

        //Keep adding new cities to the list until we have the required number of cities.
        while(counter < cityNumber){

            //Generate a new City
            City newCity = generateNewCity();

            //Check the minimum distance between cities is respected
            boolean status = checkMinDistance(newCity);

            //If it is, add it to the list
            if(status == true){
                generatedCities.add(newCity);
            }
            else{
                while(status == false){     //If it isn't keep generating a new city until the min distance is respected
                    newCity = generateNewCity();
                    status = checkMinDistance(newCity);
                }
                generatedCities.add(newCity);   //Then add it to the list
            }

            counter++;
        }

        return generatedCities;
    }

    /**
     * Method accessing ArrayList<City> generatedCities and checking that the newly created city newcity is at an
     * acceptable distance from all other cities in the list.
     * @param newCity, a newly created city
     * @return True/False. True means the newCity can be added to the list, False means that it is too close to another
     * city and cannot be added to the list.
     *
     */
    public boolean checkMinDistance(City newCity){
        int counter=0;
        while(counter<generatedCities.size()){
            City cityToCheck = generatedCities.get(counter);
            if(cityToCheck.getDistance(newCity) < minDistance){
                return false;
            }
            counter++;
        }
        return true;
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
