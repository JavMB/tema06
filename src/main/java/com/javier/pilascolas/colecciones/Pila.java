package com.javier.pilascolas.colecciones;

import java.util.Arrays;
import java.util.Objects;

public class Pila<T> {
    /**
     * Tamaño inicial por defecto
     */
    private static final int INITIAL_SIZE = 10;
    /**
     * Factor de crecimiento cada vez que el array requiera ser redimensionado
     */
    private static final float GROW_FACTOR = 2f;
    /**
     * Array donde se van a guardar los valores de la pila
     */
    private T[] data;
    /**
     * Tamaño actual de la pila
     */
    private int size;

    /**
     * Crea una pila con el tamaño inicial por defecto INITIAL_SIZE
     */
    public Pila() {
        this(INITIAL_SIZE);
    }

    /**
     * Crea una pila de tamaño inicial recibido como parámetro
     *
     * @param size Capacidad inicial de la pila
     */
    @SuppressWarnings("unchecked")
    public Pila(int size) {
        data = (T[]) new Object[size]; // Se crea un array genérico usando Object
        this.size = 0;
    }

    /**
     * Añade un elemento a la cima de la pila
     *
     * @param e Elemento a añadir
     */
    public void push(T e) {
        if (isFull()) {
            expand();
        }
        data[size++] = e;
    }

    /**
     * Expande el tamaño de la pila con el factor de crecimiento indicado por GROW_FACTOR
     */
    private void expand() {
        int newSize = Math.round(data.length * GROW_FACTOR);
        data = Arrays.copyOf(data, newSize);
    }



    /**
     * Extrae el elemento que ocupa la cima de la pila
     *
     * @return El elemento de la cima o null si la pila está vacía
     */
    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T e = data[--size];
        data[size] = null; // Limpiar referencia para evitar memory leaks
        return e;
    }

    /**
     * Obtiene el valor (sin extraer) del elemento que ocupa la cima de la pila
     *
     * @return El elemento de la cima o null si la pila está vacía
     */
    public T top() {
        if (isEmpty()) {
            return null;
        }
        return data[size - 1];
    }

    /**
     * Determina si la pila está llena
     *
     * @return true si el array ha alcanzado su capacidad máxima, false en caso contrario
     */
    private boolean isFull() {
        return size == data.length;
    }

    /**
     * Determina si la pila está vacía
     *
     * @return true si está vacía, false en caso contrario
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Devuelve el número de elementos que hay en la pila
     *
     * @return Número de elementos de la pila
     */
    public int size() {
        return size;
    }

    /**
     * Limpia la pila
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }


    /**
     * Clona la Pila actual
     *
     * @return devuelve una Pila copia de this
     */
    public Pila<T> clone() {
        Pila<T> nuevaPila = new Pila<>(this.data.length); //nueva pila con el mismo tamaño

        nuevaPila.size = this.size;
        nuevaPila.data = Arrays.copyOf(this.data, this.data.length);
        return nuevaPila;
    }

    /**
     * Muestra los n elementos superiores
     *
     * @param n cuantos miramos
     */
    public void peek(int n) {
        if (isEmpty() || n > size) {
            return;
        }

        for (int i = 1; i <= n; i++) {
            System.out.println((data[size - i]));
        }

    }


    public int search(T element) {
        Pila<T> temp = this.clone();
        int distancia = 1;
        for (int i = temp.size - 1; i >= 0; i--) {
            if (Objects.equals(temp.pop(), element)) {
                return distancia;
            }
            distancia++;
        }
        return -1;
    }

    public void reverse(){
        Pila<T> aux = new Pila<>(this.size);

        for (int i = size - 1; i >= 0; i--) {
            aux.push(data[i]);
        }

        data = Arrays.copyOf(aux.data, aux.data.length);
        size = aux.size;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]).append(" ");
        }
        sb.append("]");
        return sb.toString();
    }


    public static void main(String[] args) {
        Pila<String> pila = new Pila<>(3);

        System.out.println("Pila vacía: " + pila.isEmpty());

        pila.push("Hola");
        pila.push("Mundo");
        pila.push("!");

        System.out.println("Elemento en la cima: " + pila.top());

        System.out.println("Desapilando: " + pila.pop());
        System.out.println("Desapilando: " + pila.pop());
        System.out.println("Desapilando: " + pila.pop());

        System.out.println("Pila vacía: " + pila.isEmpty());

        System.out.println("Intentando desapilar: " + pila.pop());
    }
}
