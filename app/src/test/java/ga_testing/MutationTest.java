package ga_testing;

import ga_ts.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

public class MutationTest {

    @Test
    void applyMutationTest(){
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

        //Applying selection
        Selection selection1 = new Selection(pop);
        Selection selection2 = new Selection(pop);

        //Applying reproduction
        Reproduction reproduction = new Reproduction(selection1.fittestIndividual, selection2.fittestIndividual);

        //Getting our child
        Route child = reproduction.child;

        Mutation mutation = new Mutation(child);

        int child_size = child.route.size();
        int mutated_child_size = mutation.mutatedChild.route.size();

        //Checks that both mutated and original child have the same size
        assertEquals(child_size, mutated_child_size);
    }

    @Test
    void applyMutationWhenRate100Test(){
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

        //Applying selection
        Selection selection1 = new Selection(pop);
        Selection selection2 = new Selection(pop);

        //Applying reproduction
        Reproduction reproduction = new Reproduction(selection1.fittestIndividual, selection2.fittestIndividual);

        //Getting our child
        Route child = reproduction.child;

        Mutation mutation = new Mutation(child, 1.0f);

        //Since the mutation probability is 100%, the children should be different.
        assertNotEquals(child, mutation.mutatedChild);
    }

    @Test
    void applyMutationWhenRate0Test(){
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

        //Applying selection
        Selection selection1 = new Selection(pop);
        Selection selection2 = new Selection(pop);

        //Applying reproduction
        Reproduction reproduction = new Reproduction(selection1.fittestIndividual, selection2.fittestIndividual);

        //Getting our child
        Route child = reproduction.child;

        Mutation mutation = new Mutation(child, 0.0f);

        //Since the mutation probability is 100%, the children should be identical.
        assertEquals(child, mutation.mutatedChild);
    }
}
