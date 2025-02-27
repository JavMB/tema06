package com.javier.ejercicios;
import com.javier.clases.GestionAlumnos;
import java.util.Random;
import java.util.Scanner;

public class Ej3 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        String[] nombres = {"javi", "pepe", "juan", "jose"};
        String[] apellidos = {"mengual", "lopez", "ferrandiz", "torrado"};

        GestionAlumnos alumnos1 = new GestionAlumnos(20);

        alumnos1.generarAlumnos(20, new Random(), nombres, apellidos);


        int opcion, opcion2;

        do {

            opcion = menuAlumnos();

            switch (opcion) {
                case 1 -> alumnos1.nuevoAlumno(sc);
                case 2 -> alumnos1.borrarAlumno(sc);
                case 3 -> {
                    do {
                        opcion2 = menuConsultas();

                        switch (opcion2) {
                            case 1 -> alumnos1.porGrupo(sc);
                            case 2 -> alumnos1.porEdad(sc);
                            case 3 -> alumnos1.porNia(sc);
                            case 4 -> alumnos1.porApellido(sc);

                        }
                    } while (opcion2 != 0);
                }

            }


        } while (opcion != 0);


    }
    public static int menuAlumnos() {
        Scanner sc = new Scanner(System.in);
        System.out.println("*********************\n" +
                "1. Nuevo alumno …\n" +
                "2. Baja de alumno …\n" +
                "3. Consultas …\n" +
                "------------------------------\n" +
                "0. Salir");
        return sc.nextInt();

    }

    public static int menuConsultas() {
        Scanner sc = new Scanner(System.in);
        System.out.println("***************\n" +
                "** CONSULTAS **\n" +
                "***************\n" +
                "1. Por grupo …\n" +
                "2. Por edad ...\n" +
                "3. Por nia ...\n" +
                "4. Por apellidos …\n" +
                "--------------------\n" +
                "0. Volver al menú principal");
        return sc.nextInt();

    }
}

