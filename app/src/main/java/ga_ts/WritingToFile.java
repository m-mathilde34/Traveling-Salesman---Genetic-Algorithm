package ga_ts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritingToFile {

    public String filename;

    /**
     * Constructor.
     * @param filename, a string to be used in the name of our CSV file.
     *
     */
    public WritingToFile(String filename){
        this.filename = filename;
    }

    /**
     * Method to save GA results to CSV files. One File saves the run results, the other saves the specific parameters
     * of the GA. Both are linked by a primary key: an unique ID.
     * @param uniqueID, a unique ID (primary key) linking CSV files between them.
     * @param generations, the total number of generations the GA will run for.
     * @param averageFitnessPerGen, an ArrayList<Double> with the average fitness value per generation.
     * @param bestFitnessPerGen, an ArrayList<Double> with the best fitness value per generation.
     * @param popSize, an int representing the size of the population at the start of the GA.
     * @param poolSize, an int size indicating the size of the selection pool.
     * @param mutationRate, a float indication the percentage of chance a child will mutate.
     * @param run, an int representing the number of times the GA runs on specific parameters.
     *
     */
    public void saveToCSV(int uniqueID, int generations, ArrayList<Double> averageFitnessPerGen,
                          ArrayList<Double> bestFitnessPerGen, int popSize, int poolSize, float mutationRate, int run){
        saveRunResults(uniqueID, generations, averageFitnessPerGen, bestFitnessPerGen);
        saveGAParameters(uniqueID, generations, popSize, poolSize, mutationRate, run);
    }

    public void saveRunResults(int uniqueID, int generations, ArrayList<Double> averageFitnessPerGen,
                               ArrayList<Double> bestFitnessPerGen){
        String file = "results/" + Integer.toString(uniqueID) + "_" + this.filename + "_Results.csv";
        File csvFile = new File(file);
        try(FileWriter fileCSVWriter = new FileWriter(csvFile)) {

            //Create a header
            fileCSVWriter.write("Unique ID, Generation, Average Fitness, Best Fitness");
            fileCSVWriter.write(System.getProperty("line.separator"));

            int counter=0;
            while(counter<generations){
                fileCSVWriter.write(Integer.toString(uniqueID) + "," +
                        Integer.toString(counter+1) + "," +
                        Double.toString(averageFitnessPerGen.get(counter)) + "," +
                        Double.toString(bestFitnessPerGen.get(counter)));
                //Next line
                fileCSVWriter.write(System.getProperty("line.separator"));

                counter++;
            }

            fileCSVWriter.close();
        } catch(IOException e){
            System.out.println("Error Occurred Writing To File! " + e.getMessage());
        }
    }

    public void saveGAParameters(int uniqueID, int generations, int popSize, int poolSize, float mutationRate, int run){
        String file = "results/" + Integer.toString(uniqueID) + "_" + this.filename + "_Parameters.csv";
        File csvFile = new File(file);
        try(FileWriter fileCSVWriter = new FileWriter(csvFile)) {

            //Create a header
            fileCSVWriter.write("Unique ID, Starting Pop Size, Pool Size, Mutation Rate, Run");
            fileCSVWriter.write(System.getProperty("line.separator"));

            int counter=0;
            while(counter<generations){
                fileCSVWriter.write(Integer.toString(uniqueID) + "," +
                        Integer.toString(popSize) + "," +
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
