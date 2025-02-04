package com.javier.pilascolas;

import java.util.Arrays;
import java.util.Stack;

public class Pila {
    private int[] elementos;
    private int tope;
    private int capacidad;

    // Constructor
    public Pila(int capacidad) {
        this.capacidad = capacidad;
        elementos = new int[capacidad];
        tope = -1; // La pila comienza vacía
    }

    public int getSize() {
        return tope + 1;
    }

    public int getTop() {
        if (!isEmpty()) {
            return elementos[tope];
        } else {
            throw new IllegalStateException("La pila está vacía. No hay elementos.");
        }
    }


    public void apilar(int num) {
        if (tope < capacidad - 1) {
            elementos[++tope] = num;
        } else {
            throw new StackOverflowError("No se puede apilar. La pila está llena.");
        }
    }


    public int desapilar() {
        if (!isEmpty()) {
            return elementos[tope--];
        } else {
            throw new IllegalStateException("No hay nada en la pila para desapilar.");
        }
    }


    public boolean isEmpty() {
        return tope == -1;
    }

    public boolean isFull() {
        return tope == capacidad - 1;
    }


    @Override
    public String toString() {
        return "Pila{" +
                "elementos=" + Arrays.toString(elementos) +
                ", tope=" + tope +
                ", capacidad=" + capacidad +
                '}';
    }

    public static void main(String[] args) {


        Pila pila = new Pila(3);

        System.out.println("Pila vacía: " + pila.isEmpty());

        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);

        System.out.println("Pila llena: " + pila.isFull());
        System.out.println("Elemento en la cima: " + pila.getTop());

        System.out.println("Desapilando: " + pila.desapilar());
        System.out.println("Desapilando: " + pila.desapilar());
        System.out.println("Desapilando: " + pila.desapilar());

        System.out.println("Pila vacía: " + pila.isEmpty());


        try {
            pila.desapilar();
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}


