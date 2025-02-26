package com.javier.clases;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Random;
import java.util.Scanner;

public class GestionAlumnos {

    private final Alumno[] alumnos;

    public GestionAlumnos(int capacidadMaxima) {
        alumnos = new Alumno[capacidadMaxima];
    }


    public void generarAlumnos(int cantidad, Random rnd, String[] nombres, String[] apellidos) {
        // Verificar que la cantidad no exceda el tamaño del array
        if (cantidad > alumnos.length) {
            throw new IllegalArgumentException("La cantidad excede la capacidad máxima.");
        }

        for (int i = 0; i < cantidad; i++) {
            String nia = (Integer.toString(rnd.nextInt(1035623)));
            String nombre = (nombres[rnd.nextInt(nombres.length)]);
            String apellido = (apellidos[rnd.nextInt(apellidos.length)]);
            LocalDate fecha = (LocalDate.ofEpochDay(new Random().nextInt((int) ChronoUnit.DAYS.between(LocalDate.of(1990, 1, 1), LocalDate.of(2010, 12, 31))) + LocalDate.of(1990, 1, 1).toEpochDay()));
            int grupo = (rnd.nextInt(2) + 1);
            long telefono = 100000000 + (long) (rnd.nextDouble() * (965174521 - 100000000));

            alumnos[i] = new Alumno(nia, nombre, apellido, fecha, grupo, telefono);
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


        System.out.println("** NUEVO ALUMNO **");
        System.out.print("Introduce NIA: ");
        String nia = scanner.nextLine().toUpperCase();


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
        long telefono = Long.parseLong(scanner.nextLine());

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
        System.out.printf("%-10s %-10s %-15s %-15s %-10s %-10s\n", "NIA", "Nombre", "Apellido", "Fecha",
                "Grupo", "Telefono");
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

    public void porNia(Scanner sc) {
        System.out.println("Dime el NIA");
        String nia = sc.nextLine();
        System.out.printf("%-10s %-10s %-15s %-15s %-10s %-10s\n", "NIA", "Nombre", "Apellido", "Fecha",
                "Grupo", "Telefono");
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getNia().equals(nia)) {
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

    public void porApellido(Scanner sc) {
        System.out.println("Dime el apellido");
        String apellido = sc.nextLine();
        System.out.printf("%-10s %-10s %-15s %-15s %-10s %-10s\n", "NIA", "Nombre", "Apellido", "Fecha",
                "Grupo", "Telefono");
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getApellido().equals(apellido)) {
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

    public void porEdad(Scanner sc) {
        System.out.println("Dime la edad");
        LocalDate edad = LocalDate.parse(sc.nextLine());
        System.out.printf("%-10s %-10s %-15s %-15s %-10s %-10s\n", "NIA", "Nombre", "Apellido", "Fecha",
                "Grupo", "Telefono");
        for (Alumno alumno : alumnos) {
            if (alumno != null && alumno.getFechanacimiento().isEqual(edad)) {
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


}
