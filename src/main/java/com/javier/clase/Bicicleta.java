package com.javier.clase;
import java.time.LocalDate;

public class Bicicleta {
    private final int REFERENCIA;
    private String marca;
    private String modelo;
    private float peso;
    private float ruedasSize;
    private boolean tieneMotor;
    private final LocalDate fechaFab;
    private float precio;

    public Bicicleta(int REFERENCIA, String marca, String modelo, float peso, float ruedasSize, boolean tieneMotor, LocalDate fechaFab, float precio) {
        this.REFERENCIA = REFERENCIA;
        this.marca = marca;
        this.modelo = modelo;
        this.peso = peso;
        this.ruedasSize = ruedasSize;
        this.tieneMotor = tieneMotor;
        this.fechaFab = fechaFab;
        this.precio = precio;
    }


    public int getReferencia() {
        return REFERENCIA;
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

    public boolean tieneMotor() {
        return tieneMotor;
    }

    public void setTieneMotor(boolean tieneMotor) {
        this.tieneMotor = tieneMotor;
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
                        "Referencia:           %-10d%n" +
                        "Marca:                %-10s%n" +
                        "Modelo:               %-10s%n" +
                        "Peso:                 %-10.2f kg%n" +
                        "Tamaño de Ruedas:     %-10.1f%n" +
                        "Tiene Motor:          %-10b%n" +
                        "Fecha de Fabricación: %-10s%n" +
                        "Precio:               %-10.2f €%n" +
                        "----------------------------------------",
                REFERENCIA, marca, modelo, peso, ruedasSize, tieneMotor, fechaFab, precio
        );
    }
}
