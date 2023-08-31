package ga_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import ga_ts.City;
import ga_ts.Route;

import java.util.ArrayList;

public class RouteTest {

    @Test
    void testRouteCreation(){
        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(13, 9);
        City city4 = new City(20, 12);
        City city5 = new City(8, 1);
        City city6 = new City(15, 10);
        City city7 = new City(5, 11);
        City city8 = new City(10, 19);
        City city9 = new City(18, 7);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);
        cities.add(city6);
        cities.add(city7);
        cities.add(city8);
        cities.add(city9);

        int originalSize = cities.size();

        // Creating our test route
        Route path = new Route(cities);

        //Evaluating
        int routeSize = path.route.size();
        int finalSize = cities.size();

        assertEquals(originalSize, finalSize); // checks original list has not been altered
        assertEquals(routeSize, originalSize); // checks that the route has the same length as the original list
    }

    @Test
    void testRoute1CityDistance(){
        //Creating our list of cities
        City city1 = new City(2, 3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);

        //Creating our test route
        Route route = new Route(cities);

        //Evaluating
        double distance = route.routeDistance;
        assertEquals(0, distance);
    }

    @Test
    void testRouteDistance(){
        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(4, 8);
        City city4 = new City(5, 7);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        //Creating our test route
        Route route = new Route(cities);

        //Evaluating
        double distance = route.routeDistance;
        assertTrue(distance > 0);

    }

    @Test
    void testRouteGoodFitness(){

    }

    @Test
    void testRouteBadFitness(){

    }

}
