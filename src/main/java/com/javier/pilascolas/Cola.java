package com.javier.pilascolas;

public class Cola {
    /**
     * Tamaño inicial por defecto
     */
    private static final int INITIAL_SIZE = 10;
    /**
     * Factor de crecimiento cada vez que el array requiera ser redimensionado
     */
    private static final float GROW_FACTOR = 2f;
    /**
     * Valor con el que reconocemos una condición de error
     */
    private static final int ERROR = Integer.MIN_VALUE;
    /**
     * Array donde se guardan los valores de la cola
     */
    private int[] data;
    /**
     * Tamaño actual de la cola
     */
    private int size;

    public Cola(int capacity) {
        data = new int[capacity];
        this.size = 0;
    }

    public Cola() {
        this(INITIAL_SIZE);
    }

    /**
     * Agrega un elemento al final de la cola (enqueue)
     */
    public void enqueue(int e) {
        if (isFull()) {
            expand();
        }
        data[size++] = e;
    }

    /**
     * Elimina el primer elemento de la cola (dequeue)
     */
    public int dequeue() {
        if (isEmpty()) {
            return ERROR;
        }

        int e = data[0];

        // Desplazar elementos hacia la izquierda
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;

        return e;
    }

    /**
     * Expande el tamaño de la cola cuando está llena
     */
    private void expand() {
        int newSize = Math.round(data.length * GROW_FACTOR);
        int[] aux = new int[newSize];

        System.arraycopy(data, 0, aux, 0, data.length);

        data = aux;
    }

    /**
     * Devuelve el primer elemento sin eliminarlo (front o peek)
     */
    public int front() {
        return isEmpty() ? ERROR : data[0];
    }

    /**
     * Verifica si la cola está vacía
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Verifica si la cola está llena
     */
    private boolean isFull() {
        return size == data.length;
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
}
