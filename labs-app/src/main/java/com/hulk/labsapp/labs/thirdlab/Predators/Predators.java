package com.hulk.labsapp.labs.thirdlab.Predators;

import com.hulk.labsapp.labs.thirdlab.Mammals;

public abstract class Predators extends Mammals {
    private String whatEat;
    private String whatNoise;

    public Predators(String name) {
        super(name);
        this.whatEat = "Meat";
        this.whatNoise = "Rrrrrr";
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
