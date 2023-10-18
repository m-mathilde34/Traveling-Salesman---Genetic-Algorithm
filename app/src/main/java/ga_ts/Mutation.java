package ga_ts;

import java.util.ArrayList;
import java.util.Random;

public class Mutation {

    public Route mutatedChild;
    public float mutationProbability;

    /**
     * Constructor applying the process of mutation to a child route.
     * @param child, the child route which has to be mutated.
     *
     */
    public Mutation(Route child){
        this.mutationProbability = 0.15f;
        this.mutatedChild = applyMutation(child);
    }

    public Mutation(Route child, float mutationProbability){
        this.mutationProbability = mutationProbability;
        this.mutatedChild = applyMutation(child);
    }

    /**
     * Method applying Swap Mutation to a Route (a gene).
     * @param child, the route which has to be mutated following reproduction.
     * @return mutatedChild, the Route child after mutation has been applied.
     */
    public Route applyMutation(Route child){
        ArrayList<City> childCopy = new ArrayList<>();
        childCopy.addAll(child.route);

        Route childRouteCopy = new Route(childCopy);
        childRouteCopy.setRoute(childCopy);


        //Get a float between 0.0 and 1.0.
        Random rand = new Random();
        float probability = rand.nextFloat();

        //If it is more than our mutation probability, the child will not be mutated.
        if(probability >= this.mutationProbability){
            return child;
        }

        //If it is less, we will mutate the child by swapping around two genes.
        //We randomly get the indexes of those two genes
        Random randomInt = new Random();
        int indexGene1 = randomInt.nextInt(child.route.size());
        int indexGene2 = randomInt.nextInt(child.route.size());

        //This ensures that we actually select two distinct genes.
        while(indexGene2 == indexGene1){
            indexGene2 = randomInt.nextInt(child.route.size());
        }

        City city1 = child.route.get(indexGene1);
        City city2 = child.route.get(indexGene2);

        //We swap around the place of two cities
        childRouteCopy.route.set(indexGene1, city2);
        childRouteCopy.route.set(indexGene2, city1);

        return childRouteCopy;
    }
}
