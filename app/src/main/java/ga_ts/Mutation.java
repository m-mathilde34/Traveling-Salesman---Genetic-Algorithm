package ga_ts;

import java.util.ArrayList;

public class Mutation {

    public Route mutatedChild;

    /**
     * Constructor applying the process of mutation to a child route.
     * @param child, the child route which has to be mutated.
     *
     */
    public Mutation(Route child){
        this.mutatedChild = applyMutation(child);
    }

    /**
     * Method applying Swap Mutation to a Route (a gene).
     * @param child, the route which has to be mutated following reproduction.
     * @return mutatedChild, the Route child after mutation has been applied.
     */
    public Route applyMutation(Route child){

        return mutatedChild;
    }
}
