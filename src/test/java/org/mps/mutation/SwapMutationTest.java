
/*
 * @author José Antonio Casado Molina
 * @author Manuel Fuentes Vida
 * @author Clemente Cano Mengíbar
 */

package org.mps.mutation;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mps.EvolutionaryAlgorithmException;

public class SwapMutationTest {
    
    @Test
    public void  mutate_WithIndividualNull(){
        SwapMutation mutation = new SwapMutation();
        int[] individual = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> mutation.mutate(individual));
    }

    @Test
    public void  mutate_WithLengthZero(){
        SwapMutation mutation = new SwapMutation();
        int[] individual = {};

        assertThrows(EvolutionaryAlgorithmException.class, () -> mutation.mutate(individual));
    }

    @Test
    public void  mutate_WorksPropperly() throws EvolutionaryAlgorithmException{
        SwapMutation mutation = new SwapMutation();
        int[] individual = {1,2,3,4,5};

        int[] mutatedIndividual = mutation.mutate(individual);

        assertEquals(individual.length, mutatedIndividual.length);
    }
}
