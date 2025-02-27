package com.javier.clases;
import net.datafaker.Faker;
import java.time.LocalDate;
import java.util.Random;

public class TiendaBici {
    private final ItemBicicleta[] bicisModelos;

    public TiendaBici(int capacidad) {
        this.bicisModelos = new ItemBicicleta[capacidad];
    }

    public boolean anadirBici(int ref, String marca, String modelo, float peso,
                              float ruedasSize, boolean hasMotor, LocalDate fechaFab, float precio) {
        // Verificar si la bicicleta ya existe
        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null && bicisModelo.getBicicleta().getREF() == ref) {
                bicisModelo.incrementarStock();
                return true;
            }
        }

        // Crear nueva bicicleta
        Bicicleta b1 = new Bicicleta(ref, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);

        // Añadir la bicicleta al array
        for (int i = 0; i < bicisModelos.length; i++) {
            if (bicisModelos[i] == null) {
                bicisModelos[i] = new ItemBicicleta(b1, 1);
                return true;
            }
        }
        return false; // No hay espacio
    }

    public boolean venderBici(int ref) {
        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null && bicisModelo.getBicicleta().getREF() == ref && bicisModelo.getStock() > 0) {
                bicisModelo.decrementarStock();
                return true;
            }
        }
        return false;
    }

    public String getModeloVendido(int ref) {
        for (ItemBicicleta bicisModelo : bicisModelos) {
            if (bicisModelo != null && bicisModelo.getBicicleta().getREF() == ref) {
                return bicisModelo.getBicicleta().getModelo();
            }
        }
        return null;
    }

    public ItemBicicleta[] getStock() {
        return bicisModelos;
    }

    public ItemBicicleta consultaReferencia(int referencia) {
        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null && bici.getBicicleta().getREF() == referencia) {
                return bici;
            }
        }
        return null;
    }

    public ItemBicicleta[] consultaPorMarca(String marca) {
        ItemBicicleta[] resultado = new ItemBicicleta[bicisModelos.length];
        int index = 0;

        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null && bici.getBicicleta().getMarca().equalsIgnoreCase(marca)) {
                resultado[index++] = bici;
            }
        }

        return resultado;
    }

    public ItemBicicleta[] consultaPorModelo(String modelo) {
        ItemBicicleta[] resultado = new ItemBicicleta[bicisModelos.length];
        int index = 0;

        for (ItemBicicleta bici : bicisModelos) {
            if (bici != null && bici.getBicicleta().getModelo().equalsIgnoreCase(modelo)) {
                resultado[index++] = bici;
            }
        }

        return resultado;
    }

    public void rellenarTienda() {
        Random rnd = new Random();
        Faker faker = new Faker();

        int capacidad = bicisModelos.length;

        for (int i = 0; i < capacidad; i++) {
            String marca = faker.company().name();
            String modelo = faker.commerce().productName();
            float peso = rnd.nextFloat(10) + 5;
            float ruedasSize = rnd.nextFloat(4) + 20;
            boolean hasMotor = rnd.nextBoolean();
            LocalDate fechaFab = LocalDate.now().minusYears(rnd.nextInt(5));
            double precio = faker.number().randomDouble(2, 100, 2000);

            Bicicleta bici = new Bicicleta(i, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio);
            bicisModelos[i] = new ItemBicicleta(bici, rnd.nextInt(11));
        }
    }
}
