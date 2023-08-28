package ga_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ga_ts.City;

public class CityTest {

    @Test
    void testDistance() {
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);

        double distance = city1.getDistance(city2);

        assertEquals(5, distance);
    }

    @Test
    void testDistanceSameSpace(){

        City city1 = new City(5, 3);
        City city2 = new City(5, 3);

        double distance = city1.getDistance(city2);

        assertEquals(0,distance);
    }

    @Test
    void testDistanceNegativeCoordinates(){
        City city1 = new City(2, -8);
        City city2 = new City(-4, 11);

        double distance = city1.getDistance(city2);

        assertTrue(distance>0);
    }

}

