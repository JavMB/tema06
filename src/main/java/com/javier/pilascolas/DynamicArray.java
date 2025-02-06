package com.javier.pilascolas;

import java.util.Arrays;

/**
 * DynamicArray
 * License: 🅮 Public Domain
 * Ejercicios de Pilas y Colas
 *
 * @author Germán Gascón <ggascon@gmail.com>
 * @version 0.1, 2020-01-30
 * @since 0.1, 2020-01-30
 **/
public class DynamicArray {
    /*
      Como aún no hemos visto las Exception de momento utilizamos el menos infinito para detectar errores
    */
    private static final double ERROR = Double.NEGATIVE_INFINITY;
    /* Capacidad inicial por defecto del array */
    private final static int DEFAULT_CAPACITY = 10;
    /* Factor de crecimiento */
    private final static float GROW_FACTOR = 2f;
    /* Los datos del array */
    private double[] data;
    /* Número de elementos del array */
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
    public DynamicArray(int capacity) {
        data = new double[capacity];
        size = 0;
    }

    /**
     * Obtiene el elemento que ocupa el índice index
     *
     * @param index Índice del elemento a obtener
     * @return el valor obtenido o ERROR
     */
    public double get(int index) {
        if (index >= size || index < 0)
            return ERROR;
        return data[index];
    }

    /**
     * Añade el elemento indicado al array
     *
     * @param value Elemento a añadir
     * @return true
     */
    public boolean add(double value) {
        if (isFull())
            expand();
        data[size] = value;
        size++;
        return true;
    }


    /**
     * Método de uso interno para desplazar los elementos a la derecha a partir del índice indicado
     *
     * @param index Índice a partir del cual se desplazarán los elementos
     */
    private void moveToRight(int index) {
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        size++;
    }


    /**
     * Añade el elemento indicado al array en la posición indicada por index
     *
     * @param index Índice donde se añadirá el elemento
     * @param value Elemento a añadir
     * @return true
     */
    public boolean add(int index, double value) {
        if (index >= size || index < 0)
            return false;
        if (isFull())
            expand();
        moveToRight(index);
        data[index] = value;
        return true;
    }

    /**
     * Método de uso interno para desplazar los elementos a la izquierda a partir del índice indicado
     *
     * @param index Índice a partir del cual se desplazarán los elementos
     */
    private void moveToLeft(int index) {
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
    }

    /**
     * Elimina del array el elemento que ocupa la posición desplazando una posición a la izquierda
     * todos los elementos que hay a su derecha
     *
     * @param index posición a eliminar
     * @return El valor eliminado
     */
    public double remove(int index) {
        if (index >= size || index < 0)
            return ERROR;
        double valor = data[index];
        moveToLeft(index);
        return valor;
    }

    /**
     * Elimina del array la primera ocurrencia del valor indicado como parámetro desplazando una posición
     * a la izquierda todos los elementos que haya a su derecha
     *
     * @param value valor a eliminar
     * @return true si se ha borrado el elemento, false en caso contrario
     */
    public boolean remove(double value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) {
                moveToLeft(i);
                return true;
            }
        }
        return false;
    }

    /**
     * Establece el valor del elemento con índice index
     *
     * @param index Índice del elemento a modificar
     * @param value Valor que toma el elemento
     * @return true
     */
    public boolean set(int index, double value) {
        if (index >= size || index < 0)
            return false;
        data[index] = value;
        return true;
    }

    /**
     * Método de uso interno para ampliar la capacidad del array según el factor de crecimiento
     */
    private void expand() {
        double[] copy = new double[Math.round(data.length * GROW_FACTOR)];
        for (int i = 0; i < size; i++) {
            copy[i] = data[i];
        }
        data = copy;
    }

    /**
     * Obtiene el número de elementos que hay en el array
     *
     * @return int
     */
    public int size() {
        return size;
    }

    /**
     * Método de uso interno para determinar si el array está lleno
     *
     * @return true si está lleno, false si no lo está
     */
    private boolean isFull() {
        return size == data.length;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        DynamicArray that = (DynamicArray) o;

        if (size != that.size) return false;

        // Sólo tenemos en cuenta los elementos del array que están en posiciones válidas
        for (int i = 0; i < size; i++) {
            if (data[i] != that.data[i])
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Arrays.hashCode(data);
        result = 31 * result + size;
        return result;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (int i = 0; i < size; i++)
            sb.append(data[i]).append(" ");
        sb.append("]");
        return sb.toString();
    }

    public static void main(String[] args) {
        DynamicArray d1 = new DynamicArray(10);
        for (int i = 0; i < 9; i++) {
            d1.add(i + 100);
        }
        System.out.println(d1);
        d1.add(9, 100);

        d1.add(200);

        d1.remove(8);
        d1.remove(100.00);

        System.out.println(d1.get(9));
        System.out.println(d1.set(9, 500));
        System.out.println(d1.size);


    }
}
