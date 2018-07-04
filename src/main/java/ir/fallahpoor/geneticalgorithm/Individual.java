package ir.fallahpoor.geneticalgorithm;

import java.util.Random;

public class Individual {

    private static final double MUTATION_RATE = 0.15;
    private Chromosome chromosome;
    private int fitness = 0;

    public Individual() {
        chromosome = new Chromosome();
    }

    public void generateIndividual() {
        chromosome.generateChromosome();
    }

    public int getFitness() {

        if (fitness == 0) {

            for (int i = 0; i < Chromosome.CHROMOSOME_LENGTH; ++i) {
                if (getGene(i) == GeneticAlgorithm.SOLUTION[i]) {
                    this.fitness++;
                }
            }

        }

        return fitness;

    }

    public int getGene(int index) {
        return chromosome.getGene(index);
    }

    public void setGene(int index, int value) {
        chromosome.setGene(index, value);
        this.fitness = 0;
    }

    public void mutate() {

        for (int i = 0; i < Chromosome.CHROMOSOME_LENGTH; i++) {
            if (Math.random() <= MUTATION_RATE) {
                swapGenes();
            }
        }

    }

    private void swapGenes() {

        Random random = new Random();

        int randomIndex1 = random.nextInt(Chromosome.CHROMOSOME_LENGTH);
        int randomIndex2 = random.nextInt(Chromosome.CHROMOSOME_LENGTH);

        int gene1 = getGene(randomIndex1);
        int gene2 = getGene(randomIndex2);

        setGene(randomIndex1, gene2);
        setGene(randomIndex2, gene1);

    }

    @Override
    public String toString() {
        return chromosome.toString();
    }

}
