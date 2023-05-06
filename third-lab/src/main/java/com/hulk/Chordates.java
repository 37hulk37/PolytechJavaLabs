package com.hulk;

public abstract class Chordates {
    private boolean hasChordate;
    private String name;

    public Chordates(String name) {
        this.hasChordate = true;
        this.name = name;
    }

    public abstract void eat();
    public abstract void feed();
    public abstract void whereLive();
    public abstract void move();

    public abstract void makeNoise();

    public boolean hasChordate() {
        return hasChordate;
    }

    public String whatName() {
        return name;
    }

    @Override
    public String toString() {
        return whatName();
    }
}