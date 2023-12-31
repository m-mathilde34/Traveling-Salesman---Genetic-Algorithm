/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package ga_ts;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
        //Set our parameters
        int generationNumber = 100;
        int popSize = 20;
        int poolSize = 5;
        float mutationRate = 0.10f;
        int run = 1;
        int uniqueID = 1;
        String filename = "GA_Test";

        //Generate our list of cities
        CityGenerator cityGen = new CityGenerator(150, -200,500,30, true,
                true);
        cityGen.writeToCSVFile(true);
        ArrayList<City> cityList = cityGen.generatedCities;

        //Create our GA
        Population pop = new Population(cityList, popSize);

        //Create a list of metrics which we can use to visualise the data
        Route fittestIndiv = pop.findFittestIndividual();
        ArrayList<Double> bestFitnessPerGen = new ArrayList<>();
        ArrayList<Double> averageFitnessPerGen = new ArrayList<>();

        int counter=0;
        while(counter<generationNumber){
            //Add our metrics to their lists
            averageFitnessPerGen.add(counter, pop.averageFitness);
            bestFitnessPerGen.add(counter, pop.fittestIndividual.fitness);

            //Start selection
            Selection select1 = new Selection(pop, poolSize);

            //Get parent1
            Route parent1 = select1.getFittestIndividual();

            //Get parent2
            Route parent2 = select1.getFittestIndividual();

            //Reproduce
            Reproduction reproduction = new Reproduction(parent1, parent2);
            Route child = reproduction.getChild();

            //Mutation?
            Mutation mutation = new Mutation(child, mutationRate);
            Route mutatedChild = mutation.applyMutation(child);

            //Add child to population
            pop.addToPopulation(mutatedChild);

            //Check fittest individual
            fittestIndiv = pop.findFittestIndividual();

            //Up the counter
            counter++;

        }

        //Save results to CSV File
        WritingToFile writingToCSV = new WritingToFile(filename);
        writingToCSV.saveToCSV(uniqueID, generationNumber, averageFitnessPerGen, bestFitnessPerGen, popSize, poolSize,
                mutationRate, run, true);

        //Print the results
        System.out.println("Fittest Individual Found : " + "\n"
                + "Distance : " + fittestIndiv.routeDistance + "\n"
                + "Fitness : " + fittestIndiv.fitness + "\n");

    }

}
