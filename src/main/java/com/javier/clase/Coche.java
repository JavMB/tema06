package com.javier.clase;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class Coche {

    public enum TipoCoche {
        MINI,
        UTILITARIO,
        FAMILIAR,
        DEPORTIVO
    }

    public enum Seguro {
        TERCEROS, TODORIESGO
    }


    private static int cont = 0;
    private String modelo;
    private String color;
    private boolean esMetalizada;
    private String matricula;
    private TipoCoche tipo;
    private LocalDate fechaFabricacion;
    private Seguro seguro;


    public Coche() {
        this("BMW", "rojo", false, TipoCoche.UTILITARIO, LocalDate.now(), Seguro.TODORIESGO);
    }


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

    @Override
    public String toString() {
        return "Coche{" +
                "seguro=" + seguro +
                ", fechaFabricacion=" + fechaFabricacion +
                ", tipo=" + tipo +
                ", matricula='" + matricula + '\'' +
                ", esMetalizada=" + esMetalizada +
                ", color='" + color + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }

    public static void main(String[] args) {
        Coche c1=new Coche();
        System.out.println(c1.getColor());
    }
}
