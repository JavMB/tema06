package com.javier.clases;
import static com.javier.clases.DataGenerator.faker;

public class Paciente {

    private final long sip;
    private final String nombre;
    private final char sexo;
    private final int edad;

    public Paciente(String nombre, char sexo, int edad) {
        this.sip = Integer.parseInt(faker.number().digits(10));
        this.nombre = nombre;
        this.sexo = sexo;
        this.edad = edad;
    }

    public Paciente(Paciente p) {
        this(p.getNombre(),p.getSexo(),p.edad);
    }

    public int getEdad() {
        return edad;
    }

    public char getSexo() {
        return sexo;
    }

    public String getNombre() {
        return nombre;
    }

    public long getSip() {
        return sip;
    }
}
