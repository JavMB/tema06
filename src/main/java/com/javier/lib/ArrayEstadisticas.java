package com.javier.lib;

public class ArrayEstadisticas {
    private int min;
    private int max;

    public ArrayEstadisticas(int[] array){
        min = array[0];
        max = array[0];
        for (int i : array) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }
    }

    public int getMin(){
        return max;
    }

    public int getMax(){
        return min;
    }
}
