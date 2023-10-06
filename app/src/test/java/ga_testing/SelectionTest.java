package ga_testing;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import ga_ts.Route;
import ga_ts.City;
import ga_ts.Population;
import ga_ts.Selection;

import java.util.ArrayList;

public class SelectionTest {

    @Test
    void testCreateTournamentPool(){

        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(13, 9);
        City city4 = new City(20, 12);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        //Creating our population
        Population pop = new Population(cities);

        //Applying selection
        Selection select = new Selection(pop);

        //Check that the matting pool is the same size as k
        assertEquals(40, select.pool.size());
    }

    @Test
    void testCreateTournamentPoolManualK(){

        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(13, 9);
        City city4 = new City(20, 12);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        //Creating our population
        Population pop = new Population(cities);

        //Applying selection
        Selection select = new Selection(pop, 16);

        //Check that the matting pool is the same size as k
        assertEquals(16, select.pool.size());
    }

    @Test
    void testGetFittestIndividual(){
        //Creating our list of cities
        City city1 = new City(2, 3);
        City city2 = new City(6, 6);
        City city3 = new City(13, 9);
        City city4 = new City(20, 12);
        ArrayList<City> cities = new ArrayList<>();
        cities.add(city1);
        cities.add(city2);
        cities.add(city3);
        cities.add(city4);

        //Creating our population
        Population pop = new Population(cities, 10);

        //Applying selection
        Selection select = new Selection(pop, 4);

        //Manually change fitness level
        select.changeFitness(pop, select.pool.get(0), 20);
        select.changeFitness(pop, select.pool.get(1), 2);
        select.changeFitness(pop, select.pool.get(2), 150);
        select.changeFitness(pop, select.pool.get(3), 63);

        //Route at index 2 with fitness of 150 should be our fittest individual
        Route expected_winner = select.pool.get(2);

        assertEquals(expected_winner, select.fittestIndividual);

    }

}
