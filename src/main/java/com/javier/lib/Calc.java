package com.javier.lib;

public class Calc {
    /**
     * Calcula el factorial de un entero.
     *
     * @param n Número del que se desea calcular el factorial.
     * @return Devuelve un entero como factorial de 'n'.
     */
    public static int factorial(int n){
        int resultado = 1;
        if (n<0){
            //No se puede calcular el factorial de números negativos."
            return 0;
        }
        else {
            for (int i = n; i != 0; i--) {
                resultado *=i;
            }
            return resultado;
        }
    }
}
