package ir.fallahpoor.geneticalgorithm;

public class GeneticAlgorithm {

    public static final int[] SOLUTION = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
    public static final int POPULATION_SIZE = 100;
    public static final double CROSSOVER_RATE = 0.5;
    public static final int TOURNAMENT_SIZE = 5;
    public static final int MAX_FITNESS = 10;
    public static final int MAX_GENERATIONS = 100;

    public void run() {

        Population population = new Population(POPULATION_SIZE);
        int generationCounter = 1;

        while (population.getFittestIndividual().getFitness() != MAX_FITNESS && generationCounter <= MAX_GENERATIONS) {
            population = evolvePopulation(population);
            printInfo(population, generationCounter);
            generationCounter++;
        }

        System.out.println("Best solution = " + population.getFittestIndividual() +
                ", Fitness = " + population.getFittestIndividual().getFitness());

    }

    private Population evolvePopulation(Population population) {

        Population newPopulation = new Population(population.getSize());

        crossover(population, newPopulation);

        mutate(newPopulation);

        return newPopulation;

    }

    private void crossover(Population population, Population newPopulation) {
        for (int i = 0; i < population.getSize(); i++) {
            Individual firstIndividual = naturalSelection(population);
            Individual secondIndividual = naturalSelection(population);
            Individual newIndividual = crossover(firstIndividual, secondIndividual);
            newPopulation.setIndividual(i, newIndividual);
        }
    }

    private Individual naturalSelection(Population population) {

        Population newPopulation = new Population(TOURNAMENT_SIZE);

        for (int i = 0; i < TOURNAMENT_SIZE; i++) {
            int randomIndex = (int) (Math.random() * population.getSize());
            newPopulation.setIndividual(i, population.getIndividual(randomIndex));
        }

        return newPopulation.getFittestIndividual();

    }

    private Individual crossover(Individual firstIndividual, Individual secondIndividual) {

        Individual newSolution = new Individual();

        for (int i = 0; i < Chromosome.CHROMOSOME_LENGTH; i++) {
            if (Math.random() <= CROSSOVER_RATE) {
                newSolution.setGene(i, firstIndividual.getGene(i));
            } else {
                newSolution.setGene(i, secondIndividual.getGene(i));
            }
        }

        return newSolution;

    }

    private void mutate(Population newPopulation) {
        for (int i = 0; i < newPopulation.getSize(); i++) {
            newPopulation.getIndividual(i).mutate();
        }
    }

    private void printInfo(Population population, int generationCounter) {
        System.out.println("#" + generationCounter +
                ": Best solution = " + population.getFittestIndividual() +
                ", Fitness = " + population.getFittestIndividual().getFitness() + "\n");
    }

}
