
/*
 * @author José Antonio Casado Molina
 * @author Manuel Fuentes Vida
 * @author Clemente Cano Mengíbar
 */

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

    

    @Test
    @DisplayName("Optimize lanza una excepción si la poblacion es nula")
    public void optimize_PopulationNull_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);

        int[][] population = null;
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> evolutionaryAlgorithm.optimize(population));
    }

    @Test
    @DisplayName("Optimize lanza una excepción si la poblacion tiene tamaño 0")
    public void optimize_PopulationNoSize_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);

        int[][] population = {};
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> evolutionaryAlgorithm.optimize(population));
    }

    @Test
    @DisplayName("Optimize lanza una excepción si el primer elemento es nulo")
    public void optimize_PopulationFirstElementNull_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);
        
        int[][] population = {
            null,
            {4,5,6},
            {7,8,9}
        }; 
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> evolutionaryAlgorithm.optimize(population));
    }

    @Test
    @DisplayName("Optimize lanza una excepción si el primer elemento tiene size menor o igual a 0")
    public void optimize_PopulationFirstElementSize0_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);
        int[][] population = {
            {},
            {4,5,6},
            {7,8,9}
        };
        
        assertThrows(EvolutionaryAlgorithmException.class, () -> evolutionaryAlgorithm.optimize(population));
    }

    @Test
    @DisplayName("Optimize con los parámetros adecuados funciona correctamente")
    public void optimize_CorrectParameters_WorksProperly() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);
        int[][] population = {
            {1,2,3},
            {4,5,6},
            {7,8,9}
        };
        
        assertEquals(population.length, evolutionaryAlgorithm.optimize(population).length);
    }

    @Test
    @DisplayName("El método getSelectionOperator devuelve un objeto SelectionOperator correctamente")
    public void getSelectionOperator_WorksProperly_ReturnObjectSelectionOperator() throws EvolutionaryAlgorithmException{
        SelectionOperator selection = new TournamentSelection(10);
        MutationOperator mutation = new SwapMutation();
        CrossoverOperator crossover = new OnePointCrossover();
        EvolutionaryAlgorithm evolutionary = new EvolutionaryAlgorithm(selection, mutation, crossover);

        SelectionOperator result = evolutionary.getSelectionOperator();

        assertEquals(selection, result);
    }

    @Test
    @DisplayName("El método setSelectionOperator cambia un objeto SelectionOperator correctamente")
    public void setSelectionOperator_WorksProperly_returnObjectSelectionOperator() throws EvolutionaryAlgorithmException{
        SelectionOperator tournamentSelection = new TournamentSelection(10);
        SelectionOperator tournamentSelection2 = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);

        evolutionaryAlgorithm.setSelectionOperator(tournamentSelection2);

        assertEquals(tournamentSelection2, evolutionaryAlgorithm.getSelectionOperator());
    }
    
    @Test
    @DisplayName("El método getCrossoverOperator devuelve un objeto CrossoverOperator correctamente")
    public void getCrossoverOperator_worksProperly_returnObjectCrossoverOperator() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);

        assertEquals(onePointCrossover, evolutionaryAlgorithm.getCrossoverOperator());
    }

    @Test
    @DisplayName("El método setCrossoverOperator cambia un objeto CrossoverOperator correctamente")
    public void setCrossoverOperator_WorksProperly_ReturnObjectCrossoverOperator() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);
        OnePointCrossover onePointCrossover = new OnePointCrossover();
        OnePointCrossover onePointCrossover2 = new OnePointCrossover();
        SwapMutation swapMutation = new SwapMutation();

        EvolutionaryAlgorithm evolutionaryAlgorithm = new EvolutionaryAlgorithm(tournamentSelection, swapMutation, onePointCrossover);

        evolutionaryAlgorithm.setCrossoverOperator(onePointCrossover2);

        assertEquals(onePointCrossover2, evolutionaryAlgorithm.getCrossoverOperator());
    }
    
}


