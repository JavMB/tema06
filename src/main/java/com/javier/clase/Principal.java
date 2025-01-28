package com.javier.clase;


public class Principal {
    public static void main(String[] args) {
        Coche coche1 = new Coche();
        Coche coche2 = new Coche("Dacia", "rojo", false, "00000", Coche.TipoCoche.DEPORTIVO, java.time.LocalDate.now(), Coche.Seguro.TERCEROS);

        System.out.println(coche1);
        System.out.println(coche2);


        coche2.setColor("verde");


        System.out.println(coche2);


        System.out.println("Color del coche actualizado: " + coche2.getColor());
    }
}
