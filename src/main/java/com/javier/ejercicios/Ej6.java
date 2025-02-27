package com.javier.ejercicios;
import com.javier.clases.ItemBicicleta;
import com.javier.clases.TiendaBici;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Ej6 {
    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        TiendaBici tienda1 = new TiendaBici(20);
        tienda1.rellenarTienda();
        System.out.println("Tienda inicializada con inventario aleatorio");

        int opcion;
        do {
            opcion = mostrarMenuPrincipalYObtenerOpcion();
            switch (opcion) {
                case 1 -> manejarAnadirBici(tienda1);
                case 2 -> manejarVenderBici(tienda1);
                case 3 -> manejarConsultaBici(tienda1);
                case 4 -> mostrarStock(tienda1);
                case 0 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Introduce del 0 al 4");
            }
        } while (opcion != 0);

        sc.close();
    }

    private static int mostrarMenuPrincipalYObtenerOpcion() {
        System.out.println(
                "*************************\n" +
                        "** GESTIÓN DE BICICLETAS **\n" +
                        "*************************\n" +
                        "1.- Añadir bicicleta …\n" +
                        "2.- Vender bicicleta ...\n" +
                        "3.- Consultar bicicleta …\n" +
                        "4.- Mostrar stock\n" +
                        "------------------------------------\n" +
                        "0.- Salir");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, introduce un número.");
            return -1;
        }
    }

    private static void manejarAnadirBici(TiendaBici tienda) {
        System.out.println("Dime la referencia");
        int ref;
        try {
            ref = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Referencia inválida. Operación cancelada.");
            return;
        }

        // Primero verifica si la bici existe
        ItemBicicleta biciExistente = tienda.consultaReferencia(ref);
        if (biciExistente != null) {
            boolean resultado = tienda.anadirBici(ref, "", "", 0, 0, false, LocalDate.now(), 0);
            if (resultado) {
                System.out.println("Bicicleta encontrada. Stock actualizado.");
            }
            return;
        }

        System.out.println("Referencia no encontrada procediendo a crear nueva...");

        try {
            System.out.println("Dime la marca");
            String marca = sc.nextLine();

            System.out.println("Dime el modelo");
            String modelo = sc.nextLine();

            System.out.println("Dime el peso");
            float peso = Float.parseFloat(sc.nextLine());

            System.out.println("Dime el tamaño de las ruedas");
            float ruedasSize = Float.parseFloat(sc.nextLine());

            System.out.println("Tiene motor? (si/no)");
            boolean hasMotor = sc.nextLine().equalsIgnoreCase("si");

            System.out.println("Dime la fecha (YYYY-MM-DD)");
            LocalDate fechaFab = LocalDate.parse(sc.nextLine());

            System.out.println("Dime el precio");
            float precio = Float.parseFloat(sc.nextLine());

            boolean resultado = tienda.anadirBici(ref, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);

            if (resultado) {
                System.out.println("Bicicleta añadida correctamente.");
            } else {
                System.out.println("No hay espacio para añadir más bicicletas.");
            }

        } catch (NumberFormatException e) {
            System.out.println("Error: Ingresaste un valor numérico inválido.");
        } catch (DateTimeParseException e) {
            System.out.println("Error: Formato de fecha incorrecto. Usa YYYY-MM-DD.");
        } catch (Exception e) {
            System.out.println("Error al añadir la bicicleta: " + e.getMessage());
        }
    }

    private static void manejarVenderBici(TiendaBici tienda) {
        System.out.println("Dime la referencia");
        try {
            int ref = Integer.parseInt(sc.nextLine());
            String modelo = tienda.getModeloVendido(ref);

            if (tienda.venderBici(ref)) {
                System.out.println("Bicicleta " + modelo + " vendida correctamente");
            } else {
                System.out.println("No hay stock o no hemos podido encontrar la referencia");
            }
        } catch (NumberFormatException e) {
            System.out.println("Referencia inválida. Operación cancelada.");
        }
    }

    private static void manejarConsultaBici(TiendaBici tienda) {
        int opcion;
        do {
            opcion = mostrarMenuConsultasYObtenerOpcion();
            switch (opcion) {
                case 1 -> consultaReferencia(tienda);
                case 2 -> consultaPorMarca(tienda);
                case 3 -> consultaPorModelo(tienda);
                case 0 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Introduce del 0 al 3");
            }
        } while (opcion != 0);
    }

    private static int mostrarMenuConsultasYObtenerOpcion() {
        System.out.println("***********************\n" +
                "** CONSULTA BICICLETA **\n" +
                "***********************\n" +
                "1.- Consultar por referencia …\n" +
                "2.- Consultar por marca …\n" +
                "3.- Consultar por modelo …\n" +
                "---------------------------------\n" +
                "0.- Volver al menú principal");

        try {
            return Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, introduce un número.");
            return -1;
        }
    }

    private static void consultaReferencia(TiendaBici tienda) {
        System.out.println("Dime la referencia");
        try {
            int referencia = Integer.parseInt(sc.nextLine());
            ItemBicicleta bici = tienda.consultaReferencia(referencia);

            if (bici != null) {
                System.out.println(bici);
            } else {
                System.out.println("Bicicleta no encontrada");
            }
        } catch (NumberFormatException e) {
            System.out.println("Referencia inválida. Operación cancelada.");
        }
    }

    private static void consultaPorMarca(TiendaBici tienda) {
        System.out.println("Dime la marca");
        String marca = sc.nextLine();

        ItemBicicleta[] resultado = tienda.consultaPorMarca(marca);
        boolean encontrada = false;

        for (ItemBicicleta bici : resultado) {
            if (bici != null) {
                System.out.println(bici);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }

    private static void consultaPorModelo(TiendaBici tienda) {
        System.out.println("Dime el modelo");
        String modelo = sc.nextLine();

        ItemBicicleta[] resultado = tienda.consultaPorModelo(modelo);
        boolean encontrada = false;

        for (ItemBicicleta bici : resultado) {
            if (bici != null) {
                System.out.println(bici);
                encontrada = true;
            }
        }

        if (!encontrada) {
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }

    private static void mostrarStock(TiendaBici tienda) {
        ItemBicicleta[] stock = tienda.getStock();
        for (ItemBicicleta bici : stock) {
            if (bici != null) {
                System.out.println(bici);
            }
        }
    }
}
