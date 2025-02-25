package com.javier.clase;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

public class TiendaBici {
    static Scanner sc = new Scanner(System.in);
    private final ItemBicicleta[] bicisModelos;

    //constructor recomendado
    public TiendaBici(int capacidad) {
        this.bicisModelos = new ItemBicicleta[capacidad];
    }

    public void anadirBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] != null && bicisModelos[i].getBicicleta().getREF() == ref) {
                bicisModelos[i].incrementarStock();
                System.out.println("Bicicleta encontrada. Stock actualizado.");
                return;
            }
        }
        System.out.println("Referencia no encontrada procediendo a crear nueva...");
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
        LocalDate fechaFab = LocalDate.parse(sc.nextLine());
        System.out.println("Dime el precio");
        float precio = Float.parseFloat(sc.nextLine());

        Bicicleta b1=new Bicicleta(ref,marca,modelo,peso,ruedasSize,hasMotor,fechaFab,precio);


        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] == null) {
                bicisModelos[i] = new ItemBicicleta(b1,1);
                return;
            }
        }
        System.out.println("No hay espacio");
    }

    public void venderBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());

        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] != null && bicisModelos[i].getBicicleta().getREF() == ref && bicisModelos[i].getStock() > 0) {
                bicisModelos[i].decrementarStock();
                System.out.println("Bicicleta " + bicisModelos[i].getBicicleta().getModelo() + " vendida correctamente");
                return;
            }
        }
        System.out.println("No hay stock o no hemos podido encontar la referencia");

    }

    public void mostrarStock() {
        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null) {
                System.out.println(bicisModelo);
            }
        }
    }

    public void consultaReferencia(Scanner sc) {
        System.out.println("Dime la nueva referencia");
        int referencia = Integer.parseInt(sc.nextLine());

        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null && bici.getBicicleta().getREF() == referencia) {
                System.out.println(bici);
                return;
            }
        }
        System.out.println("Bicicleta no encontrada");
    }

    public void consultaPorMarca(Scanner sc) {
        System.out.println("Dime la marca");
        String marca = sc.nextLine();
        boolean encontrada = false;
        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null && bici.getBicicleta().getMarca().equalsIgnoreCase(marca)) {
                System.out.println(bici);
                encontrada = true;
            }
        }
        if (!encontrada) {
            System.out.println("No se ha encontrado ninguna coincidencia");
        }
    }

    public void consultaPorModelo(Scanner sc) {
        System.out.println("Dime el modelo");
        String modelo = sc.nextLine();
        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null) {
                System.out.println(bici.getBicicleta().getModelo().equalsIgnoreCase(modelo) ? bici : "No se ha encontrado ninguna coincidencia");
            }
        }

    }

    public void rellenarTienda(Scanner sc) {
        Random rnd = new Random();
        System.out.println("Dime 3 marcas random...");
        String marca1 = sc.nextLine();
        String marca2 = sc.nextLine();
        String marca3 = sc.nextLine();

        int capacidad = bicisModelos.length;
        int index = 0;

        // Para la primera marca
        System.out.println("Dime cantidad para la marca " + marca1 + " (máximo: " + (capacidad - index) + "):");
        int cantidad1 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cantidad1 && index < capacidad; i++, index++) {
            Bicicleta bici = new Bicicleta(index, marca1, "v" + index, 50, 5, true, LocalDate.now(), 500);
            bicisModelos[index] = new ItemBicicleta(bici, rnd.nextInt(11));
        }

        // Para la segunda marca
        System.out.println("Dime cantidad para la marca " + marca2 + " (máximo: " + (capacidad - index) + "):");
        int cantidad2 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cantidad2 && index < capacidad; i++, index++) {
            Bicicleta bici = new Bicicleta(index, marca2, "v" + index, 50, 5, true, LocalDate.now(), 500);
            bicisModelos[index] = new ItemBicicleta(bici, rnd.nextInt(11));
        }

        // Para la tercera marca
        System.out.println("Dime cantidad para la marca " + marca3 + " (máximo: " + (capacidad - index) + "):");
        int cantidad3 = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < cantidad3 && index < capacidad; i++, index++) {
            Bicicleta bici = new Bicicleta(index, marca3, "v" + index, 50, 5, true, LocalDate.now(), 500);
            bicisModelos[index] = new ItemBicicleta(bici, rnd.nextInt(11));
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
        return Integer.parseInt(sc.nextLine());
    }

    public static void main(String[] args) {
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