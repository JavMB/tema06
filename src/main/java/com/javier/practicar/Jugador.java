package com.javier.practicar;

public class Jugador {
    private String nombre;
    private int portero;
    private int defensa;
    private int pase;
    private int regate;
    private int tiro;
    private int estadoForma;

    public Jugador(String nombre, int portero, int defensa, int pase, int regate, int tiro, int estadoForma) {
        this.portero = portero;
        this.defensa = defensa;
        this.pase = pase;
        this.regate = regate;
        this.tiro = tiro;
        this.estadoForma = estadoForma;
        this.nombre = nombre;
    }

    public Jugador(String nombre) {
        this(nombre, 50, 50, 50, 50, 50, 50);

    }

    public void entrenar() {
        this.defensa++;
        this.pase++;
        this.regate++;
        this.tiro++;
        this.estadoForma++;
    }

    public void regatear(Jugador regateado) {
        if (this.regate > regateado.defensa) {
            System.out.println("Regate exitoso");
        } else System.out.println("Regate fallido");

    }

    public void chutar(Jugador portero) {
        if (this.tiro > portero.portero) {
            System.out.println("GOL");
        } else System.out.println("Parada!");

    }



    public static void main(String[] args) {
        Jugador futbolista1 = new Jugador("Aitana Bonmatí", 32, 82, 87, 80, 82, 95);
        Jugador futbolista2 = new Jugador("Pablo Gavi", 32, 82, 87, 80, 82, 95);
        Jugador futbolista3 = new Jugador("Ana García");
        Jugador futbolista4 = new Jugador("Rubén Prieto");
    }


}
