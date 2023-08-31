package ga_ts;

import java.lang.reflect.Array;
import java.util.ArrayList;
import ga_ts.City;
import java.util.Random;

public class Route {

    public ArrayList<City> route;
    public double fitness;
    public int routeDistance;

    /**
     * Constructor method which creates and initialise the object (the route).
     * From a list of cities, it randomly creates a route ensuring that there are no duplicate cities.
     * Each route's distance is calculated and then evaluated via a fitness function.
     * @param cities is a list of city which needs to be visited by the TS.
     *
     **/
    public Route(ArrayList<City> cities){
        route = createRoute(cities);
        fitness = calculateFitness();
        routeDistance = routeDistance();
    }

    /**
     * Evaluate how good or bad the quality of a route is and returns a measure of it.
     * @return fitness
     *
     **/
    public double calculateFitness(){

        return fitness;
    }

    public double calculateFitnessSin(){

        return fitness;
    }

    public double calculateFitnessHyperbole(){

        return fitness;
    }

    public int routeDistance(){

        return routeDistance;
    }

    /**
     * Method creating a route between cities.
     * It makes a copy of our list of cities and randomly picks a city to add to our new route. It then removes it
     * from the copied cities list. This ensures that there are no duplicate cities in our route.     *
     * @return route, which is an ArrayList with each city in a random order and accounted for only once.
     *
     **/
    public ArrayList<City> createRoute(ArrayList<City> cities){
        //Copy our cities list
        ArrayList<City> copyList = new ArrayList<>();
        copyList.addAll(cities);

        //Initialise essential variables (random, route and length of copied list).
        ArrayList<City> route = new ArrayList<>();
        Random rand = new Random();

        // whilst the copied list is not empty,
        // get a random City from the list
        // add it to our route
        // remove it from the copied list.
        while(!copyList.isEmpty()){

            int listLength = copyList.size();
            int random = rand.nextInt(listLength);
            City element = copyList.get(random);
            route.add(element);
            copyList.remove(random);

        }

        return route;
    }

}
