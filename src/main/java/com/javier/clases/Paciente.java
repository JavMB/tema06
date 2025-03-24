package com.javier.clases;
import java.time.LocalDate;

public class Paciente {

    private final long sip;
    private final String nombre;
    private final char sexo;
    private final LocalDate fechanac;

    public Paciente(long sip, String nombre, char sexo, LocalDate fechanac) {
        if (sip <= 0) {
            throw new IllegalArgumentException("El SIP debe ser un número positivo.");
        }
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacío.");
        }
        if (sexo != 'M' && sexo != 'V') {
            throw new IllegalArgumentException("El sexo debe ser 'M' o 'V'.");
        }

        this.sip = sip;
        this.nombre = nombre;
        this.sexo = sexo;
        this.fechanac = fechanac;
    }

    public long getSip() {
        return sip;
    }

    public String getNombre() {
        return nombre;
    }

    public char getSexo() {
        return sexo;
    }

    public LocalDate getFechanac() {
        return fechanac;
    }

    @Override
    public String toString() {
        return "Paciente{" +
                "sip=" + sip +
                ", nombre='" + nombre + '\'' +
                ", sexo=" + sexo +
                ", fechanac=" + fechanac +
                '}';
    }
}
