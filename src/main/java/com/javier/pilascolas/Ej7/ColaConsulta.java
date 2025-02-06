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

    // Método para añadir un paciente al final de la cola
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

    // Método para atender al siguiente paciente (elimina y devuelve el primero de la cola)
    public Paciente atenderPaciente() {
        return cola.pollFirst();
    }

    // Método para ver el siguiente paciente sin quitarlo de la cola
    public Paciente verSiguientePaciente() {
        return cola.peekFirst();
    }

    // Método para ver si la cola está vacía
    public boolean estaVacia() {
        return cola.isEmpty();
    }
}
