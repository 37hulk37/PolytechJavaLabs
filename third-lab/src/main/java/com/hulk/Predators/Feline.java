package com.hulk.Predators;

public abstract class Feline extends Predators {
    private String howMove;
    private String whatNoise;

    public Feline(String name) {
        super(name);
        this.howMove = "Quiet and deftly";
        this.whatNoise = "Meow or RRRRRR";
    }

    @Override
    public void move() {
        System.out.println(howMove);
    }

    @Override
    public void makeNoise() {
        System.out.println(whatNoise);
    }

    @Override
    public String toString() {
        return whatName();
    }
}
