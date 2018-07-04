package ir.fallahpoor.geneticalgorithm;

import java.util.Random;

public class Chromosome {

    public static final int CHROMOSOME_LENGTH = 10;
    private static final int GENE_MAX_VALUE = 9;
    private int[] genes;

    public Chromosome() {
        genes = new int[CHROMOSOME_LENGTH];
    }

    public void setGene(int index, int value) {
        genes[index] = value;
    }

    public int getGene(int index) {
        return genes[index];
    }

    public void generateChromosome() {
        Random random = new Random();
        for (int i = 0; i < Chromosome.CHROMOSOME_LENGTH; i++) {
            int gene = random.nextInt(GENE_MAX_VALUE + 1);
            setGene(i, gene);
        }
    }

    @Override
    public String toString() {

        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < Chromosome.CHROMOSOME_LENGTH; i++) {
            stringBuilder.append(getGene(i));
        }

        return stringBuilder.toString();

    }

}
