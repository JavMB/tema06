package com.javier.ejercicios;

import java.util.Scanner;

public class Ej7 {
     static Scanner sc =new Scanner(System.in);
    public static void main(String[] args) {


    }
    public static int menuUrgencias(Scanner sc){
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
    public static int menuConsultas(Scanner sc){
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
