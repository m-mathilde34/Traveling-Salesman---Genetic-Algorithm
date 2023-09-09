package ga_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.math.BigDecimal;
import java.math.RoundingMode;

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

    /**
     * Example route used for test on route distance:
     *
     * 4|
     *  |
     * 3|      A           B           C
     *  |
     * 2|
     *  |
     * 1|
     *  |
     * 0|_________________________________
     * 0   1   2   3   4   5   6   7   8
     *
     * A(2,3), B(5,3),  C(8,3)
     * Distance should be as follows:
     * AB = 3
     * BC = 3
     * CA = 6
     * Total = 12
     */
    @Test
    void testRouteDistance(){
        //Creating our list of cities
        City cityA = new City(2,3);
        City cityB = new City(5,3);
        City cityC = new City(8,3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);

        //Creating our route
        Route route = new Route(cities);

        //Manually setting our route for test purposes
        route.setRoute(cities);

        //Evaluating
        double distance = route.routeDistance;
        assertEquals(12, distance);
    }

    @Test
    void testRouteGoodFitnessHyperbole(){
        //Creating our list of cities
        City cityA = new City(2,3);
        City cityB = new City(5,3);
        City cityC = new City(8,3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);

        //Creating our route
        Route route = new Route(cities);

        //Manually setting our distance to be low so our fitness should be high and good.
        route.setDistance(4);

        assertEquals(0.25, route.fitness);
    }

    @Test
    void testRouteBadFitnessHyperbole(){
        //Creating our list of cities
        City cityA = new City(2,3);
        City cityB = new City(5,3);
        City cityC = new City(8,3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);

        //Creating our route
        Route route = new Route(cities);

        //Manually setting our distance to be low so our fitness should be high and good.
        route.setDistance(200);

        assertEquals(0.005, route.fitness);
    }

    @Test
    void testRouteGoodFitnessNormal(){
        //Creating our list of cities
        City cityA = new City(2,3);
        City cityB = new City(5,3);
        City cityC = new City(8,3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);

        //Creating our route
        Route route = new Route(cities);

        //Manually setting our distance to be low so our fitness should be high.
        route.setDistance2(1);
        //Rounding up our results to the 4th decimal place.
        double fitness_raw = route.fitness;
        BigDecimal bd = new BigDecimal(fitness_raw).setScale(4, RoundingMode.HALF_UP);

        assertEquals(0.2420, bd.doubleValue());
    }

    @Test
    void testRouteBadFitnessNormal(){
        //Creating our list of cities
        City cityA = new City(2,3);
        City cityB = new City(5,3);
        City cityC = new City(8,3);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(cityA);
        cities.add(cityB);
        cities.add(cityC);

        //Creating our route
        Route route = new Route(cities);

        //Manually setting our distance to be low so our fitness should be high.
        route.setDistance2(20);
        //Rounding up our results to the 4th decimal place.
        double fitness_raw = route.fitness;
        BigDecimal bd = new BigDecimal(fitness_raw).setScale(4, RoundingMode.HALF_UP);

        assertEquals(0.0, bd.doubleValue());
    }

}
