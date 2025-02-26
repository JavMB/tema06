package com.javier.clases;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;



public class TiendaBici {
    private final ItemBicicleta[] bicisModelos;

    //constructor recomendado
    public TiendaBici(int capacidad) {
        this.bicisModelos = new ItemBicicleta[capacidad];
    }

    public void anadirBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());

        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null && bicisModelo.getBicicleta().getREF() == ref) {
                bicisModelo.incrementarStock();
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

        Bicicleta b1 = new Bicicleta(ref, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);


        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] == null) {
                bicisModelos[i] = new ItemBicicleta(b1, 1);
                return;
            }
        }
        System.out.println("No hay espacio");
    }

    public void venderBici(Scanner sc) {
        System.out.println("Dime la referencia");
        int ref = Integer.parseInt(sc.nextLine());

        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null && bicisModelo.getBicicleta().getREF() == ref && bicisModelo.getStock() > 0) {
                bicisModelo.decrementarStock();
                System.out.println("Bicicleta " + bicisModelo.getBicicleta().getModelo() + " vendida correctamente");
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

    public void rellenarTienda() {
        Random rnd = new Random();
        Faker faker = new Faker();

        int capacidad = bicisModelos.length;
        int index = 0;

        for (int i = 0; i < capacidad; i++) {
            String marca = faker.company().name();
            String modelo = faker.commerce().productName();
            float peso = rnd.nextFloat(10) + 5; // Peso aleatorio entre 5 y 15 kg
            float ruedasSize = rnd.nextFloat(4) + 20; // Tamaño de ruedas entre 20 y 24"
            boolean hasMotor = rnd.nextBoolean();
            LocalDate fechaFab = LocalDate.now().minusYears(rnd.nextInt(5)); // Fecha aleatoria en los últimos 5 años
            double precio = faker.number().randomDouble(2, 100, 2000); // Precio entre 100 y 2000$


            Bicicleta bici = new Bicicleta(i, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);
            bicisModelos[i] = new ItemBicicleta(bici, rnd.nextInt(11));

            System.out.println("Añadida bici: " + bici);
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


}