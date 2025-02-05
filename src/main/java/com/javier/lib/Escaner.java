package com.javier.lib;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.IOException;
import java.util.Scanner;

public class Escaner {

    //******************************** ESCÁNER ESTÁTICO ********************************\\

    /**
     * Scanner estático para leer desde System.in
     */
     public static final Scanner lector = new Scanner(System.in);

    //******************************** LECTURA DE ARCHIVOS ********************************\\

    /**
     * Lee el contenido completo de un archivo y lo devuelve como un String.
     *
     * @param filePath Ruta del archivo a leer.
     * @return Contenido del archivo en formato String.
     */
    public static String readFile(String filePath) {
        return readFile(new File(filePath));
    }

    /**
     * Lee el contenido completo de un archivo y lo devuelve como un String.
     *
     * @param archivo Archivo a leer.
     * @return Contenido del archivo en formato String.
     */
    public static String readFile(File archivo) {
        if (!archivo.exists() || !archivo.isFile()) {
            System.err.println("Error: El archivo no existe o no es válido -> " + archivo.getPath());
            return "";
        }

        // Intentamos usar Files.readString() si se ejecuta en Java 11 o superior
        try {
            return Files.readString(Path.of(archivo.getPath()));
        } catch (IOException e) {
            System.err.println("Error al leer el archivo -> " + archivo.getPath());
            return "";
        }
    }

    //******************************** GESTIÓN DE RECURSOS ********************************\\

    /**
     * Cierra un Scanner si está abierto.
     *
     * @param scanner Scanner que queremos cerrar.
     * @return `true` si el Scanner se cerró, `false` si ya estaba cerrado o era `null`.
     */
    public static boolean dispose(Scanner scanner) {
        if (scanner != null) {
            scanner.close();
            return true;
        }
        return false;
    }
}
