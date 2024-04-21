package org.mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.mps.mutation.SwapMutation;

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
