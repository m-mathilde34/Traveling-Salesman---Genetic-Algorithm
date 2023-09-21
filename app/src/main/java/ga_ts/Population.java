package ga_ts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Population {

    public ArrayList<Route> routes;
    public double averageFitness;
    public double highestFitness;
    public int popSize = 20;

    /**
     * Constructor method which creates and initialise the object (the population).
     * It randomly creates routes to create a population.
     * The population is made of 20 individuals (popSize).
     * Each population has a maximum fitness as well as an average fitness.
     *
     */
    public Population(ArrayList<City> cities) {
        routes = createRoutesList(cities);
        averageFitness = calculateAverageFitness();
        highestFitness = findHighestFitness();
    }

    /**
     * Creates a list of random routes (individuals) which makes up our population.
     * @param cities, an ArrayList of cities used to create our routes.
     * @return pop, an ArrayList of Route, randomly created from a list of cities.
     *
     */
    public ArrayList<Route> createRoutesList(ArrayList<City> cities){
        ArrayList<Route> pop = new ArrayList<>();
        int counter = 0;

        while(counter<popSize){
            Route route = new Route(cities);
            pop.add(route);
            counter += 1;
        }

        return pop;
    }

    /**
     * Calculates the average fitness of a population.
     * Adds every fitness up and divides it by the size of the population.
     * @return average, the average fitness of a given population.
     *
     */
    public double calculateAverageFitness(){
        Route route;
        int counter = 0;
        double total = 0;

        while(counter < popSize){
            route = routes.get(counter);
            total += route.fitness;
            counter += 1;
        }

        double average = total / popSize;

        return average;
    }

    /**
     * Find the highest fitness value for a population.
     * Compare each individual (route) to find the highest fitness.
     * @return max_fitness, the maximum fitness value of a given population.
     *
     */
    public double findHighestFitness(){
        Route route;
        int counter = 0;
        double max_fitness = 0;

        while(counter < popSize){
            route = routes.get(counter);
            if(route.fitness > max_fitness){
                max_fitness = route.fitness;
            }
            counter += 1;
        }

        return max_fitness;
    }

}
