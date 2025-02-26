package com.javier.clase;

import java.time.LocalDate;

public class Alumno {
    private final String nia;
    private final String nombre;
    private final String apellido;
    private final LocalDate fechanacimiento;
    private final int grupo;
    private final long telefono;

    public Alumno(String nia, String nombre, String apellido, LocalDate fechanacimiento, int grupo, long telefono) {
        this.nia = nia;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechanacimiento = fechanacimiento;
        this.grupo = grupo;
        this.telefono = telefono;
    }

    public String getNia() {
        return nia;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public LocalDate getFechanacimiento() {
        return fechanacimiento;
    }


    public int getGrupo() {
        return grupo;
    }


    public long getTelefono() {
        return telefono;
    }


}

