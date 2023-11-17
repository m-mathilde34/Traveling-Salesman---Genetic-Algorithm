package ga_testing;

import ga_ts.CityGenerator;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class CityGeneratorTest {

    @Test
    void testSaveToFile() throws IOException {
        CityGenerator cityGen = new CityGenerator(10, 10, 200, 20);
        cityGen.writeToCSVFile();
    }

    @Test
    void testGenerate1City(){

    }

    @Test
    void testMinDistanceNoCity(){

    }

    @Test
    void testMinDistanceNotRespected(){

    }

    @Test
    void testMinDistanceRespected(){

    }

}
