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
    private static int cont = 0;
    private String modelo;
    private String color;
    private boolean esMetalizada;
    private String matricula;
    private TipoCoche tipo;
    private LocalDate fechaFabricacion;
    private Seguro seguro;

    // Constructor sin parámetros
    public Coche() {
        this("BMW", "rojo", false, TipoCoche.UTILITARIO, LocalDate.now(), Seguro.TODORIESGO);
    }

    // Constructor con parámetros
    public Coche(String modelo, String color, boolean esMetalizada, TipoCoche tipo, LocalDate fechaFabricacion, Seguro seguro) {
        this.modelo = modelo;
        this.color = color;
        this.esMetalizada = esMetalizada;
        this.tipo = tipo;
        this.fechaFabricacion = fechaFabricacion;
        this.seguro = seguro;
        this.matricula = nextMatricula();
    }

    public String nextMatricula() {
        if (cont >= 99999999) {
            cont = 0; // Reiniciar contador si se alcanza el límite
        }
        int numero = cont % 10000;
        int letra = cont / 10000;
        String numeroStr = String.format("%04d", numero);
        String letraStr = valorALetra(letra);
        cont++;
        return numeroStr + letraStr;
    }

    private String valorALetra(int valor) {
        StringBuilder sb = new StringBuilder();
        // Generar las letras
        for (int i = 0; i < 3; i++) {
            int resto = valor % 26;
            sb.insert(0, (char)('A' + resto));
            valor /= 26;
            if (valor == 0) break;
        }
        
        // Rellenar con 'A' si es necesario
        while (sb.length() < 3) {
            sb.insert(0, 'A');
        }
        
        return sb.toString();
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

    public boolean isMetalizada() {
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
