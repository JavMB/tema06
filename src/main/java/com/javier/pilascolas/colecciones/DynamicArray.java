package com.javier.pilascolas.colecciones;

import java.util.Arrays;

public class DynamicArray<T> {
    /* Capacidad inicial por defecto del array */
    private static final int DEFAULT_CAPACITY = 10;
    /* Factor de crecimiento */
    private static final float GROW_FACTOR = 2f;
    /* Array de datos */
    private T[] data;
    /* Número de elementos en el array */
    private int size;

    /**
     * Crear un array dinámico con la capacidad inicial por defecto
     */
    public DynamicArray() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * Crea un array dinámico con la capacidad inicial indicada
     *
     * @param capacity Capacidad inicial
     */
    @SuppressWarnings("unchecked")
    public DynamicArray(int capacity) {
        data = (T[]) new Object[capacity]; // Array genérico
        size = 0;
    }

    /**
     * Obtiene el elemento en la posición index
     *
     * @param index Índice del elemento a obtener
     * @return el valor obtenido o null si el índice es inválido
     */
    public T get(int index) {
        if (index >= size || index < 0)
            return null;
        return data[index];
    }

    /**
     * Añade un elemento al final del array
     *
     * @param value Elemento a añadir
     * @return true si se añadió correctamente
     */
    public boolean add(T value) {
        if (isFull()) expand();
        data[size++] = value;
        return true;
    }

    /**
     * Desplaza los elementos a la derecha a partir del índice indicado
     *
     * @param index Índice desde donde se desplazan los elementos
     */
    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }

    /**
     * Añade un elemento en una posición específica
     *
     * @param index Índice donde se insertará el elemento
     * @param value Elemento a añadir
     * @return true si se insertó correctamente
     */
    public boolean add(int index, T value) {
        if (index > size || index < 0)
            return false;
        if (isFull()) expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    /**
     * Desplaza los elementos a la izquierda desde el índice indicado
     *
     * @param index Índice desde donde se desplazan los elementos
     */
    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        data[size] = null; // Limpiar referencia para evitar memory leaks
    }

    /**
     * Elimina el elemento en una posición dada
     *
     * @param index Índice del elemento a eliminar
     * @return El valor eliminado o null si el índice es inválido
     */
    public T remove(int index) {
        if (index >= size || index < 0)
            return null;
        T removedValue = data[index];
        moveToLeft(index);
        return removedValue;
    }

    /**
     * Elimina la primera ocurrencia de un valor
     *
     * @param value Valor a eliminar
     * @return true si se eliminó con éxito, false si no se encontró
     */
    public boolean remove(T value) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(value)) {
                moveToLeft(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Establece un nuevo valor en una posición dada
     *
     * @param index Índice del elemento a modificar
     * @param value Nuevo valor
     * @return true si la operación fue exitosa, false si el índice es inválido
     */
    public boolean set(int index, T value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    /**
     * Expande el tamaño del array según el factor de crecimiento
     */
    @SuppressWarnings("unchecked")
    private void expand() {
        int newSize = Math.round(data.length * GROW_FACTOR);
        data = Arrays.copyOf(data, newSize);
    }

    /**
     * Obtiene el número de elementos almacenados
     *
     * @return Tamaño actual
     */
    public int size() {
        return size;
    }

    /**
     * Verifica si el array está lleno
     *
     * @return true si está lleno, false si no
     */
    private boolean isFull() {
        return size == data.length;
    }


    public void clear() {
        for (int i = 0; i < size; i++) {
            data[i] = null;

        }
        size = 0;

    }

    public DynamicArray<T> clone() {
        DynamicArray<T> nuevoarray = new DynamicArray<>(this.data.length);
        nuevoarray.size = this.size;
        nuevoarray.data = Arrays.copyOf(this.data, this.data.length);
        return nuevoarray;
    }

    public int indexOf(T e) {
        for (int i = 0; i < size; i++) {
            if (e == null) {
                if (data[i] == null) return i;
            } else {
                if (e.equals(data[i])) return i;
            }
        }
        return -1;
    }


    public void trimToSize() {
        if (size < data.length) {
            data = Arrays.copyOf(data, size);
        }
    }

    public boolean swap(int ix1, int ix2) {
        if (ix1 >= 0 && ix1 < size && ix2 >= 0 && ix2 < size) {
            T aux = data[ix1];
            data[ix1] = data[ix2];
            data[ix2] = aux;
            return true;
        }
        return false;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray<?> that = (DynamicArray<?>) o;

        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!data[i].equals(that.data[i]))
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        return 31 * Arrays.hashCode(data) + size;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArray<String> d1 = new DynamicArray<>(10);

        d1.add("Hola");
        d1.add("Mundo");
        d1.add("!");

        System.out.println(d1);

        d1.add(1, "Nuevo");
        System.out.println(d1);

        d1.remove(2);
        System.out.println(d1);

        d1.remove("Nuevo");
        System.out.println(d1);

        System.out.println("Elemento en índice 1: " + d1.get(1));

        d1.set(1, "Adiós");
        System.out.println(d1);
    }
}
