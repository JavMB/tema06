package com.javier.pilascolas.Ej7;
import java.util.Scanner;

public class Hospital {
    private ColaConsulta[] consultas;

    public Hospital(int cantidad) {
        this.consultas = new ColaConsulta[cantidad];
    }

    public void setConsultas(ColaConsulta[] consultas) {
        this.consultas = consultas;
    }

    public int menuHospital(Scanner sc) {
        System.out.println("=== HOSPITAL ===\n" +
                "1. Añadir paciente\n" +
                "2. Atender siguiente paciente\n" +
                "3. Mostrar estado de las colas\n" +
                "4. Salir");
        return sc.nextInt();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Hospital{\n");

        int contador = 1;
        for (ColaConsulta consulta : consultas) {
            sb.append("  ").append(contador).append(". ").append(consulta.toString()).append("\n");
            contador++;
        }

        sb.append("}");
        return sb.toString();
    }

    public void añadirPaciente(Scanner sc) {
        System.out.println(this);
        int opcion = sc.nextInt();
        consultas[opcion].llegadaPaciente(sc);
        System.out.println(consultas[opcion]);
    }

    public void atenderPaciente(Scanner sc) {
        System.out.println(this);
        int opcion = sc.nextInt();
        System.out.println(consultas[opcion].atenderPaciente());
        System.out.println(consultas[opcion]);
    }


    public static void main(String[] args) {
        Hospital h1 = new Hospital(5);
        Scanner sc = new Scanner(System.in);
        ColaConsulta[] cola = getColaConsultas();
        for (ColaConsulta consulta : cola) {
            for (int i = 0; i < 5; i++) {
                consulta.llegadaPaciente(sc);
            }
        }
        h1.setConsultas(cola);

        System.out.println(h1);

        do {
            switch (h1.menuHospital(sc)) {
                case 1 -> h1.añadirPaciente(sc);
                case 2 -> h1.atenderPaciente(sc);
                case 3 -> System.out.println(h1);
                case 4 -> {
                    return;
                }
                default -> System.out.println("Elige bien");
            }
        } while (true);


    }


    private static ColaConsulta[] getColaConsultas() {
        String[] nombres = {"Juan", "Javi", "Pablo", "Pepe", "Ernesto"};
        ColaConsulta[] consultas = new ColaConsulta[nombres.length];

        for (int i = 0; i < nombres.length; i++) {
            consultas[i] = new ColaConsulta(new Medico(nombres[i]));
        }
        return consultas;
    }



}
