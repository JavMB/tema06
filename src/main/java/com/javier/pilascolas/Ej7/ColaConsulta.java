package com.javier.pilascolas.Ej7;

import java.time.LocalDateTime;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;

public class ColaConsulta {
    private Medico medico;
    private Deque<Paciente> cola; //

    public ColaConsulta(Medico medico) {
        this.medico = medico;
        this.cola = new ArrayDeque<>();
    }

    // añadir un paciente
    public void agregarPaciente(Paciente paciente) {
        cola.addLast(paciente);
    }

    public void llegadaPaciente(Scanner sc) {
        LocalDateTime llegada = LocalDateTime.now();
        System.out.println("Dime tu nombre");
        String nombre = sc.nextLine();

        Paciente p1 = new Paciente(nombre, llegada);
        agregarPaciente(p1);


    }

    // atender al siguiente paciente
    public Paciente atenderPaciente() {
        return cola.pollFirst();
    }


    @Override
    public String toString() {
        return "Consulta{" +
                "medico=" + medico +
                ", pacientes=" + cola.toString() +
                '}';
    }

}
