
/*
 * @author José Antonio Casado Molina
 * @author Manuel Fuentes Vida
 * @author Clemente Cano Mengíbar
 */

package org.mps.crossover;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.EvolutionaryAlgorithmException;

public class OnePointCrossoverTest {
    
    @Test
    @DisplayName("El constructor funciona correctamente")
    public void onePointCrossover_CallingTheConstructor_WorksCorrectly(){
        CrossoverOperator crossover = new OnePointCrossover();

        assertNotNull(crossover);
    }

    @Test
    @DisplayName("Si el primer padre que se le pasa a crossover es null, lanza una excepción")
    public void crossover_WithParent1Null_ThrowsException() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = null;
        int[] parent2 = {1,2,3,4,5};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }

    @Test
    @DisplayName("Si el segundo padre que se le pasa a crossover es null, lanza una excepción")
    public void crossover_WithParent2Null_ThrowsException() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {1,2,3,4,5};
        int[] parent2 = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }


    @Test
    @DisplayName("Si el primer padre que se le pasa a crossover está vacío, lanza una excepción")
    public void crossover_WithParent1Empty_ThrowsException() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {};
        int[] parent2 = {1,2,3,4,5};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }

    @Test
    @DisplayName("Si el segundo padre que se le pasa a crossover no tiene la misma longitud que el primero, lanza una excepción")
    public void crossover_Parent2NotHaveTheSameLength_ThrowsException() {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {1,2,3,4,5};
        int[] parent2 = {1,2};

        assertThrows(EvolutionaryAlgorithmException.class, () -> crossover.crossover(parent1, parent2));
    }

    @Test
    @DisplayName("Si todos los parámetros son correctos, crossover funciona correctamente")
    public void crossover_BothParentsCorrect_returnOffspring() throws EvolutionaryAlgorithmException {
        OnePointCrossover crossover = new OnePointCrossover();
        int[] parent1 = {1,2,3,4,5};
        int[] parent2 = {1,2,3,4,5};

        int [][] result = crossover.crossover(parent1, parent2);

        assertEquals(2, result.length);
        for(int i = 0; i < result.length; i++){
            assertEquals(parent1.length, result[i].length);
        }
    }
}
