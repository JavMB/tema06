package com.javier.ejercicios;
import com.javier.clases.Asignatura;

public class Ej2 {
    public static void main(String[] args) {
        Asignatura a1 = new Asignatura("Programación", "1017", 1);


        System.out.println("Nombre de la asignatura: " + a1.getNombre());
        System.out.println("Código de la asignatura: " + a1.getCodigo());
        System.out.println("Curso de la asignatura: " + a1.getCurso());
    }
}
