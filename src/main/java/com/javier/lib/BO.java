package com.javier.lib;

public class BO {
    //******************************** BUSQUEDA ********************************\\
    //----------Busqueda lineal en un array no ordenado----------\\
    //----------Busqueda lineal en un array ordenado----------\\
    //----------Busqueda binaria----------\\
    //******************************** ORDENACIÓN ********************************\\
    //----------Burbuja----------\\
    //----------Inserción----------\\
    public static void ordenaInsercion(int[] array){
        int aux;
        for (int i = 0; i < array.length; i++) {
            aux = array[i];
            for (int j = i-1; j >= 0; j--) {
                if (array[j]>aux){
                    array[j+1]= array[j];
                }
            }
        }
    }

    //----------Selección----------\\
    public static void ordenaSeleccion(int[] array){
        int min;
        for (int i = 0; i < array.length; i++) {
            min = array[i];
            int posicion=i;
            for (int j = i; j < array.length; j++) {
                if (array[j]<min){
                    min = array[j];
                    posicion = j;
                }
            }
            if (min<array[i]){
                //intercambio(array, i, posicion);
            }
        }
    }
    //----------Counting sort----------\\
    public static void ordenaContando(int[] array){
        final int DISTANCIA_MAXIMA=100000;
        ArrayEstadisticas arrayEstadisticas = new ArrayEstadisticas(array);
        int min = arrayEstadisticas.getMin();
        int max = arrayEstadisticas.getMax();
        if (max-min+1>DISTANCIA_MAXIMA){
            System.err.println("Hay demasiada dispersión en los datos.");
            return;
        }
        int[] arrayConteo = new int[max + 1];

        for (int k : array) {
            arrayConteo[k]++;
        }
        System.out.println("Conteo: ");

        int contador = 0;
        for (int i = 0; i < array.length; i++) {
            int cantidad = arrayConteo[i];
            for (int j = 0; j < cantidad; j++) {
                array[contador++] = i;
            }
        }
    }
}
