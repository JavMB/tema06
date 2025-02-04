package com.javier.pilascolas;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ej3Pila {
    public enum APERTURAS {
        LLAVE('{', 1),
        CORCHETE('[', 3),
        PARENTESIS('(', 4),

        LLAVECIERRE('}', 2),
        CORCHETECIERRE(']', 6),
        PARENTESISCIERRE(')', 8);

        private final char simbolo;
        private final int valor;

        APERTURAS(char simbolo, int valor) {
            this.simbolo = simbolo;
            this.valor = valor;
        }

        public int getValor() {
            return valor;
        }
    }

    public static void main(String[] args) {
        Pila p1 = new Pila(100);

        if (args.length == 0) {
            System.out.println("Uso: java Ej3Pila <archivo.txt>");
            return;
        }

        File archivo = new File(args[0]);

        if (!archivo.exists()) {
            System.out.println("Error: No se pudo encontrar el archivo " + args[0]);
            return;
        }

        StringBuilder sb = new StringBuilder();

        try (Scanner scanner = new Scanner(archivo)) {
            while (scanner.hasNextLine()) {
                sb.append(scanner.nextLine()).append("\n"); // mantengo los saltos de linea
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: No se pudo abrir el archivo " + args[0]);
            return;
        }

        char[] texto = sb.toString().toCharArray();

        for (char caracter : texto) {
            int valor = switch (caracter) {
                case '{' -> APERTURAS.LLAVE.valor;
                case '[' -> APERTURAS.CORCHETE.valor;
                case '(' -> APERTURAS.PARENTESIS.valor;
                case '}' -> APERTURAS.LLAVECIERRE.valor;
                case ']' -> APERTURAS.CORCHETECIERRE.valor;
                case ')' -> APERTURAS.PARENTESISCIERRE.valor;
                default -> -1;
            };

            if (valor == -1) continue; //ignoro los que no son

            if (valor == 1 || valor == 3 || valor == 4) {
                if (comprobarApertura(p1, valor)) {
                    p1.push(valor);
                } else {
                    System.out.println("Error: No se ha podido apilar '" + caracter + "'");
                    return;
                }
            } else if (valor == 2 || valor == 6 || valor == 8) {
                if (comprobarCierre(p1, valor)) {
                    p1.pop();
                } else {
                    System.out.println("Error: Cierre inesperado '" + caracter + "'. No coincide con la apertura esperada.");
                    return;
                }
            }
        }

        if (p1.isEmpty()) {
            System.out.println("El código fuente está bien.");
        } else {
            System.out.println("Error: delimitadores de apertura sin cerrar.");
        }
    }

    public static boolean comprobarApertura(Pila p1, int valor) {
        return true;
    }


    public static boolean comprobarCierre(Pila p1, int valor) {
        if (p1.isEmpty()) return false;
        return p1.top() == valor / 2;
    }
}
