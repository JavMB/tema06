package com.javier.pilascolas.clases;
import java.util.Random;

public class Medico {
    public static final Random rnd=new Random();

    private static final int maxNumsCol=6;
    private final String nombre;
    private String numeroColegiado;

    public Medico(String nombre) {
        this.nombre = nombre;
        this.numeroColegiado = String.valueOf(rnd.nextInt(1000000));
    }

    @Override
    public String toString() {
        return nombre;
    }
}
