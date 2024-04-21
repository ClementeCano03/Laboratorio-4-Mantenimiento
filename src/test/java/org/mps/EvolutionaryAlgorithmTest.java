package org.mps;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.crossover.CrossoverOperator;
import org.mps.crossover.OnePointCrossover;
import org.mps.mutation.MutationOperator;
import org.mps.mutation.SwapMutation;
import org.mps.selection.SelectionOperator;
import org.mps.selection.TournamentSelection;

public class EvolutionaryAlgorithmTest {
    
    @Test
    @DisplayName("El constructor pasándole los parámetros correctos funciona correctamente")
    public void EvolutionaryAlgorithm_CorrectParameters_WorksCorrectly() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = new OnePointCrossover();

        EvolutionaryAlgorithm evolutionary = new EvolutionaryAlgorithm(selection, mutation, crossover);

        assertNotNull(evolutionary.getSelectionOperator());
        assertNotNull(evolutionary.getMutationOperator());
        assertNotNull(evolutionary.getCrossoverOperator());
    }

    @Test
    @DisplayName("Si le pasamos al constructor el parámetro selector con valor null, se lanza una excepción")
    public void EvolutionaryAlgorithm_SelectorIsNull_ThrowsException(){
        SelectionOperator selection = null;
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = new OnePointCrossover();

        assertThrows(EvolutionaryAlgorithmException.class, () -> new EvolutionaryAlgorithm(selection, mutation, crossover));
    }

    @Test
    @DisplayName("Si le pasamos al constructor el parámetro mutation con valor null, se lanza una excepción")
    public void EvolutionaryAlgorithm_MutationIsNull_ThrowsException() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = null;
        CrossoverOperator crossover = new OnePointCrossover();

        assertThrows(EvolutionaryAlgorithmException.class, () -> new EvolutionaryAlgorithm(selection, mutation, crossover));
    }

    @Test
    @DisplayName("Si le pasamos al constructor el parámetro crossover con valor null, se lanza una excepción")
    public void EvolutionaryAlgorithm_CrossoverIsNull_ThrowsException() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = null;

        assertThrows(EvolutionaryAlgorithmException.class, () -> new EvolutionaryAlgorithm(selection, mutation, crossover));
    }

    @Test
    @DisplayName("El método getMutationOperator debe devolver mutation correctamente")
    public void getMutationOperator_ShouldWorksCorrectly_ReturnMutation() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = new OnePointCrossover();
        EvolutionaryAlgorithm evolutionary = new EvolutionaryAlgorithm(selection, mutation, crossover);

        MutationOperator result = evolutionary.getMutationOperator();

        assertEquals(mutation, result);
    }

    @Test
    @DisplayName("El método setMutationOperator debe cambiar el parámetro mutation correctamente")
    public void setMutationOperator_PassingANewMutation_ReturnMutation() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = new OnePointCrossover();
        EvolutionaryAlgorithm evolutionary = new EvolutionaryAlgorithm(selection, mutation, crossover);

        MutationOperator mutation2 = new SwapMutation();
        evolutionary.setMutationOperator(mutation2);
        MutationOperator result = evolutionary.getMutationOperator();

        assertEquals(mutation2, result);
    }
}
