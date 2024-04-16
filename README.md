# Laboratorio-4-Mantenimiento

La clase EvolutionaryAlgorithm.java representa un algoritmo evolutivo que se utiliza para resolver problemas de optimización. Un ejemplo de problema de optimización es encontrar el tiempo mínimo de carga de un coche eléctrico atendiendo a la capacidad de la red eléctrica y la carga de otros coches. 
La optimización es usada hoy en día en una amplio abanico de sectores. Este algoritmo se basa en el proceso de evolución biológica y sigue una serie de pasos para mejorar progresivamente una población de soluciones candidatas. En concreto, el proceso de optimización se realiza en varias etapas:
  1. Selección: Se seleccionan las soluciones más aptas para ser utilizadas como progenitores en la próxima generación. Esto se realiza mediante operadores de selección como la selección de torneo, etc.
  2. Cruce (crossover): Se aplican operadores de cruce a los progenitores seleccionados para generar una nueva población de descendientes. Esto implica la combinación de características de dos o más soluciones  candidatas para producir nuevas soluciones.
  3. Mutación: Ocasionalmente, se aplican operadores de mutación a los descendientes generados para introducir variabilidad en la población y evitar la convergencia prematura hacia un óptimo local.
  4. Reemplazo: Los descendientes reemplazan a una parte de la población anterior.

El objetivo es: realizar pruebas de caja blanca de un algoritmo de evolución proporcionado con el objetivo de evaluar todas las ramas por las que pasa el código (sin importar la cobertura de línea). La cobertura de ramas también será necesaria para las clases auxiliares del algoritmo evolution, que son el cruce, mutación y selección de candidatos. Además, algunas veces se ha generado un error en el método optimize de la clase EvolutionaryAlgorithm, pero actualmente se desconoce el motivo y con qué parámetros sucedió. Intenta reproducir el error y solucionar el problema.
