package com.javier.lib;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class FH {

//******************************** SOLICITAR DATOS ********************************\\

    /**
     * Solicita una fecha escrita en el formato indicado.
     *
     * @param mensaje Mensaje que se imprime para solicitar la fecha.
     * @param formato Formato en que se desea devolver la fecha.
     * @return Es el 'LocalDate' que contiene la fecha en el formato indicado.
     */
    public static LocalDate solicitarFecha(String mensaje,String formato) {
        System.out.println(mensaje);
        String fechaString = Escaner.lector.nextLine();
        return LocalDate.parse(fechaString, DateTimeFormatter.ofPattern(formato));
    }

    /**
     * Solicita una hora escrita en el formato indicado.
     *
     * @param mensaje Mensaje que se imprime para solicitar la hora.
     * @param formato Formato en que se desea devolver la fecha.
     * @return Es el 'LocalTime' que contiene la hora en el formato indicado.
     */
    public static LocalTime solicitarHora(String mensaje, String formato) {
        System.out.println(mensaje);
        String horaString = Escaner.lector.nextLine();
        return LocalTime.parse(horaString, DateTimeFormatter.ofPattern(formato));
    }

    /**
     * Solicita una fecha y una hora escritas en el formato indicado.
     *
     * @param mensaje Mensaje que se imprime para solicitar la fecha y la hora.
     * @param formato Formato en que se desea devolver la fecha.
     * @return Es el 'LocalDateTime' que contiene la fecha y la hora en el formato indicado.
     */
    public static LocalDateTime solicitarFechaHora(String mensaje, String formato) {
        System.out.println(mensaje);
        String fechaHoraString = Escaner.lector.nextLine();
        return LocalDateTime.parse(fechaHoraString, DateTimeFormatter.ofPattern(formato));
    }


//******************************** FORMATEAR DATOS ********************************\\

    /**
     * Recibe una fecha y la formatea en el formato indicado.
     *
     * @param fecha Fecha que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la fecha.
     * @return Devuelve un String de 'fecha' en el formato indicado.
     */
    public static String formatearFecha(LocalDate fecha,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fecha.format(formatter);
    }

    /**
     * Recibe una hora y la formatea en el formato indicado.
     *
     * @param hora Fecha que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la hora.
     * @return Devuelve un String de 'hora' en el formato indicado.
     */
    public static String formatearHora(LocalTime hora,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return hora.format(formatter);
    }

    /**
     * Recibe una fecha y una hora y las formatea en el formato indicado.
     *
     * @param fechaHora Fecha y hora que recibe en cualquier formato.
     * @param formato Formato en que se desea devolver la fecha y la hora.
     * @return Devuelve un String de 'fechaHora' en el formato indicado.
     */
    public static String formatearFechaHora(LocalDateTime fechaHora,String formato){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(formato);
        return fechaHora.format(formatter);
    }
}
