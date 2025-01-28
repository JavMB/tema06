package com.javier.clase;
import java.time.LocalDate;

public class Coche {

    // Enums
    public enum TipoCoche {
        MINI,
        UTILITARIO,
        FAMILIAR,
        DEPORTIVO
    }

    public enum Seguro {
        TERCEROS, TODORIESGO
    }

    // Atributos
    private String modelo;
    private String color;
    private boolean esMetalizada;
    private String matricula;
    private TipoCoche tipo;
    private LocalDate fechaFabricacion;
    private Seguro seguro;

    // Constructor sin parámetros
    public Coche() {
        this("BMW", "rojo", false, "0000", TipoCoche.UTILITARIO, LocalDate.now(), Seguro.TODORIESGO);
    }

    // Constructor con parámetros
    public Coche(String modelo, String color, boolean esMetalizada, String matricula, TipoCoche tipo, LocalDate fechaFabricacion, Seguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.esMetalizada = esMetalizada;
        this.matricula = matricula;
        this.tipo = tipo;
        this.fechaFabricacion = fechaFabricacion;
        this.seguro = seguro;
    }

    // Getters y setters
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isEsMetalizada() {
        return esMetalizada;
    }

    public void setEsMetalizada(boolean esMetalizada) {
        this.esMetalizada = esMetalizada;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public TipoCoche getTipo() {
        return tipo;
    }

    public void setTipo(TipoCoche tipo) {
        this.tipo = tipo;
    }

    public LocalDate getFechaFabricacion() {
        return fechaFabricacion;
    }

    public void setFechaFabricacion(LocalDate fechaFabricacion) {
        this.fechaFabricacion = fechaFabricacion;
    }

    public Seguro getSeguro() {
        return seguro;
    }

    public void setSeguro(Seguro seguro) {
        this.seguro = seguro;
    }

    // Método toString
    @Override
    public String toString() {
        return "Coche{" +
                "modelo='" + modelo + '\'' +
                ", color='" + color + '\'' +
                ", esMetalizada=" + esMetalizada +
                ", matricula='" + matricula + '\'' +
                ", tipo=" + tipo +
                ", fechaFabricacion=" + fechaFabricacion +
                ", seguro=" + seguro +
                '}';
    }
}
