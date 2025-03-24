package com.javier.clases;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;

public class Entrada {
    private final Paciente paciente;
    private final LocalDateTime fechaLlegada;
    private final String sintomatologia;
    private double[] preRev;
    private LocalDateTime fechaAlta;
    private String motivoAlta;

    public Entrada(Paciente paciente, LocalDateTime fechaLlegada, String sintomatologia, LocalDateTime fechaAlta, String motivoAlta) {
        this.paciente = paciente;
        this.fechaLlegada = fechaLlegada;
        this.sintomatologia = sintomatologia;
        this.preRev = new double[4];
        this.fechaAlta = fechaAlta;
        this.motivoAlta = motivoAlta;
    }

    public Entrada(Entrada e) {
        this(e.getPaciente(), e.getFechaLlegada(), e.getSintomatologia(), e.getFechaAlta(), e.getMotivoAlta());
    }
    //corregir default builders
    public Entrada() {
        this(new Paciente(0, "", '\u0000', null), null, null, null, "Sin motivo");
    }


    public Paciente getPaciente() {
        return paciente;
    }

    public LocalDateTime getFechaLlegada() {
        return fechaLlegada;
    }

    public String getSintomatologia() {
        return sintomatologia;
    }

    public LocalDateTime getFechaAlta() {
        return fechaAlta;
    }

    public String getMotivoAlta() {
        return motivoAlta;
    }

    public int getEdad() {
        return Period.between(paciente.getFechanac(), LocalDate.now()).getYears();
    }

    public void setMotivoAlta(String motivoAlta) {
        this.motivoAlta = motivoAlta;
    }

    public void setPreRev(double[] preRev) {
        for (int i = 0; i < this.preRev.length; i++) {
            this.preRev[i] = preRev[i];
        }
    }

    public void setFechaAlta(LocalDateTime fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @Override
    public String toString() {
        return "{" + "paciente=" + paciente + '}';
    }
}
