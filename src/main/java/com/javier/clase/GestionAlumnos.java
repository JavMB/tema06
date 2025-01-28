package com.javier.clase;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class GestionAlumnos {

    private Alumno[] alumnos; // Array de alumnos

    public GestionAlumnos(int capacidadMaxima) {
        alumnos = new Alumno[capacidadMaxima];
    }


    public void generarAlumnos(int cantidad, Random rnd, String[] nombres, String[] apellidos) {
        // Verificar que la cantidad no exceda el tamaño del array
        if (cantidad > alumnos.length) {
            throw new IllegalArgumentException("La cantidad excede la capacidad máxima.");
        }

        for (int i = 0; i < cantidad; i++) {

            alumnos[i] = new Alumno();


            alumnos[i].setNia(Integer.toString(rnd.nextInt(1035623)));
            alumnos[i].setNombre(nombres[rnd.nextInt(nombres.length)]);
            alumnos[i].setApellido(apellidos[rnd.nextInt(apellidos.length)]);
            alumnos[i].setFechanacimiento(LocalDate.ofEpochDay(new Random().nextInt((int) ChronoUnit.DAYS.between(LocalDate.of(1990, 1, 1), LocalDate.of(2010, 12, 31))) + LocalDate.of(1990, 1, 1).toEpochDay()));
            alumnos[i].setGrupo(rnd.nextInt(2) + 1);

            long telefono = 100000000 + (long) (rnd.nextDouble() * (965174521 - 100000000));
            alumnos[i].setTelefono(Long.toString(telefono));
        }
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


    public void nuevoAlumno(Scanner scanner) {


        // Solicitar datos del nuevo alumno
        System.out.println("** NUEVO ALUMNO **");
        System.out.print("Introduce NIA: ");
        String nia = scanner.nextLine().toUpperCase();


        // Validar que no exista otro alumno con el mismo NIA
        for (Alumno alumno : alumnos) {
            if (alumno != null) {
                if (alumno.getNia().equals(nia)) {
                    System.out.println("Error: Ya existe un alumno con ese NIA.");
                    return;
                }

            }
        }

        System.out.print("Introduce nombre: ");
        String nombre = scanner.nextLine();
        System.out.print("Introduce apellidos: ");
        String apellidos = scanner.nextLine();
        System.out.print("Introduce fecha de nacimiento (YYYY-MM-DD): ");
        LocalDate fechaNacimiento = LocalDate.parse(scanner.nextLine());
        System.out.print("Introduce grupo: ");
        int grupo = Integer.parseInt(scanner.nextLine());
        System.out.print("Introduce teléfono: ");
        String telefono = scanner.nextLine();

        // Crear el nuevo alumno y agregarlo al array
        Alumno nuevoAlumno = new Alumno(nia, nombre, apellidos, fechaNacimiento, grupo, telefono);

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] == null) {
                alumnos[i] = nuevoAlumno;
                return;
            }
        }
        System.out.println("Esta lleno ");


    }

    public void borrarAlumno(Scanner scanner) {
        System.out.println("Dime el nia");
        String nia = scanner.nextLine().toUpperCase();

        for (int i = 0; i < alumnos.length; i++) {
            if (alumnos[i] != null && alumnos[i].getNia().equals(nia)) {
                System.out.println("CONFIRMAR BORRADO S/N");
                if (scanner.nextLine().equalsIgnoreCase("S")) {
                    alumnos[i] = null;
                    System.out.println("Borrado completado");
                    return;
                }

            }

        }
        System.out.println("No hay ningun alumno con ese NIA");
    }

    public void porGrupo(Scanner sc) {
        System.out.println("Dime el grupo");
        int grupo = sc.nextInt();

        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getGrupo() == grupo) {
                System.out.printf("%-10s %-10s %-15s %-15s %-10s %-10s\n",
                        alumno.getNia(),
                        alumno.getNombre(),
                        alumno.getApellido(),
                        alumno.getFechanacimiento(),
                        alumno.getGrupo(),
                        alumno.getTelefono());
            }
        }

    }


    public Alumno[] getAlumnos() {
        return alumnos;
    }

    public void setAlumnos(Alumno[] alumnos) {
        this.alumnos = alumnos;
    }

    public static void main(String[] args) {
        String[] nombres = {"javi", "pepe", "juan", "jose"};
        String[] apellidos = {"mengual", "lopez", "ferrandiz", "torrado"};

        GestionAlumnos alumnos1 = new GestionAlumnos(20);

        alumnos1.generarAlumnos(20, new Random(), nombres, apellidos);

        alumnos1.porGrupo(new Scanner(System.in));

//        int opcion, opcion2;
//
//        do {
//
//            opcion = menuAlumnos();
//
//            switch (opcion) {
//                case 1 -> alumnos1.nuevoAlumno(new Scanner(System.in));
//                case 2 -> alumnos1.borrarAlumno(new Scanner(System.in));
//                case 3 -> {
//                    do {
//                        opcion2 = menuConsultas();
//
//                        switch (opcion2) {
//                            case 1 -> alumnos1.porGrupo(new Scanner(System.in));
//                            case 2 -> ;
//                            case 3 -> ;
//                            case 4 -> ;
//
//                        }
//                    } while (opcion2 != 0);
//                }
//
//            }
//
//
//        } while (opcion != 0);


    }
}
