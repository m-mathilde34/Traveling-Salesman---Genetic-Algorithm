package ga_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ga_ts.City;

public class CityTest {


    @Test
    void testDistance(){
        City city1 = new City(2,3);
        City city2 = new City(6,6);

        double distance = city1.getDistance(city1, city2);
        System.out.println("The calculated distance is: " + distance);

        assertEquals(5, distance);
    }
}
