package com.megacorp.ecs;

public class Perpend {

    protected int quantity;

    public Perpend() {
        this.quantity = 0;
    }

    public int getQuantity() {
        return quantity;
    }

    public void addQuantity(int quantity) {
        this.quantity = this.quantity + quantity;
    }

    public void show() {
        System.out.println(" - " + quantity + " perpend palets");
    }
}
