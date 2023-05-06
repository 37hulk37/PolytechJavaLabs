package com.hulk.Predators;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lynx extends Feline {
    private String whereLive;
    private List<String> whatEat;

    public Lynx(String name) {
        super(name);
        this.whereLive = "Forests of Eurasia";
        this.whatEat = new ArrayList<>(Arrays.asList("Rodents", "Birds", "Roe deer"));
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
