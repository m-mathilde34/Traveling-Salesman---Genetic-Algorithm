package ga_ts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class WritingToFile {

    public String filename;

    public WritingToFile(String filename){
        this.filename = filename;
    }

    public void saveToCSV(int generations, ArrayList<Double> averageFitnessPerGen, ArrayList<Double> bestFitnessPerGen,
                          int popSize, int poolSize, float mutationRate){
        File csvFile = new File(this.filename);
        try(FileWriter fileCSVWriter = new FileWriter(csvFile)) {

            //Create a header
            fileCSVWriter.write("Generation, Average Fitness, Best Fitness, Population Size, Pool Size, Mutation Rate");
            fileCSVWriter.write(System.getProperty("line.separator"));

            int counter=0;
            while(counter<generations){
                //Generation, PopSize, PoolSize, MutationRate,
                fileCSVWriter.write(Integer.toString(counter+1) + "," +
                        Double.toString(averageFitnessPerGen.get(counter)) + "," +
                        Double.toString(bestFitnessPerGen.get(counter)) + "," +
                        Integer.toString(popSize) + "," +
                        Integer.toString(poolSize) + "," +
                        Float.toString(mutationRate));
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
