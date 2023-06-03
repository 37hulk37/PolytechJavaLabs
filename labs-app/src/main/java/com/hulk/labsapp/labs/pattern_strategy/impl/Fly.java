package com.hulk.labsapp.labs.pattern_strategy.impl;


import javafx.collections.ObservableList;

public class Fly implements Move {
    @Override
    public void move(ObservableList<String> output) {
        output.add("Fly a plane");
    }
}
