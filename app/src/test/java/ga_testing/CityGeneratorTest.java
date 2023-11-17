package ga_testing;

import ga_ts.CityGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CityGeneratorTest {

    @Test
    void testSaveToFile() throws IOException {
//        CityGenerator cityGen = new CityGenerator(10, 10, 200, 20);
//        cityGen.writeToCSVFile();
        //Currently, it is creating the file but not writing to it. Due to CSV???
    }

    @Test
    void testGenerate1City(){
        CityGenerator cityGen = new CityGenerator(1, 10, 30, 5);
        int sizeOfList = cityGen.generatedCities.size();

        assertEquals(1, sizeOfList);
    }

    @Test
    void testGenerate10Cities(){
        CityGenerator cityGen = new CityGenerator(10, -20, 100, 5);
        int sizeOfList = cityGen.generatedCities.size();

        assertEquals(10, sizeOfList);
    }


    @Test
    void testMinDistanceNotRespected(){
        CityGenerator cityGen = new CityGenerator(2, 2,5,5);
        int sizeOfList = cityGen.generatedCities.size();
        int cityNumber = cityGen.cityNumber;

        assertEquals(1, sizeOfList);
        assertEquals(1, cityNumber);
    }

    @Test
    void testCityNumber0(){
        CityGenerator cityGen = new CityGenerator(0,2,200,5);

        assertEquals(0, cityGen.generatedCities.size());
        assertEquals(0, cityGen.cityNumber);
    }



}
