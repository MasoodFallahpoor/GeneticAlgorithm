package ir.fallahpoor.geneticalgorithm;

public class Population {

    private Individual[] individuals;

    public Population(int populationSize) {
        individuals = new Individual[populationSize];
        initialize();
    }

    private void initialize() {
        for (int i = 0; i < getSize(); i++) {
            Individual newIndividual = new Individual();
            newIndividual.generateIndividual();
            setIndividual(i, newIndividual);
        }
    }

    public Individual getIndividual(int index) {
        return this.individuals[index];
    }

    public void setIndividual(int index, Individual individual) {
        this.individuals[index] = individual;
    }

    public Individual getFittestIndividual() {

        Individual fittestIndividual = individuals[0];

        for (Individual individual : individuals) {
            if (fittestIndividual.getFitness() <= individual.getFitness()) {
                fittestIndividual = individual;
            }
        }

        return fittestIndividual;

    }

    public int getSize() {
        return this.individuals.length;
    }

}
