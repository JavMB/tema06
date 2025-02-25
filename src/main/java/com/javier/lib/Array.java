package com.javier.lib;

public class Array {

    public enum Paridad{
        PAR, IMPAR
    }

//******************************** SOLICITAR DATOS ********************************\\

    /**
     * Solicita al usuario introducir los datos de un array 'double[]'.
     *
     * @param array Array que se desea rellenar.
     */
    public static void solicitarDatosArray(double[] array) {
        solicitarDatosArray(array, Double.MAX_VALUE,Double.MAX_VALUE);
    }

    /**
     * Solicita al usuario introducir los datos de un array 'double[]'.
     *
     * @param array Array que se desea rellenar.
     * @param minimo Valor mínimo que se permite introducir en el array.
     * @param maximo Valor maximo que se permite introducir en el array.
     */
    public static void solicitarDatosArray(double[] array, double minimo, double maximo) {
        double valor;
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            do {
            System.out.printf("a[%d]?\n", i);
            valor = Double.parseDouble(Escaner.lector.nextLine());
            if ((valor<minimo)||(valor>maximo)){
                if (minimo==Double.MIN_VALUE){
                    System.err.printf("El valor no está dentro del rango (%f>x). Introduzca de nuevo el valor: \n",maximo);
                } else if (maximo==Double.MAX_VALUE) {
                    System.err.printf("El valor no está dentro del rango (%f<x). Introduzca de nuevo el valor: \n",minimo);
                } else{
                    System.err.printf("El valor no está dentro del rango (%f - %f). Introduzca de nuevo el valor: \n",minimo, maximo);
                }
            }
            } while ((valor<minimo)||(valor>maximo));

            array[i] = valor;
        }
    }

    /**
     * Solicita al usuario introducir los datos de un array 'char[]'.
     *
     * @param array Array que se desea rellenar.
     */
    public static void solicitarDatosArray(char[] array) {
        if (array == null) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            System.out.printf("a[%d]?\n", i);
            array[i] = Escaner.lector.nextLine().charAt(0);
        }
    }

//******************************** ARRAY TO STRING ********************************\\

    //----------INT----------\\
    /**
     * Convierte a un array 'int[]' a un 'String'.
     *
     * @param array Array que se desea convertir.
     * @return Devuelve un 'String' que contiene el array.
     */
    public static String arrayToString(int[] array) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length -1) { // último elemento
                coma = "";
            }
            sb.append(espacio).append(String.format("%d", array[i])).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //----------DOUBLE----------\\
    /**
     * Convierte a un array 'double[]' a un 'String'.
     *
     * @param array Array que se desea convertir.
     * @param decimales Número de decimales con los que se imprimirán los valores.
     * @return Devuelve un 'String' que contiene el array.
     */
    public static String arrayToString(double[] array, int decimales) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        String espacio = "";
        String coma = ",";
        String formato = "%." + decimales + "f";
        for (int i = 0; i < array.length; i++) {
            if (i == array.length -1) { // último elemento
                coma = "";
            }
            sb.append(espacio).append(String.format(formato, array[i])).append(coma);
            if (i == 0) {
                espacio = " ";
            }
        }
        sb.append("]");
        return sb.toString();
    }

    //----------DOUBLE COMO TABLA----------\\

    /**
     * Convierte a un array 'double[]' a un 'String' en forma de tabla.
     *
     * @param array Array que se desea convertir.
     * @param decimales Número de decimales con los que se imprimirán los valores.
     * @param columnas Número de columas con las que se creará la tabla.
     * @return Devuelve un 'String' que contiene el array.
     */
    public static String arrayToString(double[] array, int decimales, int columnas){
        return arrayToString(array,decimales,columnas,2);
    }

    /**
     * Convierte a un array 'double[]' a un 'String' en forma de tabla.
     *
     * @param array Array que se desea convertir.
     * @param decimales Número de decimales con los que se imprimirán los valores.
     * @param columnas Número de columas con las que se creará la tabla.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene el array.
     */
    public static String arrayToString(double[] array, int decimales, int columnas, int padding) {
        if (array == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int tamanyoColumna = determinarLongitudMaxima(array, decimales) + padding;
        String formato = "%" + tamanyoColumna + "." + decimales + "f";
        String formatoColumna = "%-" + tamanyoColumna + "s";
        for (int i = 0; i < array.length; i++) {
            sb.append(String.format(formatoColumna, String.format(formato, array[i])));
            if ((i + 1) % columnas == 0) {
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    //----------CHAR----------\\
    /**
     * Convierte a un array las posiciones pares o impares de un array 'char[]' a un 'String'
     *
     * @param array Array que se desea convertir.
     * @param paridad Propiedad que determina si se desean sacar los pares o los impares.
     * @return Devuelve un 'String' que contiene las posiciones deseadas del array.
     */
    public static String arrayToString(char[] array, Paridad paridad) {
        StringBuilder sb = new StringBuilder();
        int inicio = paridad == Paridad.PAR ? 0 : 1;
        for (int i = inicio; i < array.length; i += 2) {
            sb.append(array[i]);
        }
        return sb.toString();
    }

//******************************** RELLENAR ALEATORIAMENTE UN ARRAY ********************************\\

    /**
     * Rellena aleatoriamente un array 'double[]' con valores dentro de un rango
     *
     * @param array Array que se desea rellenar.
     * @param valorMinimo Valor mínimo que pueden tener los valores aleatorios.
     * @param valorMaximo Valor máximo que pueden tener los valores aleatorios.
     */
    public static void rellenarArray(double[] array, double valorMinimo, double valorMaximo) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Randim.randomDouble(valorMinimo,valorMaximo);
        }
    }


    /**
     * Rellena aleatoriamente un array 'int[]' con valores dentro de un rango
     *
     * @param array Array que se desea rellenar.
     * @param valorMinimo Valor mínimo que pueden tener los valores aleatorios.
     * @param valorMaximo Valor máximo que pueden tener los valores aleatorios.
     */
    public static void rellenarArray(int[] array, int valorMinimo, int valorMaximo) {
        for (int i = 0; i < array.length; i++) {
            array[i] = Randim.randomInt(valorMinimo,valorMaximo);
        }
    }

    /**
     * Rellena aleatoriamente un array 'double[]' con valores dentro de un rango
     *
     * @param array Array que se desea rellenar.
     * @param caracterMinimo Valor mínimo que pueden tener los valores aleatorios.
     * @param caracterMaximo Valor máximo que pueden tener los valores aleatorios.
     */
    public static void rellenarArray(char[] array, char caracterMinimo, char caracterMaximo) {
        java.util.Random random = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = (char) Randim.randomInt(caracterMinimo, caracterMaximo);
        }
    }

//******************************** MEDIA DEL ARRAY ********************************\\

    /**
     * Calcular la media de todos los valores contenidos en un array 'double[]'.
     *
     * @param array Array sobre el que se desea trabajar.
     * @return Devuelve la media de los valores que contiene el array, devuelve 0 si el array se encuentra vacío.
     */
    public static double mediaArray(double[] array){
        return mediaArray(array, Double.MIN_VALUE, Double.MAX_VALUE);
    }

    /**
     * Calcular la media de los valores contenidos en un array 'double[]' dentro de un rango.
     *
     * @param array Array sobre el que se desea trabajar.
     * @param minimo Valor mínimo 'double' que puede valer para contar en la media.
     * @param maximo Valor máximo 'double' que puede valer para contar en la media.
     * @return Devuelve la media de los valores presentes dentro del rango, devuelve 0 si el array se encuentra vacío.
     */
    public static double mediaArray(double[] array, double minimo, double maximo){
        if (array==null){
            return 0;
        }
        int contador = 0;
        double sumatorio = 0;
        for (double i:array){
            if ((minimo<=i)&&(i<=maximo)){
                sumatorio+=i;
                contador++;
            }
        }

        return sumatorio/contador;
    }

//******************************** CALCULOS VARIOS SOBRE EL ARRAY ********************************\\

    /**
     * Determina la longitud mayor de los indices de un array 'int[]'.
     *
     * @param array Array sobre el que se desea trabajar.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
    public static int determinarLongitudMaxima(int[] array) {
        StringBuilder sb = new StringBuilder();
        int longitudMaxima = 0;
        for (int numero : array) {
            sb.setLength(0);
            sb.append(numero);
            int longitudActual = sb.length();
            if (longitudMaxima < longitudActual) {
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }


    /**
     * Determina la longitud mayor de los indices de un array 'double[]'.
     *
     * @param array Array sobre el que se desea trabajar.
     * @param decimales Número de decimales que se han de tener en cuenta.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
    public static int determinarLongitudMaxima(double[] array, int decimales) {
        int longitudMaxima = 0;
        String formato = "%." + decimales + "f";
        for (double numero : array) {
            int longitudActual = String.format(formato, numero).length();
            if (longitudMaxima < longitudActual) {
                longitudMaxima = longitudActual;
            }
        }
        return longitudMaxima;
    }

    /**
     * Verifica si un número existe dentro de un array 'double[]'.
     *
     * @param array Array sobre el que se desea trabajar.
     * @param numero Número a buscar.
     * @return Devuelve 'true' si el número se encuentra en el array.
     */
    public static boolean verificarNumero(double[] array, double numero){
        for (double i : array) {
            if (numero == i) {
                return true;
            }
        }
        return false;
    }


    /**
     * Cuenta los carácteres pares o impares que contiene un array.
     *
     * @param array Array sobre el que se desea trabajar.
     * @param paridad Propiedad que determina si se desean contar los pares o los impares.
     * @return Devuelve el número entero de pares o impares que contiene el array.
     */
    public static int contarParesOImpares(int[] array, Paridad paridad){
        if (array==null){
            System.err.println("ERROR: Array vacio.");
            return -1;
        }
        int contador=0;
        for (int i= paridad == Paridad.PAR ? 0 : 1;i<array.length;i++){
            if (array[i] % 2==0){
                contador++;
            }
        }
        return contador;
    }
}
