package com.javier.practicar;

import java.util.Random;

/**
 * Ejercicio 1: Sistema de Estudiantes
 * <p>
 * Crea una clase Estudiante con los siguientes atributos y métodos:
 * <p>
 * Atributos:
 * nombre (String).
 * notas (array de 5 enteros).
 * <p>
 * Métodos:
 * Constructor que inicialice el nombre y el array de notas con valores aleatorios entre 0 y 10.
 * calcularPromedio(): Calcula el promedio de las notas.
 * mostrarNotas(): Muestra las notas con un bucle.
 * esAprobado(): Devuelve true si el promedio es mayor o igual a 5.
 * <p>
 * En la clase principal:
 * <p>
 * Crea un array de 3 estudiantes.
 * Muestra el nombre, las notas y si está aprobado o no, usando un bucle.
 */

public class Estudiante {
    private String nombre;
    private int[] notas;

    public Estudiante(String nombre) {
        Random rnd = new Random();
        this.nombre = nombre;
        this.notas = new int[5];

        for (int i = 0; i < notas.length; i++) {
            notas[i] = rnd.nextInt(11);
        }
    }

    // Getter para el nombre
    public String getNombre() {
        return nombre;
    }

    public float calcularPromedio() {
        int promedio = 0;
        for (int i = 0; i < notas.length; i++) {
            promedio += notas[i];
        }
        return (float) promedio / notas.length;

    }

    public void mostrarNotas() {
        for (int i = 0; i < notas.length; i++) {
            System.out.println("Nota " + (i + 1) + ": " + notas[i]);
        }
    }

    public boolean esAprobado() {
        return calcularPromedio() >= 5;
    }

    public static void mostrarTabla(Estudiante[] estudiantes) {
        // Encabezados de la tabla
        System.out.printf("%-15s %-15s %-10s\n", "Nombre", "Promedio", "Estado");
        System.out.println("--------------------------------------------");

        // Filas de la tabla
        for (Estudiante estudiante : estudiantes) {
            String estado = estudiante.esAprobado() ? "Aprobado" : "Suspendido";
            System.out.printf("%-15s %-15.2f %-10s\n",
                    estudiante.getNombre(),
                    estudiante.calcularPromedio(),
                    estado);
        }
    }


    public static void main(String[] args) {

        Estudiante[] estudiantes = {
                new Estudiante("Javi"),
                new Estudiante("Ana"),
                new Estudiante("Carlos"),
        };

        // Mostrar la información de cada estudiante
        for (Estudiante estudiante : estudiantes) {
            System.out.println("Nombre: " + estudiante.getNombre()); // Usar el getter para acceder al nombre
            estudiante.mostrarNotas(); // Mostrar notas
            System.out.printf("Promedio: %.2f\n", estudiante.calcularPromedio());
            System.out.println(estudiante.esAprobado() ? "Estado: Aprobado" : "Estado: Suspendido");
            System.out.println("-------------");
        }


    }

}
