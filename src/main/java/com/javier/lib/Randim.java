package com.javier.lib;

public class Randim {
    public static double randomDouble(double minimo, double maximo){
        java.util.Random random = new java.util.Random();
        return random.nextDouble()*(maximo-minimo)+minimo;
    }

    public static int randomInt(int minimo, int maximo) {
        java.util.Random random = new java.util.Random();
        return random.nextInt(maximo - minimo + 1) + minimo;
    }
}
