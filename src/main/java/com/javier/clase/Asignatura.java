package com.javier.clase;

public class  Asignatura {
    private String nombre;
    private String codigo;
    private int curso;

    // Constructor
    public Asignatura(String nombre, String codigo, int curso) {
        this.nombre = nombre;
        this.codigo = codigo;
        this.curso = curso;
    }

    // Getters y Setters
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCurso() {
        return curso;
    }

    public void setCurso(int curso) {
        this.curso = curso;
    }

    public static void main(String[] args) {

        Asignatura programacion = new Asignatura("Programación", "1017", 1);


        System.out.println("Nombre de la asignatura: " + programacion.getNombre());
        System.out.println("Código de la asignatura: " + programacion.getCodigo());
        System.out.println("Curso de la asignatura: " + programacion.getCurso());
    }
}
