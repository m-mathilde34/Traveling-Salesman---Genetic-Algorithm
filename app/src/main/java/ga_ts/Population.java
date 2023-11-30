package ga_ts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Population {

    public ArrayList<Route> routes;
    public double averageFitness;
    public Route fittestIndividual;
    public int popSize;

    /**
     * Constructor method which creates and initialise the object (the population).
     * It randomly creates routes to create a population.
     * The population is made of 100 individuals (popSize).
     * Each population has a fittest individual as well as an average fitness.
     *
     */
    public Population(ArrayList<City> cities) {
        popSize = 100;
        routes = createRoutesList(cities);
        averageFitness = calculateAverageFitness();
        fittestIndividual = findFittestIndividual();
    }

    /**
     * Alternate Constructor.
     * Allows us to set the size of our population in order to test other methods.
     * @param populationSize, an int representing how many individuals our population has.
     */
    public Population(ArrayList<City> cities, int populationSize){
        popSize = populationSize;
        routes = createRoutesList(cities);
        averageFitness = calculateAverageFitness();
        fittestIndividual = findFittestIndividual();
    }

    /**
     * Setter method.
     * Allows us to manually change the fitness of our routes in order to test that further methods are working as
     * expected.
     * @param route, a randomly created ArrayList of cities.
     * @param fitness, a double, our chosen fitness value.
     *
     */
    public void changeFitness(Route route, double fitness){
        route.setFitness(fitness);
        this.fittestIndividual = findFittestIndividual();
        this.averageFitness = calculateAverageFitness();
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
     * Find the fittest individual for a population.
     * Compare each individual (route) to find the highest fitness.
     * @return fittestIndividual, the Route with the best fitness value of a given population.
     *
     */
    public Route findFittestIndividual(){
        Route route;
        int counter = 0;
        double max_fitness = 0;
        Route fittestIndividual = null;

        while(counter < popSize){
            route = routes.get(counter);
            if(route.fitness > max_fitness){
                max_fitness = route.fitness;
                fittestIndividual = route;
            }
            counter += 1;
        }

        return fittestIndividual;
    }

}
