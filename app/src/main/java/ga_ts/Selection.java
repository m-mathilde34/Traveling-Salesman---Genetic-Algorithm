package ga_ts;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Random;

public class Selection {

    public int k;
    public ArrayList<Route> pool;
    public Route fittestIndividual;

    /**
     * Constructor method.
     * It applies the tournament selection process by creating a pool of size k with k random individuals from our
     * population.
     * @param pop, a population to which we apply the Selection process.
     *
     */
    public Selection(Population pop){
        this.k = 40;
        pool = createTournamentPool(pop);
        fittestIndividual = getFittestIndividual();
    }

    /**
     * Alternative constructor
     * @param pop, a population to which we apply the Selection process.
     * @param k, our pool size
     *
     */
    public Selection(Population pop, int k){
        this.k = k;
        pool = createTournamentPool(pop);
        fittestIndividual = getFittestIndividual();
    }

    /**
     * Setter method.
     * Allows us to manually change the fitness of our routes in order to test that further methods are working as
     * expected.
     * @param population, the population of routes we are working with
     * @param route, the route we want to change the fitness of
     * @param fitness, the new value we want to give to our route
     *
     */
    public void changeFitness(Population population, Route route, double fitness){
        int routeIndex = population.routes.indexOf(route);
        population.routes.get(routeIndex).setFitness(fitness);
        route.setFitness(fitness);
        this.fittestIndividual = getFittestIndividual();
    }

    /**
     * Create a matting pool from which to select our Parent individual.
     * @param pop, the population from which selection is made.
     * @return mattingPool, an ArrayList<Route> representing our matting pool of size k.
     *
     */
    public ArrayList<Route> createTournamentPool(Population pop){
        //Copy our population list
        ArrayList<Route> copyList = new ArrayList<>();
        copyList.addAll(pop.routes);

        //Initialise new variables
        ArrayList<Route> mattingPool = new ArrayList<>();
        Random rand = new Random();

        //While our pool has not reached size k,
        //Select a random individual and add him to the pool
        //Delete the random individual from the copied population to avoid adding the same individual
        //This does not stop duplicate as a population can have duplicate routes
        //This only stop the one specific iteration of an individual to be added more than once
        int counter = 0;
        while(counter < k){
            int random = rand.nextInt(pop.popSize);
            mattingPool.add(copyList.get(random));
            copyList.remove(random);
            counter += 1;
        }

        return mattingPool;
    }

    /**
     * Find the fittest individual of a selection pool.
     * Compare each individual (route) to find the highest fitness and therefore the fittest route.
     * @return fittestIndividual, the fittest individual in this pool.
     *
     */
    public Route getFittestIndividual(){
        Route route;
        Route fittestIndividual = null;
        int counter = 0;
        double max_fitness = 0;

        while(counter < k){
            route = pool.get(counter);
            if(route.fitness > max_fitness){
                max_fitness = route.fitness;
                fittestIndividual = route;
            }
            counter += 1;
        }

        return fittestIndividual;
    }


}
