package com.javier.clase;

public class Circunferencia {
    private Punto centro;
    private double radio;

    public Circunferencia(Punto centro, double radio) {
        this.centro = centro;
        this.radio = radio;
    }

    public Circunferencia(double x, double y, double radio) {
        centro = new Punto(x, y);
        this.radio = radio;
    }

    public Circunferencia() {
        this.centro = new Punto(0, 0);
        this.radio = 30;
    }

    public Punto getCentro() {
        return centro;
    }

    public void setCentro(Punto centro) {
        this.centro = centro;
    }

    public double getRadio() {
        return radio;
    }

    public void setRadio(double radio) {
        this.radio = radio;
    }

    public double distancia(Punto p) {
        return centro.distancia(p);
    }

    public double area() {
        return Math.PI * Math.pow(radio, 2);
    }

    public double perimetro() {
        return 2 * Math.PI * radio;
    }

    @Override
    public String toString() {
        if (centro.equals(new Punto(0, 0))) {
            return "Circunferencia de radio" + radio + " cm situada en el origen de cordenadas";

        } else return "Circunferencia de radio " + radio + " cm situado en el punto " + centro;


    }

    public static void main(String[] args) {
        Circunferencia c1 = new Circunferencia(new Punto(3.2, 4.0), 2.5);
        Circunferencia c2 = new Circunferencia(new Punto(0.0, 0.0), 3.2);

        System.out.println("Circunferencia 1 centro: " + c1.getCentro() + "\n" +
                "perimetro: " + c1.perimetro() + "\n" +
                "area: " + c1.area());

        System.out.println();

        System.out.println("Circunferencia 2 centro: " + c2.getCentro() + "\n" +
                "perimetro: " + c2.perimetro() + "\n" +
                "area: " + c2.area());

        System.out.printf("La distancia entre c1 y c2 es : %.2f cm", c1.getCentro().distancia(c2.getCentro()));
    }
}
