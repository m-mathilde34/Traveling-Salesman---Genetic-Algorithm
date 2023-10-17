package ga_ts;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Reproduction {

    public int subsectionLength;
    //public float growthRate = 0.05f;
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
//    public Reproduction(int generationNumber, Route parent1, Route parent2){
//        subsectionLength = determineSubsectionLength(generationNumber);
//        this.parent1 = parent1;
//        this.parent2 = parent2;
//        child = getChild_SetSubsectionLength();
//    }

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
        City[] childArray = new City[this.parent1.route.size()];

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
            childArray[higherBound] = this.parent1.route.get(higherBound);
            higherBound--;
        }

        //Then, go through parent2 one element at a time. if it is already present in child, skip. Otherwise, insert.
        //continue until parent2 has no more new elements.
        int counter = 0;
        while(counter < this.parent2.route.size()){
            City cityToTest = this.parent2.route.get(counter);
            boolean cityPresent = false;

            for(int i=0; i<childArray.length; i++){
                if(childArray[i] == cityToTest){
                    cityPresent = true;
                }
            }

            if(cityPresent == false){
                childArray[counter] = cityToTest;
            }

            counter++;
        }

        //Change child array into ArrayList
        ArrayList<City> childArrayList = new ArrayList<>(Arrays.asList(childArray));
        //Creates a random Route
        Route child = new Route(childArrayList);
        //Set the random route to be our child
        child.setRoute(childArrayList);

        return child;
    }

}
