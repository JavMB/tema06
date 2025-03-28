package com.javier.clases;
import java.time.LocalDate;

public class Bicicleta {
    private final int REF;
    private final String marca;
    private final String modelo;
    private final float peso;
    private final float ruedasSize;
    private final boolean hasMotor;
    private final LocalDate fechaFab;
    private final double precio;

    public Bicicleta(int REF, String marca, String modelo, float peso, float ruedasSize, boolean hasMotor, LocalDate fechaFab, double precio) {
        this.REF = REF;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.ruedasSize = ruedasSize;
        this.hasMotor = hasMotor;
        this.fechaFab = fechaFab;
        this.precio = precio;
    }


    public int getREF() {
        return REF;
    }

    public String getMarca() {
        return marca;
    }


    public String getModelo() {
        return modelo;
    }


    public float getPeso() {
        return peso;
    }


    public float getRuedasSize() {
        return ruedasSize;
    }


    public boolean isHasMotor() {
        return hasMotor;
    }


    public LocalDate getFechaFab() {
        return fechaFab;
    }

    public double getPrecio() {
        return precio;
    }


    @Override
    public String toString() {
        return String.format(
                "----------------------------------------%n" +
                        "REF:                  %s%n" +
                        "Marca:                %s%n" +
                        "Modelo:               %s%n" +
                        "Peso:                 %.2f kg%n" +
                        "Tamaño de Ruedas:     %f%n" +
                        "Tiene Motor:          %b%n" +
                        "Fecha de Fabricación: %s%n" +
                        "Precio:               %.2f €%n" +
                        "----------------------------------------",
                REF, marca, modelo, peso, ruedasSize, hasMotor, fechaFab, precio
        );
    }
}