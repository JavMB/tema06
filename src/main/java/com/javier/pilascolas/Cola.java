package com.javier.pilascolas;

import java.util.Arrays;
import java.util.Objects;

public class Cola<T> {
    /**
     * Tamaño inicial por defecto
     */
    private static final int INITIAL_SIZE = 10;
    /**
     * Factor de crecimiento cada vez que el array requiera ser redimensionado
     */
    private static final float GROW_FACTOR = 2f;

    /**
     * Array donde se guardan los valores de la cola
     */
    private T[] data;
    /**
     * Tamaño actual de la cola
     */
    private int size;

    @SuppressWarnings("unchecked")
    public Cola(int capacity) {
        data = (T[]) new Object[capacity]; // Creación de un array genérico
        this.size = 0;
    }

    public Cola() {
        this(INITIAL_SIZE);
    }

    /**
     * Agrega un elemento al final de la cola (enqueue)
     */
    public void enqueue(T e) {
        if (isFull()) {
            expand();
        }
        data[size++] = e;
    }

    /**
     * Elimina el primer elemento de la cola (dequeue)
     */
    public T dequeue() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede desencolar: La cola está vacía.");
        }

        T e = data[0];

        // desplazar elementos hacia la izquierda
        for (int i = 0; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; // Limpiar referencia para evitar memory leaks

        return e;
    }

    /**
     * Expande el tamaño de la cola cuando está llena
     */
    private void expand() {
        int newSize = Math.round(data.length * GROW_FACTOR);
        data = Arrays.copyOf(data, newSize);
    }

    /**
     * Devuelve el primer elemento sin eliminarlo (front o peek)
     */
    public T front() {
        if (isEmpty()) {
            throw new IllegalStateException("No se puede obtener el frente: La cola está vacía.");
        }
        return data[0];
    }

    /**
     * Limpia la cola
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;
        }
        size = 0;
    }

    /**
     * Clona la Cola actual
     *
     * @return devuelve una Cola copia de this
     */
    public Cola<T> clone() {
        Cola<T> nuevaCola = new Cola<>(this.data.length); // Nueva cola con el mismo tamaño
        nuevaCola.size = this.size;
        nuevaCola.data = this.data.clone();  // Hacemos una copia del array
        return nuevaCola;
    }

    /**
     * Muestra los n primeros elementos de la cola sin eliminarlos
     *
     * @param n Número de elementos a mostrar
     */
    public void peek(int n) {
        if (isEmpty()) {
            System.out.println("La cola está vacía.");
            return;
        }

        if (n > size) {
            n = size;  // Si piden más elementos de los que hay, ajustamos a `size`
        }

        for (int i = 0; i < n; i++) {
            System.out.println(data[i]);
        }
    }

    /**
     * Busca un elemento en la cola y devuelve su posición relativa (1 = primero en la cola)
     *
     * @param element Elemento a buscar
     * @return La posición en la cola (1 = primer elemento), o -1 si no se encuentra
     */
    public int search(T element) {
        for (int i = 0, distancia = 1; i < size; i++, distancia++) {
            if (Objects.equals(data[i], element)) {
                return distancia;
            }
        }
        return -1; // No encontrado
    }

    public void reverse() {
        Cola<T> aux = new Cola<>(this.size);

        for (int i = 0; i < size ; i++) {
            aux.enqueue(data[i]);
        }

        data = Arrays.copyOf(aux.data, aux.data.length);
        size = aux.size;
    }

    /**
     * Devuelve el número de elementos que hay en la cola
     *
     * @return Número de elementos en la cola
     */
    public int size() {
        return size;
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
        return Arrays.toString(Arrays.copyOf(data, size));
    }

    public static void main(String[] args) {
        Cola<String> cola = new Cola<>(5);

        System.out.println("Cola vacía: " + cola.isEmpty());

        cola.enqueue("A");
        cola.enqueue("B");
        cola.enqueue("C");

        System.out.println("Elemento en el frente: " + cola.front());

        System.out.println("Desencolando: " + cola.dequeue());
        System.out.println("Desencolando: " + cola.dequeue());

        System.out.println("Cola actual: " + cola);

        cola.enqueue("D");
        cola.enqueue("E");

        System.out.println("Búsqueda de 'E': " + cola.search("E"));

        cola.peek(2);

        cola.clear();
        System.out.println("Cola después de limpiar: " + cola.isEmpty());
    }
}
