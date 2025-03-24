package com.javier.ejercicios;
import com.javier.clases.Hospital;
import com.javier.clases.Paciente;
import java.time.LocalDate;
import java.util.Scanner;

public class Ej7 {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Hospital h = new Hospital(50);

        int option = menuUrgencias(sc);

        switch (option) {
            case 1 -> {
                System.out.println("Dime los sintomas");
                String sint = sc.nextLine();
                System.out.println("Dime el sip ");
                long sip =Integer.parseInt(sc.nextLine());





            }
            case 2 -> {
                int c = 0;
                double[] preRev = new double[4];
                System.out.println("Dime el SIP");
                long sip = Integer.parseInt(sc.nextLine());
                System.out.println("Dime la mediciones");
                while (c < 4) {
                    System.out.println(c + 1 + ".");
                    preRev[c++] = Double.parseDouble(sc.nextLine());
                }
                System.out.println(h.atenderPaciente(sip, preRev) + " atendido correctamente");
            }
            case 3 -> {
            }
            case 4 -> {
                System.out.println("Dime el SIP");
                long sip = Long.parseLong(sc.nextLine());
                System.out.println("Motivo de alta?");
                String motivoalta = sc.nextLine();

                if (h.darDeAltaAPaciente(sip, motivoalta)) {
                    System.out.println("Paciente dado de alta correctamente");
                } else System.out.println("Paciente no dado de alta");

            }


        }


    }


    public static int menuUrgencias(Scanner sc) {
        System.out.println("""
                ********************
                **
                URGENCIAS
                **
                ********************
                1. Nuevo paciente …
                2. Atender paciente …
                3. Consultas …
                4. Alta médica …
                -----------------------------
                0. Salir""");
        return Integer.parseInt(sc.nextLine());
    }

    public static int menuConsultas(Scanner sc) {
        System.out.println("""
                ***************
                ** CONSULTAS **
                ***************
                1. Por Sip …
                2. Por fechas …
                3. Estadísticas
                3. Mostrar histórico mensual
                --------------------------------
                0. Volver al menú principal""");
        return Integer.parseInt(sc.nextLine());
    }




}
