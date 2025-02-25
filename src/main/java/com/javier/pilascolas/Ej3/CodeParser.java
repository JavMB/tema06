package com.javier.pilascolas.Ej3;
import com.javier.lib.Escaner;
import com.javier.pilascolas.Pila;

import java.io.File;

public class CodeParser {
    public enum APERTURAS {
        LLAVE('{', 1),
        CORCHETE('[', 3),
        PARENTESIS('(', 4),
        LLAVECIERRE('}', 2),
        CORCHETECIERRE(']', 6),
        PARENTESISCIERRE(')', 8);

        private final int valor;

        APERTURAS(char simbolo, int valor) {
            this.valor = valor;
        }
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Uso: java Ej3Pila <archivo.txt>");
            return;
        }

        String contenido = Escaner.readFile(new File(args[0]));
        if (contenido.isEmpty()) {
            System.err.println("Error: No se pudo leer el archivo.");
            return;
        }
        validarDelimitadores(contenido);
    }

    public static void validarDelimitadores(String contenido) {
        Pila p1 = new Pila(100);

        for (char caracter : contenido.toCharArray()) {
            int valor = switch (caracter) {
                case '{' -> APERTURAS.LLAVE.valor;
                case '[' -> APERTURAS.CORCHETE.valor;
                case '(' -> APERTURAS.PARENTESIS.valor;
                case '}' -> APERTURAS.LLAVECIERRE.valor;
                case ']' -> APERTURAS.CORCHETECIERRE.valor;
                case ')' -> APERTURAS.PARENTESISCIERRE.valor;
                default -> -1;
            };

            if (valor == -1) continue; // ignoramos cualq otro caracter

            if (valor == 1 || valor == 3 || valor == 4) {
                p1.push(valor);
            } else if (valor == 2 || valor == 6 || valor == 8) {
                if (p1.isEmpty() || ((Number) p1.top()).doubleValue() > valor / 2.0) {
                    System.out.println("Error: Cierre inesperado '" + caracter + "'");
                    return;
                }
                p1.pop();
            }
        }

        System.out.println(p1.isEmpty() ? "El código fuente está bien." : "Error: delimitadores de apertura sin cerrar.");
    }
}
