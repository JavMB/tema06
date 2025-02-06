package com.javier.pilascolas.Ej7;
import java.time.LocalDateTime;
import java.util.Random;

public class Paciente {
    public Random rnd=new Random();
    private String nombre;
    private String SIP;
    private LocalDateTime llegada;

    public Paciente(String nombre, LocalDateTime llegada) {
        this.nombre = nombre;
        this.SIP = generarSip(rnd);
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




}
