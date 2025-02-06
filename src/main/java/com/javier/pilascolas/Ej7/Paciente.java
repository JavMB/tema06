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

        // Calcular el dígito de control como la suma de los dígitos módulo 10
        int suma = 0;
        int temp = numero;

        while (temp > 0) {
            suma += temp % 10;  // Sumar cada dígito
            temp /= 10;
        }

        int digitoControl = suma % 10; // Último dígito de la suma como dígito de control

        return numero + String.valueOf(digitoControl);
    }




}
