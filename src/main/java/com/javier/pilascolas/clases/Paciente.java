package com.javier.pilascolas.clases;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class Paciente {
    private final String nombre;
    private final String SIP;
    private LocalDateTime llegada;

    public Paciente(String nombre, LocalDateTime llegada) {
        this.nombre = nombre;
        this.SIP = generarSip(Medico.rnd);
        this.llegada = llegada;
    }

    public static String generarSip(Random rnd) {

        int numero = rnd.nextInt(100000000, 999999999);


        int suma = 0;
        int temp = numero;

        while (temp > 0) {
            suma += temp % 10;
            temp /= 10;
        }

        int digitoControl = suma % 10;

        return numero + String.valueOf(digitoControl);
    }

    @Override
    public String toString() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        return String.format("%-10s %-12s %s", nombre, SIP, llegada.format(formato));
    }
}
