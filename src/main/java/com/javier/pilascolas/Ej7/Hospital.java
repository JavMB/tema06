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


    public static void main(String[] args) {
        Hospital h1 = new Hospital(5);
        Scanner sc = new Scanner(System.in);
        Medico m1 = new Medico("Juan");
        Medico m2 = new Medico("Pepe");
        Medico m3 = new Medico("Pablo");
        Medico m4 = new Medico("Pepe");
        Medico m5 = new Medico("Ernesto");
        Medico[] medicos = new Medico[]{m1, m2, m3, m4, m5};
        ColaConsulta c1 = new ColaConsulta(m1);
        ColaConsulta c2 = new ColaConsulta(m2);
        ColaConsulta c3 = new ColaConsulta(m3);
        ColaConsulta c4 = new ColaConsulta(m4);
        ColaConsulta c5 = new ColaConsulta(m5);

        ColaConsulta[] cola = new ColaConsulta[]{c1, c2, c3, c4, c5};
        for (ColaConsulta consulta : cola) {
            for (int i = 0; i < 5; i++) {
                consulta.llegadaPaciente(sc);
            }
        }
        h1.setConsultas(cola);




    }
}
