package com.javier.lib;

public class Matriz {

//******************************** RELLENAR ALEATORIAMENTE UNA MATRIZ ********************************\\

//----------INT----------\\

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @return Devuelve una matriz aleatoria.
     */
    public static int[][] crearMatrizAleatoria(int filas, int columnas){
        return crearMatrizAleatoria(filas, columnas,Integer.MIN_VALUE,Integer.MAX_VALUE);
    }

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas, con valores enteros dentro de un rango.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @param minimo Valor mínimo que puede contener la matriz.
     * @param maximo Valor máximo que puede contener la matriz.
     * @return Devuelve una matriz que contiene los valores aleatorios comprendidos en el rango.
     */
    public static int[][] crearMatrizAleatoria(int filas, int columnas, int minimo, int maximo){
        int[][] matriz = new int[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]= Randim.randomInt(minimo,maximo);
            }
        }
        return matriz;
    }

//----------DOUBLE----------\\

    /**
     * Crear una matriz aleatoria de las filas y columnas indicadas, con valores decimales dentro de un rango.
     *
     * @param filas Filas que ha de tener la matriz.
     * @param columnas Columnas que ha de tener la matriz.
     * @param minimo Valor mínimo que puede contener la matriz.
     * @param maximo Valor máximo que puede contener la matriz.
     * @return Devuelve una matriz que contiene los valores aleatorios comprendidos en el rango.
     */
    public static double[][] crearMatrizAleatoria(int filas, int columnas, double minimo, double maximo){
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                matriz[i][j]= Randim.randomDouble(minimo,maximo);
            }
        }
        return matriz;
    }

//******************************** MATRIZ TO STRING ********************************\\

//----------INT----------\\

    /**
     * Convierte a una matriz 'int[][]' a un 'String'.
     *
     * @param matriz Matriz que se desea convertir.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene la matriz.
     */
    public static String matrizToString(int[][] matriz, int padding){
        return matrizToString(matriz, padding, false, false);
    }

    /**
     * Convierte a una matriz 'int[][]' a un 'String'.
     *
     * @param matriz Matriz que se desea convertir.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene la matriz.
     */
    public static String matrizToString(int[][] matriz, int padding, boolean imprimirSumaFilas, boolean imprimirSumaColumnas){
        final int ANCHO_COLUMNA = determinarLongitudMaxima(matriz);
        String formatoPadding = "%"+(ANCHO_COLUMNA+padding)+"s";
        StringBuilder sb = new StringBuilder();
        int sumatorioFila;
        int sumatorioColumna;

        for (int[] fila : matriz){
            sumatorioFila=0;
            for (double valor : fila){
                sumatorioFila+=(int) valor;
                sb.append(String.format(formatoPadding, String.format("%.0f",valor)));
            }
            if (imprimirSumaFilas) {
                sb.append(" = ").append(sumatorioFila);
            }
            sb.append("\n");
        }
        if (imprimirSumaColumnas){

            sb.append(String.format(formatoPadding, "\"").repeat(matriz[1].length));
            sb.append("\n");
            matriz = transpuesta(matriz);
            for (int[] fila : matriz){
                sumatorioColumna=0;
                for (double valor : fila){
                    sumatorioColumna+=(int) valor;
                }
                sb.append(String.format(formatoPadding, String.format("%d",sumatorioColumna)));
            }
        }
        return sb.toString();
    }

//----------DOUBLE----------\\

    /**
     * Convierte a una matriz 'double[][]' a un 'String'.
     *
     * @param matriz Matriz que se desea convertir.
     * @param decimales Número de decimales con los que se imprimirán los valores.
     * @param padding Espacios en blanco que se dejan como margen.
     * @return Devuelve un 'String' que contiene la matriz.
     */
    public static String matrizToString(double[][] matriz, int decimales, int padding){
        int anchoColumna = determinarLongitudMaxima(matriz,decimales);
        String formatoDecimales = "%"+anchoColumna+"."+decimales+"f";
        String formatoPadding = "%"+(anchoColumna+padding)+"s";
        StringBuilder sb = new StringBuilder();
        for (double[] fila : matriz){
            for (double valor : fila){
                sb.append(String.format(formatoPadding, String.format(formatoDecimales,valor)));
            }
            sb.append("\n");
        }
        return sb.toString();
    }


//******************************** ELEMENTO TO STRING ********************************\\

    /**
     * Extraer un elemento de la fila y columna seleccionada de una matriz.
     *
     * @param matriz Matriz sobre la que extraer.
     * @param fila Fila donde se encuentra el elemento.
     * @param columna Columna donde se encuentra el elemento.
     * @return Devuelve el 'int' que se encuentra en matriz[fila][columna].
     */
    public static String elementoToString(int[][] matriz, int fila, int columna){
        return String.valueOf(matriz[fila][columna]);
    }


//******************************** EXTRAER DE MATRIZ ********************************\\
    /**
     * Extraer una fila seleccionada de una matriz.
     *
     * @param matriz Matriz sobre la que extraer.
     * @param fila Fila que extraer.
     * @return Devuelve la fila 'int[]' seleccionada de la matriz.
     */
    public static int[] extraerFila(int[][] matriz, int fila){
        final int COLUMNAS = matriz[fila].length;
        int[] solicitud = new int[COLUMNAS];
        System.arraycopy(matriz[fila], 0, solicitud, 0, COLUMNAS);
        return solicitud;
    }

    /**
     * Extraer una columna seleccionada de una matriz.
     *
     * @param matriz Matriz sobre la que extraer.
     * @param columna Columna que extraer.
     * @return Devuelve la columna 'int[]' seleccionada de la matriz.
     */
    public static int[] extraerColumna(int[][] matriz, int columna){
        return extraerFila(transpuesta(matriz),columna);
    }


    /**
     * Extraer una fila seleccionada de una matriz.
     *
     * @param matriz Matriz sobre la que extraer.
     * @param fila Fila que extraer.
     * @return Devuelve la fila 'double[]' seleccionada de la matriz.
     */
    public static String[] extraerFila(String[][] matriz, int fila){
        final int COLUMNAS = matriz[fila].length;
        String[] solicitud = new String[COLUMNAS];
        System.arraycopy(matriz[fila], 0, solicitud, 0, COLUMNAS);
        return solicitud;
    }

    /**
     * Extraer una columna seleccionada de una matriz.
     *
     * @param matriz Matriz sobre la que extraer.
     * @param columna Columna que extraer.
     * @return Devuelve la columna 'double[]' seleccionada de la matriz.
     */
    public static String[] extraerColumna(String[][] matriz, int columna){
        return extraerFila(transpuesta(matriz),columna);
    }

//******************************** DETERMINAR LONGITUD MÁXIMA ********************************\\

//----------INT----------\\

    /**
     * Determina la longitud mayor de los indices de una matriz 'int[][]'.
     *
     * @param matriz Matriz sobre la que se desea trabajar.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
    public static int determinarLongitudMaxima(int[][] matriz){
        int longitudMaxima = 0;
        for (int[] fila : matriz){
            int longitud =Array.determinarLongitudMaxima(fila);
            if (longitud>longitudMaxima){
                longitudMaxima=longitud;
            }
        }
        return longitudMaxima;
    }

    /**
     * Determina la longitud mayor de los indices de un array 'double[]'.
     *
     * @param matriz Matriz sobre el que se desea trabajar.
     * @param decimales Número de decimales que se han de tener en cuenta.
     * @return Devuelve la máxima longitud del array como un 'int'.
     */
    public static int determinarLongitudMaxima(double[][] matriz, int decimales){
        int longitudMaxima = 0;
        for (double[] fila : matriz){
            int longitud =Array.determinarLongitudMaxima(fila, decimales);
            if (longitud>longitudMaxima){
                longitudMaxima=longitud;
            }
        }
        return longitudMaxima;
    }


//******************************** INVERTIR MATRIZ ********************************\\

    /**
     * Calcular la transpuesta de una matriz.
     *
     * @param matriz Matriz sobre la cual calcular.
     * @return Devuelve la matriz 'int[][]' transpuesta.
     */
    public static int[][] transpuesta(int[][] matriz) {
        final int FILAS = matriz.length;
        final int COLUMNAS = matriz[1].length;
        int[][] matrizInversa = new int[COLUMNAS][FILAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matrizInversa[j][i] = matriz[i][j];
            }
        }
        return matrizInversa;
    }


    /**
     * Calcular la transpuesta de una matriz.
     *
     * @param matriz Matriz sobre la cual calcular.
     * @return Devuelve la matriz 'double[][]' transpuesta.
     */
    public static String[][] transpuesta(String[][] matriz) {
        final int FILAS = matriz.length;
        final int COLUMNAS = matriz[1].length;
        String[][] matrizInversa = new String[COLUMNAS][FILAS];

        for (int i = 0; i < FILAS; i++) {
            for (int j = 0; j < COLUMNAS; j++) {
                matrizInversa[j][i] = matriz[i][j];
            }
        }
        return matrizInversa;
    }


//******************************** MÁXIMO Y MÍNIMO ********************************\\

    /**
     * Calcular el valor máximo/mínimo que contiene una matriz.
     *
     * @param matriz Matriz sobre la que realizar los calculos.
     * @param condicion Condición que indica si se desea extraer el valor máximo o mínimo.
     * @return Devuelve el valor 'int' deseado.
     */
    public static int calcularExtremo(int[][] matriz, IO.Condicion condicion){
        int contentedor=matriz[0][0];
        for (int[] fila : matriz){
            for (int valor : fila){
                if (condicion== IO.Condicion.MAXIMO){
                    if (valor>contentedor){
                        contentedor=valor;
                    }
                } else {
                    if (valor<contentedor){
                        contentedor=valor;
                    }
                }
            }
        }
        return contentedor;
    }

//******************************** MEDIA DE LA MATRIZ ********************************\\

    /**
     * Calcular la media de los valores que contiene una matriz.
     *
     * @param matriz Matriz sobre la que realizar los calculos.
     * @return Devuelve la media 'int' de la matriz.
     */
    public static double calcularMedia(int[][] matriz){
        int sumatorio=0;
        int contador=0;
        for (int[] fila : matriz){
            for (int valor : fila){
                sumatorio+=valor;
                contador++;
            }
        }
        return (double) sumatorio/contador;
    }
}


