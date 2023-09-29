package ga_ts;

import org.checkerframework.checker.units.qual.A;

import java.util.ArrayList;
import java.util.Random;

public class Selection {

    public int k;
    public ArrayList<Route> pool;
    public Route fittestIndividual;


    public Selection(Population pop){
        this.k = 40;
        pool = createTournamentPool(pop);
        fittestIndividual = getFittestIndividual();
    }

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
