package com.javier.pilascolas.clases;

import java.util.Scanner;

public class Hospital {
    private ColaConsulta[] consultas;

    public Hospital() {
        String[] nombres = {"Juan", "Javi", "Pablo", "Pepe", "Ernesto"};
        this.consultas = new ColaConsulta[nombres.length];
        for (int i = 0; i < nombres.length; i++) {
            this.consultas[i] = new ColaConsulta(new Medico(nombres[i]));
        }
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
        return Integer.parseInt(sc.nextLine());
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Consultas{\n");
        int contador = 1;
        for (ColaConsulta consulta : consultas) {
            sb.append("  ").append(contador).append(". ").append(consulta).append("\n");
            contador++;
        }
        sb.append("}");
        return sb.toString();
    }

    public void addPaciente(Scanner sc) {
        System.out.println(this);
        System.out.println("A que cola añadimos paciente");
        int opcion = Integer.parseInt(sc.nextLine());
        opcion--;
        consultas[opcion].llegadaPaciente(sc);

    }

    public void atenderPaciente(Scanner sc) {
        System.out.println(this);
        int opcion = Integer.parseInt(sc.nextLine());
        opcion--;
        System.out.println(consultas[opcion].atenderPaciente());
        System.out.println(consultas[opcion]);
    }
    public void llenarConsultasInicialmente(Scanner sc) {
        String[] nombres = {"Pedro", "Sanchez", "Pablo", "Iglesias", "Juan"};
        for (ColaConsulta consulta : consultas) {
            for (int i = 0; i < 5; i++) {
                consulta.llegadaPaciente(nombres[i]);
            }
        }
        System.out.println("Pacientes iniciales agregados correctamente.\n");
    }



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Hospital h1 = new Hospital();

        h1.llenarConsultasInicialmente(sc);
        System.out.println(h1);

        int op;
        boolean salir = false;
        do {
            op = h1.menuHospital(sc);
            switch (op) {
                case 1 -> h1.addPaciente(sc);
                case 2 -> h1.atenderPaciente(sc);
                case 3 -> System.out.println(h1);
                case 4 -> salir = true;
                default -> System.out.println("Elige una opción válida.");
            }
        } while (!salir);
    }
}
