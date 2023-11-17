package ga_testing;

import ga_ts.CityGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class CityGeneratorTest {

    @Test
    void testSaveToFile() throws IOException {
        CityGenerator cityGen = new CityGenerator(10, 10, 200, 20);
        cityGen.writeToCSVFile();
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

        //Currently, stuck in infinite loop (as it tries forever to create a new city which can fit)
    }

}
