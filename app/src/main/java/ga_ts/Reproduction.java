package ga_ts;

import java.util.ArrayList;
import java.util.Random;

public class Reproduction {

    public int subsectionLength;
    public float growthRate = 0.05f;
    public Route parent1;
    public Route parent2;
    public Route child;

    /**
     * Constructor.
     * @param generationNumber, the number indication which generation is going through reproduction. The higher the
     * reproduction number, the longer the subsection we keep from parent1.
     * @param parent1, a Route selected as parent 1 for reproduction.
     * @param parent2, a Route selected as parent 2 for reproduction.
     *
     */
    public Reproduction(int generationNumber, Route parent1, Route parent2){
        subsectionLength = determineSubsectionLength(generationNumber);
        this.parent1 = parent1;
        this.parent2 = parent2;
        child = getChild_SetSubsectionLength();
    }

    /**
     * Constructor.
     * In this version, the subsection length is random everytime.
     * @param parent1, a Route selected as parent 1 for reproduction.
     * @param parent2, a Route selected as parent 2 for reproduction.
     *
     */
    public Reproduction(Route parent1, Route parent2){
        this.parent1 = parent1;
        this.parent2 = parent2;
        child = getChild();
    }

    /**
     * Method used to implement the Reproduction process using Ordered Crossover. It randomly selects a subsection from
     * parent 1 which is then copied into the child at the same emplacement. The rest of the genetics are then copied
     * from parent 2 in the order in which they appear, so long as they are not already present in the subsection which
     * was previously copied from parent 1.
     * @return child, a Route formed from parent1 and parent2 using ordered crossover.
     *
     */
    public Route getChild(){
        ArrayList<City> childArray = new ArrayList<>();

        //For parent1, get subsection to keep and insert in child at the same place as the parent
        Random rand = new Random();

        int randomX = rand.nextInt(0, this.parent1.route.size());
        int randomY = rand.nextInt(0, this.parent1.route.size());

        //Ensures that both lower and higher bounds are not the same number
        while(randomY == randomX){
            randomY = rand.nextInt(0, this.parent1.route.size());
        }

        int lowerBound = Math.min(randomX, randomY);
        int higherBound = Math.min(randomX, randomY);

        while(higherBound >= lowerBound){
            childArray.add(higherBound, this.parent1.route.get(lowerBound));
            higherBound--;
        }

        //Then, go through parent2 one element at a time. if it is already present in child, skip. Otherwise, insert.
        //continue until parent2 has no more new elements.
        int counter = 0;
        while(counter < this.parent2.route.size()){
            City cityToTest = this.parent2.route.get(counter);
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

    /**
     * Method used to determine the length of the subset which will be used in the Ordered Crossover Reproduction
     * process.
     * @param generationNumber, the number indicating which generation is going through reproduction. The higher the
     * reproduction number, the longer the subsection we keep from parent1.
     * @return subsetLength, an int determining how long the subset we keep from parent1 has to be.
     *
     */
    public int determineSubsectionLength(int generationNumber){
        //at maximum the subsection can only be 8/10 of the original length of parent1
        //check generation number, if over a certain number, increase subsection length by the rate.
        //
        int addToLength = generationNumber/200;

        int subsetLength = 2 + addToLength;

        if(subsetLength >= parent1.route.size()){
            subsetLength = parent1.route.size() - 1;
        }

        return subsetLength;
    }

    /**
     * Method used to implement the Reproduction process using Ordered Crossover. Instead of using a random length for
     * the subsection each time however, as the algorithm goes through generations, the subset to keep from parent 1
     * grows in length until it occupies a maximum length of 8/10 of what the parent's route size is. Hence, the higher
     * the generation number, the longer the subsection to keep.
     * @return child, a Route formed from parent1 and parent2 using ordered crossover.
     *
     */
    public Route getChild_SetSubsectionLength(){
        ArrayList<City> childArray = new ArrayList<>();

        //For parent1, get subsection to keep and insert in child at the same place as the parent
            //place subsection randomly on parent between 0 and parent.route.size

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
