package com.javier.clase;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
//Se puede con objetos vacios tmb

public class TiendaBici {
    private final Bicicleta[] bicisModelos;
    private final int[] stock;

    //constructor para crear tienda con arrays previas
    public TiendaBici(Bicicleta[] b, int[] stock) {
        this.bicisModelos = b;
        this.stock = stock;
    }

    //constructor recomendado
    public TiendaBici(int capacidad) {
        this.bicisModelos = new Bicicleta[capacidad];
        this.stock = new int[capacidad];
    }


    public void anadirBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());


        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] != null && bicisModelos[i].getREF() == ref) {
                stock[i]++;
                System.out.println("Bicicleta encontrada. Stock actualizado.");
                return;
            }

        }

        System.out.println("Referencia no encontrada procediendo a crear nueva...");

        System.out.println("Dime la nueva referencia");
        int referencia = Integer.parseInt(sc.nextLine());
        System.out.println("Dime la marca");
        String marca = sc.nextLine();
        System.out.println("Dime el modelo");
        String modelo = sc.nextLine();
        System.out.println("Dime el peso");
        float peso = Float.parseFloat(sc.nextLine());
        System.out.println("Dime el tamaño de las ruedas");
        float ruedasSize = Float.parseFloat(sc.nextLine());
        System.out.println("Tiene motor?");
        boolean hasMotor = sc.nextLine().equalsIgnoreCase("si");
        System.out.println("Dime la fecha");
        final LocalDate fechaFab = LocalDate.parse(sc.nextLine());
        System.out.println("Dime el precio");
        float precio = Float.parseFloat(sc.nextLine());


        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] == null) {
                bicisModelos[i] = new Bicicleta(referencia, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);
                stock[i] = 1;
                return;
            }
        }
        System.out.println("No hay espacio");

    }

    public void venderBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] != null && bicisModelos[i].getREF() == ref && stock[i] > 0) {
                stock[i]--;
                System.out.println("Bicicleta " + bicisModelos[i].getModelo() + " vendida correctamente");
                return;
            }
        }
        System.out.println("No hay stock o no hemos podido encontar la referencia");

    }

    public void mostrarStock() {
        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] != null) {
                System.out.println("Stock de: " + bicisModelos[i].getModelo() + "= " + stock[i]);
            }

        }
    }

    public void consultaReferencia(Scanner sc) {
        System.out.println("Dime la nueva referencia");
        int referencia = Integer.parseInt(sc.nextLine());

        for (Bicicleta bici : bicisModelos) {
            if (bici != null && bici.getREF() == referencia) {
                System.out.println(bici);
                return;
            }
        }
        System.out.println("Bicicleta no encontrada");
    }

    public void consultaPorMarca(Scanner sc) {
        System.out.println("Dime la marca");
        String marca = sc.nextLine();
        for (Bicicleta bici : bicisModelos) {
            if (bici != null) {
                System.out.println(bici.getMarca().equalsIgnoreCase(marca) ? bici : "");
            }
        }

    }

    public void consultaPorModelo(Scanner sc) {
        System.out.println("Dime el modelo");
        String modelo = sc.nextLine();
        for (Bicicleta bici : bicisModelos) {
            if (bici != null) {
                System.out.println(bici.getModelo().equalsIgnoreCase(modelo) ? bici : "");
            }
        }

    }

    public void rellenarTienda(Scanner sc) {
        Random rnd = new Random();
        System.out.println("Dime 3 marcas random");
        String marca1 = sc.nextLine();
        String marca2 = sc.nextLine();
        String marca3 = sc.nextLine();
        System.out.println("Dime cantidad por marca , maximo capacidad de tu tienda");
        int marca1c = sc.nextInt();
        if (marca1c < bicisModelos.length) {

            for (int i = 0; i < marca1c; i++) {
                bicisModelos[i] = new Bicicleta(i, marca1, "v" + i, 50, 5, true,
                        LocalDate.now(), 500);
                stock[i] = rnd.nextInt(11);
            }
        }
        System.out.println("para la marca2?");
        int marca2c = sc.nextInt();
        if (marca2c < bicisModelos.length - marca1c) {

            for (int i = marca1c; i < marca1c + marca2c; i++) {
                bicisModelos[i] = new Bicicleta(i, marca2, "v" + i, 50, 5, true,
                        LocalDate.now(), 500);
                stock[i] = rnd.nextInt(11);
            }
        }
        System.out.println("para la marca3?");
        int marca3c = sc.nextInt();
        if (marca3c < bicisModelos.length - (marca1c + marca2c)) {

            for (int i = marca1c + marca2c; i < marca1c + marca2c + marca3c; i++) {
                bicisModelos[i] = new Bicicleta(i, marca3, "v" + i, 50, 5, true,
                        LocalDate.now(), 500);
                stock[i] = rnd.nextInt(11);
            }
        }

    }


    public static int menuConsultas(Scanner sc) {
        System.out.println("***********************\n" +
                "** CONSULTA BICICLETA **\n" +
                "***********************\n" +
                "1.- Consultar por referencia …\n" +
                "2.- Consultar por marca …\n" +
                "3.- Consultar por modelo …\n" +
                "---------------------------------\n" +
                "0.- Volver al menú principal");
        return Integer.parseInt(sc.nextLine());
    }

    public static int menuBicis(Scanner sc) {
        System.out.println("El programa debe mostrar un menú similar al siguiente:\n" +
                "*************************\n" +
                "** GESTIÓN DE BICICLETAS **\n" +
                "*************************\n" +
                "1.- Añadir bicicleta …\n" +
                "2.- Vender bicicleta ...\n" +
                "3.- Consultar bicicleta …\n" +
                "4.- Mostrar stock\n" +
                "------------------------------------\n" +
                "0.- Salir");
        return Integer.parseInt(sc.nextLine());

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TiendaBici tienda1 = new TiendaBici(20);
        tienda1.rellenarTienda(sc);

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


