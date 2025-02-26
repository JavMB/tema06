package com.javier.pilascolas.clases;

import com.javier.pilascolas.colecciones.Cola;

import java.time.LocalDateTime;
import java.util.Scanner;

public class ColaConsulta {
    private Medico medico;
    private Cola<Paciente> cola; //

    public ColaConsulta(Medico medico) {
        this.medico = medico;
        this.cola = new Cola<>();
    }
    // añadir un paciente
    public void agregarPaciente(Paciente paciente) {
        cola.enqueue(paciente);
        System.out.println("Paciente agregado correctamente");
    }
    public void llegadaPaciente(Scanner sc) {
        LocalDateTime llegada = LocalDateTime.now();
        System.out.println("Dime tu nombre");
        String nombre = sc.nextLine();

        Paciente p1 = new Paciente(nombre, llegada);
        agregarPaciente(p1);
    }
    public void llegadaPaciente(String nombre) {
        LocalDateTime llegada = LocalDateTime.now();
        Paciente p1 = new Paciente(nombre, llegada);
        agregarPaciente(p1);
    }
    // atender al siguiente paciente
    public Paciente atenderPaciente() {
        return cola.dequeue();
    }
    @Override
    public String toString() {
        return "Medico: "+medico+
                " "+cola;
    }
}
