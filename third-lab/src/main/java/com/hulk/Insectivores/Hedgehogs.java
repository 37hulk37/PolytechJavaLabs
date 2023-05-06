package com.hulk.Insectivores;

public abstract class Hedgehogs extends Insectivores {
    private String howMove;

    public Hedgehogs(String name) {
        super(name);
        this.howMove = "Quiet";
    }
    public abstract void NumOfNeedles();

    @Override
    public void move() {
        System.out.println(howMove);
    }

    @Override
    public String toString() {
        return whatName();
    }
}
