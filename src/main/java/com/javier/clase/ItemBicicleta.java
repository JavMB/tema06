package com.javier.clase;

public class ItemBicicleta {
    private final Bicicleta bicicleta;
    private int stock;

    public ItemBicicleta(Bicicleta bicicleta, int stock) {
        this.bicicleta = bicicleta;
        this.stock = stock;
    }

    public Bicicleta getBicicleta() {
        return bicicleta;
    }

    public int getStock() {
        return stock;
    }

    public void incrementarStock() {
        stock++;
    }

    public void decrementarStock() {
        if(stock > 0) {
            stock--;
        } else {
            throw new IllegalStateException("Stock insuficiente");
        }
    }

    @Override
    public String toString() {
        return bicicleta.toString() + " Stock: " + stock;
    }
}
