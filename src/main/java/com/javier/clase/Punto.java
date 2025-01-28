package com.javier.clase;

import java.util.Objects;

public class Punto {
    private double x;
    private double y;

    public Punto(double x, double y) {
        this.x = x;
        this.y = y;
    }
    public Punto(){
        this.x = 0;
        this.y = 0;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double distancia(Punto punto) {
        return Math.sqrt(Math.pow(punto.getX() - this.x, 2) + Math.pow(punto.getY() - this.y, 2));
    }

    @Override
    public String toString() {
        return "("+x+","+y+")";
    }
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return Double.compare(x, punto.x) == 0 && Double.compare(y, punto.y) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public static void main(String[] args) {
        Punto p1=new Punto(2.0,6.2);
        Punto p2=new Punto(4.0,12.2);

        System.out.println(p1+" "+p2);

    }


}
