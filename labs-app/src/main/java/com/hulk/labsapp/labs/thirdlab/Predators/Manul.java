package com.hulk.labsapp.labs.thirdlab.Predators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Manul extends Feline {
    private String whereLive;
    private List<String> whatEat;
    private String peculiarity;
    public Manul(String name) {
        super(name);
        this.whereLive = "MidAsia";
        this.whatEat = new ArrayList<>(Arrays.asList("Hedgehog", "Rodents", "Berries"));
        this.peculiarity = "dissatisfied";
    }

    @Override
    public void whereLive() {
        System.out.println(whereLive);
    }

    @Override
    public void eat() {
        System.out.println(whatEat);
    }

    @Override
    public String toString() {
        return whatName();
    }
}
