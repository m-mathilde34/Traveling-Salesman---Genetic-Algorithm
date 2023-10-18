package ga_testing;

import ga_ts.Route;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ga_ts.City;
import ga_ts.Population;

import java.util.ArrayList;

public class PopulationTest {

    @Test
    void testCreatePopulation(){
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

        //Creating our population
        Population pop = new Population(cities);
        int targetSize = 100;

        //checking the length of the population
        assertEquals(targetSize, pop.routes.size());
    }

    @Test
    void testAverageFitness(){
        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(13, 9);
        City city4 = new City(20, 12);
        City city5 = new City(8, 1);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);
        cities.add(city5);

        //Creating our population with a specific size
        Population pop = new Population(cities, 3);

        //change fitness of our routes
        Route route1 = pop.routes.get(0);
        Route route2 = pop.routes.get(1);
        Route route3 = pop.routes.get(2);
        pop.changeFitness(route1, 20);
        pop.changeFitness(route2, 24);
        pop.changeFitness(route3, 10);

        double expected = 18;
        assertEquals(expected, pop.averageFitness);
    }

    @Test
    void testHighestFitness(){
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

        //Creating our population with a specific size
        Population pop = new Population(cities, 3);

        //change fitness of our routes
        Route route1 = pop.routes.get(0);
        Route route2 = pop.routes.get(1);
        Route route3 = pop.routes.get(2);
        pop.changeFitness(route1, 0.50);
        pop.changeFitness(route2, 0.0014);
        pop.changeFitness(route3, 0.24423);

        double expected = 0.50;
        assertEquals(expected, pop.highestFitness);
    }



}
