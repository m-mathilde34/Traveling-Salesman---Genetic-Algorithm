package ga_testing;

import ga_ts.*;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.ArrayList;

public class ReproductionTest {

    @Test
    void testSubsectionLengthGen2(){

    }

    @Test
    void testSubsectionLengthGen250(){

    }

    @Test
    void testSubsectionLengthGen620(){

    }

    @Test
    void testGetChild(){

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

        Reproduction reproduction = new Reproduction(selection1.fittestIndividual, selection2.fittestIndividual);

        //assertEquals(parent_1.route.size(), reproduction.child.route.size());

    }

    @Test
    void getChild_SetSubsectionLength(){

    }


}
