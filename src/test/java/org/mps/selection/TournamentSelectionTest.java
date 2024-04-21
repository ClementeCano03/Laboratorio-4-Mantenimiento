
/*
 * @author José Antonio Casado Molina
 * @author Manuel Fuentes Vida
 * @author Clemente Cano Mengíbar
 */

package org.mps.selection;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mps.EvolutionaryAlgorithmException;

public class TournamentSelectionTest{

    @Test
    @DisplayName("Si le pasamos como parámetro de entrada un número menor que 0, lanza una excepción")
    public void constructor_WithNonCorrectParam_ThrowsException() throws EvolutionaryAlgorithmException{
        assertThrows(EvolutionaryAlgorithmException.class, () -> new TournamentSelection(0));

    }
    
    @Test
    @DisplayName("Introducimos como parametro uno nulo")
    public void select_NullParameter_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);

        int[] poblation = null;
        assertThrows(EvolutionaryAlgorithmException.class, () -> tournamentSelection.select(poblation)) ;
    }

    @Test
    @DisplayName("Introducimos como parametro uno de tamaño 0")
    public void select_LenghtZero_ThrowsException() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);

        int[] poblation = {};
        assertThrows(EvolutionaryAlgorithmException.class, () -> tournamentSelection.select(poblation)) ;
    }

    @Test
    @DisplayName("Introducimos datos correctos para comprobar que funciona correctamente")
    public void select_CorrectParam_WorksProperly() throws EvolutionaryAlgorithmException{
        TournamentSelection tournamentSelection = new TournamentSelection(10);

        int[] poblation = {1,2,3,4,5,6,7};
        int[] selected = tournamentSelection.select(poblation);
        
        assertEquals(7, selected.length);
    }

    
      
}