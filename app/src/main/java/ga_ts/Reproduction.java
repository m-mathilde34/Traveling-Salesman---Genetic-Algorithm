package ga_ts;

import java.util.ArrayList;
import java.util.Random;

public class Reproduction {

    public int subsectionLength;
    public Route parent1;
    public Route parent2;
    public Route child;

    public Reproduction(int generationNumber, Route parent1, Route parent2){
        subsectionLength = determineSubsectionLength(generationNumber);
        this.parent1 = parent1;
        this.parent2 = parent2;
        child = getChild();
    }

    public int determineSubsectionLength(int generationNumber){
        //every 200 generations, increase subsection size?
        int addToLength = generationNumber/200;

        int subsetLength = 2 + addToLength;

        if(subsetLength >= parent1.route.size()){
            subsetLength = parent1.route.size() - 1;
        }

        return subsetLength;
    }

    public Route getChild(){
        ArrayList<City> childArray = new ArrayList<>();

        //For parent1, get subsection to keep and insert in child at the same place as the parent


        //Then, go through parent2 one element at a time. if it is already present in child, skip. Otherwise, insert.
        //continue until parent2 has no more new elements.
        int counter = 0;
        while(counter < parent2.route.size()){
            City cityToTest = parent2.route.get(counter);
            if(!childArray.contains(cityToTest)){
                childArray.add(counter, cityToTest);
            }
        }

        //Creates a random Route
        Route child = new Route(childArray);
        //Set the random route to be our child
        child.setRoute(childArray);

        return child;
    }

}
