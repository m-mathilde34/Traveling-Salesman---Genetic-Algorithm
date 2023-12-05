package ga_testing;

import ga_ts.WritingToFile;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class WritingToFileTest {

    @Test
    void testWritingToFile(){
        int gen = 3;
        int popSize = 10;
        int poolSize = 4;
        float mutationRate = 0.10f;
        ArrayList<Double> averageFitnessPerGen = new ArrayList<>();
        ArrayList<Double> bestFitnessPerGen = new ArrayList<>();

        averageFitnessPerGen.add(1.273924);
        averageFitnessPerGen.add(1.928393);
        averageFitnessPerGen.add(1.354893);

        bestFitnessPerGen.add(1.19293);
        bestFitnessPerGen.add(1.29393);
        bestFitnessPerGen.add(1.23839);

        WritingToFile writingToFile = new WritingToFile("Test.csv");
        writingToFile.saveToCSV(gen, averageFitnessPerGen, bestFitnessPerGen, popSize, poolSize, mutationRate);

    }
}
