package com.javier.practicar;
import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num1, num2, op;

        // Solicitar los números al usuario
        System.out.println("Introduce el primer número:");
        num1 = sc.nextInt();
        System.out.println("Introduce el segundo número:");
        num2 = sc.nextInt();

        // Mostrar el menú de operaciones
        System.out.println("""
                ¿Qué operación quieres realizar?
                1 -> Suma
                2 -> Resta
                3 -> Multiplicación
                4 -> División
                """);
        op = sc.nextInt();

        // Manejo de las operaciones
        switch (op) {
            case 1 -> System.out.println("Resultado (Suma): " + (num1 + num2));
            case 2 -> System.out.println("Resultado (Resta): " + (num1 - num2));
            case 3 -> System.out.println("Resultado (Multiplicación): " + (num1 * num2));
            case 4 -> {
                if (num2 != 0) {
                    System.out.println("Resultado (División): " + (num1 / num2));
                } else {
                    System.out.println("Error: División por cero no permitida.");
                }
            }
            default -> System.out.println("Error: Opción no válida.");
        }

        sc.close(); // Cerrar el Scanner para liberar recursos
    }
}
