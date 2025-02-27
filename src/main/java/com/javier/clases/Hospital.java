package com.javier.clases;

import java.time.LocalDate;

public class Hospital {
    private final static int MAXDIA=40;
    private final Registro[] registro;
    private int cont;


    public Hospital(int cantidad) {
        this.registro = new Registro[cantidad];
    }

    private boolean addPaciente(Registro r) {
        if ((validarPaciente(r, Registro.ESTADOS.ESPERA))&&(cont<registro.length)){
            registro[cont++]=new Registro(r.getPaciente(),r.getEstado(), LocalDate.now(),r.getHoraEntrada(),r.getSintomatologia(),r.getPreRev(),r.getFechaAlta(),r.getHoraAlta(),r.getMotivoAlta());
            return true;
        }
        return false;
    }
    public boolean atenderPaciente(Registro r){
        if (validarPaciente(r, Registro.ESTADOS.ATENDIDO));

    }

    
    
    private boolean validarPaciente(Registro r, Registro.ESTADOS estado) {
        Registro t;
        for (int i = 0; i < cont; i++) {
            t = registro[i];
            if (r.getId() == t.getId()) {
                if (t.getEstado() == estado && t.getFechaEntrada().equals(r.getFechaEntrada()))
                    return false;
            }
        }
        return true;
    }




    public Registro[] getRegistro() {
        return registro;
    }

}
