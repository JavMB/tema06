package com.javier.ejercicios;
import com.javier.clases.TiendaBici;
import java.util.Scanner;
import static com.javier.clases.TiendaBici.menuBicis;
import static com.javier.clases.TiendaBici.menuConsultas;

public class Ej6
{
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        TiendaBici tienda1 = new TiendaBici(20);
        tienda1.rellenarTienda();
        int opcion, opcion2;
        do {
            opcion = menuBicis(sc);
            switch (opcion) {
                case 1 -> tienda1.anadirBici(sc);
                case 2 -> tienda1.venderBici(sc);
                case 3 -> {
                    do {
                        opcion2 = menuConsultas(sc);
                        switch (opcion2) {
                            case 1 -> tienda1.consultaReferencia(sc);
                            case 2 -> tienda1.consultaPorMarca(sc);
                            case 3 -> tienda1.consultaPorModelo(sc);
                        }
                    } while (opcion2 != 0);
                }
                case 4 -> tienda1.mostrarStock();
                default -> System.out.println("Introduce del 1 al 4");
            }
        } while (opcion != 0);
    }
}
