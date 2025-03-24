package com.javier.clases;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class Hospital {

    private int contador;
    private final Entrada[] sistema;

    public Hospital(int size) {
        this.sistema = new Entrada[size];
        this.contador = 0;
    }


    public boolean agregarPaciente(long sip, String nombre, char sexo, LocalDate fechaNac, String sintomas) {
        Paciente obtenido = obtenerPacienteAtendible(sip).getPaciente();
        if (contador < sistema.length) {
            if (obtenido.getSip() == 0) {
                sistema[contador++] = new Entrada(new Paciente(sip, nombre, sexo, fechaNac), LocalDateTime.now(), sintomas, null, null);
                return true;
            } else {
                sistema[contador++] = new Entrada(obtenido, LocalDateTime.now(), sintomas, null, null);
                return true;
            }
        }
        return false;
    }

    public Entrada atenderPaciente(long sip, double[] preRev) {
        Entrada pacienteAtendible = obtenerPacienteAtendible(sip);
        pacienteAtendible.setPreRev(preRev);

        return new Entrada(pacienteAtendible);
    }

    public boolean darDeAltaAPaciente(long sip, String motivoDeAlta) {
        Entrada pacienteAtendible = obtenerPacienteAtendible(sip);
        pacienteAtendible.setMotivoAlta(motivoDeAlta);
        pacienteAtendible.setFechaAlta(LocalDateTime.now());

        if (pacienteAtendible.getPaciente() != null) {
            return pacienteAtendible.getPaciente().getSip() != 0;
        } else return false;

    }


    public Entrada obtenerPacienteAtendible(long sip) {
        Entrada entradaMismoSip = getPacientePorSip(sip);

        if (entradaMismoSip != null && entradaMismoSip.getFechaAlta() == null) {
            return entradaMismoSip;
        }

        return new Entrada();
    }


    public Entrada getPacientePorSip(long sip) {

        for (int i = 0; i < contador; i++) {
            if (sistema[i] == null) continue;
            if (sistema[i].getPaciente().getSip() == sip) {
                return sistema[i];
            }
        }
        return null;
    }


}
