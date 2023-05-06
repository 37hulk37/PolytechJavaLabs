package com.hulk;

public abstract class Mammals extends Chordates {
    private String whatFeed;

    public Mammals(String name) {
        super(name);
        this.whatFeed = "Milk";
    }

    @Override
    public void feed() {
        System.out.println(whatFeed);
    }

    @Override
    public String toString() {
        return whatName();
    }
}