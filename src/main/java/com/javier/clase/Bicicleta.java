package com.javier.clase;
import java.time.LocalDate;

/**
 * Representa una bicicleta con sus características básicas.
 */
public class Bicicleta {
    private final int REFERENCIA;
    private String marca;
    private String modelo;
    private float peso;
    private float ruedasSize;
    private boolean tieneMotor;
    private final LocalDate fechaFab;
    private float precio;

    /**
     * Constructor que inicializa una nueva bicicleta con todos sus atributos.
     * 
     * @param REFERENCIA    Número único de referencia
     * @param marca        Marca de la bicicleta
     * @param modelo       Modelo específico
     * @param peso        Peso en kilogramos
     * @param ruedasSize  Tamaño de las ruedas en pulgadas
     * @param tieneMotor  Si tiene asistencia eléctrica
     * @param fechaFab    Fecha de fabricación
     * @param precio      Precio en euros
     * @throws IllegalArgumentException si algún parámetro no es válido
     */
    public Bicicleta(int REFERENCIA, String marca, String modelo, float peso, 
                     float ruedasSize, boolean tieneMotor, LocalDate fechaFab, float precio) {
        if (REFERENCIA <= 0) {
            throw new IllegalArgumentException("La referencia debe ser positiva");
        }
        if (marca == null || marca.trim().isEmpty()) {
            throw new IllegalArgumentException("La marca no puede estar vacía");
        }
        if (modelo == null || modelo.trim().isEmpty()) {
            throw new IllegalArgumentException("El modelo no puede estar vacío");
        }
        if (peso <= 0) {
            throw new IllegalArgumentException("El peso debe ser positivo");
        }
        if (ruedasSize <= 0) {
            throw new IllegalArgumentException("El tamaño de ruedas debe ser positivo");
        }
        if (fechaFab == null) {
            throw new IllegalArgumentException("La fecha de fabricación no puede ser nula");
        }
        if (fechaFab.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de fabricación no puede ser futura");
        }
        if (precio < 0) {
            throw new IllegalArgumentException("El precio no puede ser negativo");
        }

        this.REFERENCIA = REFERENCIA;
        this.marca = marca.trim();
        this.modelo = modelo.trim();
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
                        "Referencia:           %-15d%n" +
                        "Marca:                %-15s%n" +
                        "Modelo:               %-15s%n" +
                        "Peso:                 %-15.2f kg%n" +
                        "Tamaño de Ruedas:     %-15.1f%n" +
                        "Tiene Motor:          %-15b%n" +
                        "Fecha de Fabricación: %-15s%n" +
                        "Precio:               %-15.2f €%n" +
                        "----------------------------------------",
                REFERENCIA, marca, modelo, peso, ruedasSize, tieneMotor, fechaFab, precio
        );
    }
}
