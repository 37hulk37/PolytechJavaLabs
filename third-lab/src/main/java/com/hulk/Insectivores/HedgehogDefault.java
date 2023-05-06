package com.hulk.Insectivores;

public class HedgehogDefault extends Hedgehogs {
    private double numOfNeedles;
    private String whereLive;

    public HedgehogDefault(String name) {
        super(name);
        this.numOfNeedles = 10e5;
        this.whereLive = "Forests";
    }

    @Override
    public void whereLive() {
        System.out.println(whereLive);
    }

    @Override
    public void NumOfNeedles() {
        System.out.println(numOfNeedles);
    }

    @Override
    public String toString() {
        return whatName();
    }
}
