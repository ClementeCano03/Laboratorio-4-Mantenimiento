
/*
 * @author José Antonio Casado Molina
 * @author Manuel Fuentes Vida
 * @author Clemente Cano Mengíbar
 */

package org.mps.mutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.EvolutionaryAlgorithmException;

public class SwapMutationTest {
    @Test
    @DisplayName("Comprobamos que el constructor no devulve un nulo")
    public void swapMutation_Constructor_NotNull() {
        SwapMutation swapMutation = new SwapMutation();
        assertNotNull(swapMutation);
    }

    @Test
    @DisplayName("Si le pasamos un array nulo, deberá lanzar la correspondiente excepción")
    public void  mutate_WithIndividualNull(){
        SwapMutation mutation = new SwapMutation();
        int[] individual = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> mutation.mutate(individual));
    }

    @Test
    @DisplayName("Si le pasamos un array vacío, deberá lanzar la correspondiente excepción")
    public void  mutate_WithLengthZero(){
        SwapMutation mutation = new SwapMutation();
        int[] individual = {};

        assertThrows(EvolutionaryAlgorithmException.class, () -> mutation.mutate(individual));
    }

    @Test
    @DisplayName("Si le pasamos un array no vacío de enteros, deberá devolver verdadero al comparar las longitudes")
    public void  mutate_WorksPropperly() throws EvolutionaryAlgorithmException{
        SwapMutation mutation = new SwapMutation();
        int[] individual = {1,2,3,4,5};

        int[] mutatedIndividual = mutation.mutate(individual);

        assertEquals(individual.length, mutatedIndividual.length);
    }
}
