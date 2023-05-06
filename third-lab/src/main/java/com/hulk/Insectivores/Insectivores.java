package com.hulk.Insectivores;

import com.hulk.Mammals;

public abstract class Insectivores extends Mammals {
    private String whatEat;
    private String whatNoise;

    public Insectivores(String name) {
        super(name);
        this.whatEat = "Insects";
        this.whatNoise = "Shhh.....";
    }

    @Override
    public void eat() {
        System.out.println(whatEat);
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
