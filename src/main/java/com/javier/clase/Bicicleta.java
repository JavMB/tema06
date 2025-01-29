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

}
