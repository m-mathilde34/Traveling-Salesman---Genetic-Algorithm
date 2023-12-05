package ga_ts;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;

public class CityGenerator {

    public int cityNumber;
    private int minValue;
    private int maxValue;
    private double minDistance;
    public ArrayList<City> generatedCities;

    /**
     * Constructor method which creates a list of cityNumber of cities, with a minimum distance between them.
     * These cities are then written onto a file.
     * @param cityNumber, the number of city to be created by our generator.
     * @param minValue, the minimum value for our x and y values.
     * @param maxValue, the maximum value for our x and y values.
     * @param minDistance, the minimum distance between each city.
     *
     */
    public CityGenerator(int cityNumber, int minValue, int maxValue, double minDistance, boolean writeToFile){
        this.cityNumber = cityNumber;
        this.minValue = minValue;
        this.maxValue = maxValue;
        this.minDistance = minDistance;
        generatedCities = generateListOfCities();
        if(writeToFile){writeToCSVFile();}
    }

    /**
     * Alternate Constructor allowing us to read data from a CSV File.
     * This allows us to work with an already created CSV file and converts the data in the CSV File into an ArrayList
     * of cities.
     * @param filename, the name of the file containing our cities' coordinates.
     *
     */
    public CityGenerator(String filename){
        generatedCities = readCSVFile(filename);
        this.cityNumber = generatedCities.size();
        this.minDistance = 0.0;
        this.maxValue = 0;
        this.minValue = 0;
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

        if (this.cityNumber == 0) {
            return generatedCities;
        }

        //Add a first city to the list
        City firstCity = generateNewCity();
        generatedCities.add(firstCity);

        int counter=1;

        //Keep adding new cities to the list until we have the required number of cities.
        while(counter < cityNumber){

            int tries = 20;
            int startTry = 0;

            //Generate a new City
            City newCity = generateNewCity();

            //Check the minimum distance between cities is respected
            boolean status = checkMinDistance(generatedCities, newCity);

            //If it is, add it to the list
            if(status == true){
                generatedCities.add(newCity);
            }
            else {
                //If it isn't, try x number of times to create a compatible one before moving on
                while (startTry < tries && status == false) {
                    newCity = generateNewCity();
                    status = checkMinDistance(generatedCities, newCity);
                    startTry++;
                }
                //if status has changed, then it means the new city can be added to the list
                if (status == true) {
                    generatedCities.add(newCity);
                }
                else{
                    this.cityNumber--;
                }
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
    public boolean checkMinDistance(ArrayList<City> inProgressGenerator, City newCity){
        int counter=0;
        while(counter<inProgressGenerator.size()){
            City cityToCheck = inProgressGenerator.get(counter);
            if(cityToCheck.getDistance(newCity) < this.minDistance){
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
     *
     */
    public void writeToCSVFile(){
        File csvFile = new File("cities.csv");
        try(FileWriter fileCSVWriter = new FileWriter(csvFile)) {

            //Create a header
            fileCSVWriter.write("x,y");
            fileCSVWriter.write(System.getProperty("line.separator"));

            int counter = 0;
            for (int i = 0; i < generatedCities.size(); i++) {
                City city = generatedCities.get(i);

                //Make city coordinates into strings as CSV takes strings
                String city_x = Integer.toString(city.x_coordinate);
                String city_y = Integer.toString(city.y_coordinate);

                //Write to file and go to next line so that each city has its own line
                fileCSVWriter.write(city_x + "," + city_y);
                fileCSVWriter.write(System.getProperty("line.separator"));

                counter++;
            }

            fileCSVWriter.close();
        } catch(IOException e){
            System.out.println("Error Occurred Writing To File! " + e.getMessage());
        }
    }

    /**
     * Method to read a list of cities from a .csv file. This allows us to keep working on the same list of generated
     * cities. Line by line it reads the x and y coordinates of a city and creates a City object with it before adding
     * it to our ArrayList<City> generatedCities.
     * @param filename, the file containing our list of cities' coordinates.
     * @return citiesOnFile, an ArrayList<City>.
     *
     */
    public ArrayList<City> readCSVFile(String filename){
        ArrayList<City> citiesOnFile = new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String line;
            line = br.readLine();
            while((line= br.readLine()) != null){
                String[] values = line.split(",");
                City city = new City(Integer.parseInt(values[0]), Integer.parseInt(values[1]));
                citiesOnFile.add(city);
            }

            br.close();

        } catch(IOException e){
            System.out.println("Error Occurred Reading From File! "+ e.getMessage());
        }

        return citiesOnFile;
    }

}
