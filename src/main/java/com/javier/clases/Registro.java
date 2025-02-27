package com.javier.clases;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Optional;


public class Registro {
    public enum ESTADOS {
        ESPERA,ATENDIDO,ALTA
    }


    private final long id;
    private final Paciente paciente;
    private final ESTADOS estado;
    private final LocalDate fechaEntrada;
    private final LocalTime horaEntrada;
    private final String sintomatologia;

    private final double[] preRev;
    private final Optional<LocalDate> fechaAlta;
    private final Optional<LocalTime> horaAlta;
    private final Optional<String> motivoAlta;

    public Registro(Paciente p, ESTADOS estado, LocalDate fechaEntrada, LocalTime horaEntrada, String sintomatologia, double[] preRev, Optional<LocalDate> fechaAlta, Optional<LocalTime> horaAlta, Optional<String> motivoAlta) {
        this.id = p.getSip();
        this.paciente = p;
        this.estado = estado;
        this.fechaEntrada = fechaEntrada;
        this.horaEntrada = horaEntrada;
        this.sintomatologia = sintomatologia;
        this.preRev = preRev.clone();
        this.fechaAlta = fechaAlta;
        this.horaAlta = horaAlta;
        this.motivoAlta = motivoAlta;
    }

    //constructor para atender , full inmutabilidad
    public Registro(double[] preRev, Registro r, ESTADOS estado) {
        this(r.getPaciente(), estado, r.getFechaEntrada(), r.getHoraEntrada(), r.getSintomatologia(),
                preRev.clone(), r.getFechaAlta(), r.getHoraAlta(), r.getMotivoAlta());
    }
    //constructor para alta
    public Registro(Registro r, LocalDate l, LocalTime t, String motivo, ESTADOS estado) {
        this(r.getPaciente(), estado, r.getFechaEntrada(), r.getHoraEntrada(), r.getSintomatologia(), r.getPreRev(), Optional.ofNullable(l), Optional.ofNullable(t), Optional.ofNullable(motivo));
    }


    public long getId() {
        return id;
    }

    public ESTADOS getEstado() {
        return estado;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDate getFechaEntrada() {
        return fechaEntrada;
    }

    public LocalTime getHoraEntrada() {
        return horaEntrada;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    public double[] getPreRev() {
        return preRev.clone(); // Devuelve una copia en lugar de la referencia original
    }


    public Optional<LocalDate> getFechaAlta() {
        return fechaAlta;
    }

    public Optional<LocalTime> getHoraAlta() {
        return horaAlta;
    }

    public Optional<String> getMotivoAlta() {
        return motivoAlta;
    }
}
