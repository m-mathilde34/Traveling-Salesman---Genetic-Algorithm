package ga_testing;

import ga_ts.CityGenerator;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

public class CityGeneratorTest {

    @Test
    void testSaveToFile(){
        CityGenerator cityGen = new CityGenerator(10, 10, 200, 20, true, false);
        cityGen.writeToCSVFile(false);
    }

    @Test
    void testReadFromFile(){
        CityGenerator cityGen = new CityGenerator("cities/cities.csv");
        int cityNumber = cityGen.cityNumber;

        assertEquals(10, cityNumber);

        int counter=0;
        while(counter < cityNumber){
            System.out.println(counter + " : x_coordinate " + cityGen.generatedCities.get(counter).x_coordinate
                    + " & y_coordinate " + cityGen.generatedCities.get(counter).y_coordinate);
            counter++;
        }
    }

    @Test
    void testGenerate1City(){
        CityGenerator cityGen = new CityGenerator(1, 10, 30, 5, false, false);
        int sizeOfList = cityGen.generatedCities.size();

        assertEquals(1, sizeOfList);
    }

    @Test
    void testGenerate10Cities(){
        CityGenerator cityGen = new CityGenerator(10, -20, 100, 5, false, false);
        int sizeOfList = cityGen.generatedCities.size();

        assertEquals(10, sizeOfList);
    }


    @Test
    void testMinDistanceNotRespected(){
        CityGenerator cityGen = new CityGenerator(2, 2,5,5, false, false);
        int sizeOfList = cityGen.generatedCities.size();
        int cityNumber = cityGen.cityNumber;

        assertEquals(1, sizeOfList);
        assertEquals(1, cityNumber);
    }

    @Test
    void testCityNumber0(){
        CityGenerator cityGen = new CityGenerator(0,2,200,5, false, false);

        assertEquals(0, cityGen.generatedCities.size());
        assertEquals(0, cityGen.cityNumber);
    }

}
