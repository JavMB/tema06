package com.javier.clase;
import java.time.LocalDate;

public class Bicicleta {
    private final int REF;
    private String marca;
    private String modelo;
    private float peso;
    private float ruedasSize;
    private boolean hasMotor;
    private final LocalDate fechaFab;
    private float precio;

    public Bicicleta(int REF, String marca, String modelo, float peso, float ruedasSize, boolean hasMotor, LocalDate fechaFab, float precio) {
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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public float getRuedasSize() {
        return ruedasSize;
    }

    public void setRuedasSize(float ruedasSize) {
        this.ruedasSize = ruedasSize;
    }

    public boolean isHasMotor() {
        return hasMotor;
    }

    public void setHasMotor(boolean hasMotor) {
        this.hasMotor = hasMotor;
    }

    public LocalDate getFechaFab() {
        return fechaFab;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
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