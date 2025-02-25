
import com.javier.tests.ProcesadorNumeros;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProcesadorNumerosTest {

    private ProcesadorNumeros procesador;


    //con esto cada prueba empezara con una nueva instancia de ProcesadorNumeros
    @BeforeEach
    void setUp() {
        procesador = new ProcesadorNumeros();
    }

    @Nested
    class CajaBlanca {
        //caja blanca (CASOS MINIMOS)
        @Test
        void testEsPrimoTodasLasRutas() {
            assertFalse(procesador.esPrimo(1));  //  Caso n < 2 → Debe retornar false
            assertTrue(procesador.esPrimo(2));   //  no entra al bucle: 2 es primo → Retorna true
            assertFalse(procesador.esPrimo(4));  //  entra al bucle  → Retorna false
            assertTrue(procesador.esPrimo(7));   //  entra al bucle→ Retorna true
        }

        @Test
        void testFactorialTodasLasRutas() {
            assertThrows(IllegalArgumentException.class, () -> procesador.factorial(-3));
            assertEquals(1, procesador.factorial(0));
            assertEquals(2, procesador.factorial(2));
        }

        @Test
        void testContarParesTodasLasRutas() {
            assertThrows(IllegalArgumentException.class, () -> procesador.contarPares(null));
            assertEquals(1, procesador.contarPares(new int[]{})); // el codigo funciona pero esta mal , eso lo detecto en caja negra
            assertEquals(1, procesador.contarPares(new int[]{1})); // entra al bucle
            assertEquals(2, procesador.contarPares(new int[]{2})); // entra al bucle

            //no multiples en caja blanca , en negra si , es lo mismo con 1 que con 50.

        }

        @Test
        void testEncontrarMaximoTodasLasRutas() {
            assertThrows(IllegalArgumentException.class, () -> procesador.encontrarMaximo(null));// se prueba la misma ruta que vacia
            assertEquals(0, procesador.encontrarMaximo(new int[]{-1}));
            /*
             Ruta entra el bucle y no es mayor que el maximo, da igual que este mal codigo es codigo.
            Aqui estoy probando solo el codigo aunque este mal, entonces o se hacen dos clases para caja blanca o negra
            o se usa @Nest para que este en un solo archivo , como lo pedias, porque si no se interfieren las pruebas y falla el test.
             */

            assertEquals(1, procesador.encontrarMaximo(new int[]{1})); // entra al bucle y es mayor que int maximo

            //No multiples no es estrictamente necesario
        }

        @Test
        void testEsPalindromoTodasLasRutas() {
            assertFalse(procesador.esPalindromo(-1)); // no pasa del if
            assertTrue(procesador.esPalindromo(0)); // pasa el if pero no entra al bucle entonces 0==0
            assertTrue(procesador.esPalindromo(1)); // entra al bucle y es palindrome
            assertFalse(procesador.esPalindromo(12)); // entra al bucle y no es palindrome

            //no necesito mas en caja blanca , cubros los casos ya aunque no ponga cosas como 1221
        }

    }

    //  Caja negra
    @Nested
    class CajaNegra {
        @Test
        void testEsPrimoValoresNormales() { //corregido ya
            assertFalse(procesador.esPrimo(0));  // 0 no es primo
            assertFalse(procesador.esPrimo(1));  // 1 no es primo
            assertTrue(procesador.esPrimo(2));   // 2 es primo (único primo par)
            assertTrue(procesador.esPrimo(3));   // 3 es primo
            assertFalse(procesador.esPrimo(4));  // 4 no es primo
            assertTrue(procesador.esPrimo(5));   // 5 es primo
        }

        @Test
        void testFactorialValoresNormales() {
            assertEquals(1, procesador.factorial(0)); // 0! = 1
            assertEquals(1, procesador.factorial(1)); // 1! = 1
            assertEquals(2, procesador.factorial(2)); // 2! = 2
            assertEquals(6, procesador.factorial(3)); // 3! = 6
        }

        @Test
        void testContarParesValoresNormales() {
            assertEquals(0, procesador.contarPares(new int[]{1, 3, 5})); // Solo impares
            assertEquals(1, procesador.contarPares(new int[]{2, 3, 5})); // Un par
            assertEquals(2, procesador.contarPares(new int[]{2, 4, 5})); // Dos pares
        }

        @Test
        void testEncontrarMaximoValoresNormales() {
            assertEquals(10, procesador.encontrarMaximo(new int[]{1, 10, 5})); // Máximo en el medio
            assertEquals(20, procesador.encontrarMaximo(new int[]{1, 10, 20})); // Máximo al final
            assertEquals(-1, procesador.encontrarMaximo(new int[]{-10, -5, -1})); // con este detectamos el error que tiene el metodo con el maximo, ya corregido.
        }

        @Test
        void testEsPalindromoValoresNormales() {
            assertTrue(procesador.esPalindromo(0)); // 0 es palíndromo
            assertTrue(procesador.esPalindromo(121)); // 121 es palíndromo
            assertTrue(procesador.esPalindromo(1221)); // 1221 es palíndromo
            assertFalse(procesador.esPalindromo(123)); // 123 no es palíndromo
        }

        //  PRUEBAS DE LÍMITES para ver si desbordan nuestros metodos


        @Test
            //Error el en codigo para manejar desbordamientos  añado throw new ArithmeticException("Desbordamiento en el factorial");
        void testFactorialValoresLimite() {
            assertThrows(IllegalArgumentException.class, () -> procesador.factorial(Integer.MIN_VALUE)); // probamos factorial del minimo negativo
            assertThrows(ArithmeticException.class, () -> procesador.factorial(50)); // probamos un factorial grande para ver si desborda
        }

        @Test
        void testEncontrarMaximoValoresLimite() {
            assertEquals(Integer.MAX_VALUE, procesador.encontrarMaximo(new int[]{Integer.MIN_VALUE, Integer.MAX_VALUE})); // probamos el maximo entero
        }

        @Test
        void testEsPrimoValoresLimite() {
            assertFalse(procesador.esPrimo(Integer.MIN_VALUE));
            assertFalse(procesador.esPrimo(0));
            assertFalse(procesador.esPrimo(1));
            assertTrue(procesador.esPrimo(Integer.MAX_VALUE)); // es primo
        }

        @Test
        void testContarParesValoresLimite() {
            assertEquals(3, procesador.contarPares(new int[]{Integer.MIN_VALUE, 0, Integer.MAX_VALUE - 1})); // Todos pares
        }

        @Test
        void testEsPalindromoValoresLimite() {
            assertFalse(procesador.esPalindromo(Integer.MIN_VALUE));
            assertTrue(procesador.esPalindromo(1223221));
        }
    }


}






