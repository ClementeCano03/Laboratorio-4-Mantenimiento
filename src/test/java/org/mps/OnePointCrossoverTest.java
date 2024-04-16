package org.mps;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.crossover.OnePointCrossover;

public class OnePointCrossoverTest {
    
    @Test
    @DisplayName("Si el primer padre que se le pasa a crossover es null, lanza una excepción")
    public void crossover_WithParent1Null() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = null;
        int[] parent2 = {1,2,3,4,5};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }

    @Test
    @DisplayName("Si el segundo padre que se le pasa a crossover es null, lanza una excepción")
    public void crossover_WithParent2Null() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {1,2,3,4,5};
        int[] parent2 = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }


    @Test
    @DisplayName("Si el primer padre que se le pasa a crossover está vacío, lanza una excepción")
    public void crossover_WithParent1Empty() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {};
        int[] parent2 = {1,2,3,4,5};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }

    @Test
    @DisplayName("Si el segundo padre que se le pasa a crossover no tiene la misma longitud que el primero, lanza una excepción")
    public void crossover_Parent2NotHaveTheSameLength() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {1,2,3,4,5};
        int[] parent2 = {1,2};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }
}
