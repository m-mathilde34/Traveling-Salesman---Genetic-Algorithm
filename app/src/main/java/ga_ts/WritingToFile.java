package ga_ts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritingToFile {

    public String filename;

    /**
     * Constructor.
     * @param filename, a string to be used as the name of our CSV file.
     *
     */
    public WritingToFile(String filename){
        this.filename = filename;
    }

    /**
     * Method to save GA results to a CSV file
     * @param generations, the total number of generations the GA will run for.
     * @param averageFitnessPerGen, an ArrayList<Double> with the average fitness value per generation.
     * @param bestFitnessPerGen, an ArrayList<Double> with the best fitness value per generation.
     * @param popSize, an int representing the size of the population at the start of the GA.
     * @param poolSize, an int size indicating the size of the selection pool.
     * @param mutationRate, a float indication the percentage of chance a child will mutate.
     *
     */
    public void saveToCSV(int generations, ArrayList<Double> averageFitnessPerGen, ArrayList<Double> bestFitnessPerGen,
                          int popSize, int poolSize, float mutationRate, int run){
        File csvFile = new File(this.filename);
        try(FileWriter fileCSVWriter = new FileWriter(csvFile)) {

            //Create a header
            fileCSVWriter.write("Generation, Average Fitness, Best Fitness, Population Size, Pool Size, " +
                    "Mutation Rate, Run");
            fileCSVWriter.write(System.getProperty("line.separator"));

            int counter=0;
            while(counter<generations){
                //Generation, PopSize, PoolSize, MutationRate,
                fileCSVWriter.write(Integer.toString(counter+1) + "," +
                        Double.toString(averageFitnessPerGen.get(counter)) + "," +
                        Double.toString(bestFitnessPerGen.get(counter)) + "," +
                        Integer.toString(popSize+counter) + "," +
                        Integer.toString(poolSize) + "," +
                        Float.toString(mutationRate) + "," +
                        Integer.toString(run));
                //Next line
                fileCSVWriter.write(System.getProperty("line.separator"));

                counter++;
            }

            fileCSVWriter.close();
        } catch(IOException e){
            System.out.println("Error Occurred Writing To File! " + e.getMessage());
        }
    }


}
