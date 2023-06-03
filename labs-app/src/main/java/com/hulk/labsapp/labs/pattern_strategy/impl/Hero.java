package com.hulk.labsapp.labs.pattern_strategy.impl;

import javafx.collections.ObservableList;

public class Hero {
    private Move move;

    public Move getMove() {
        return move;
    }

    public void setMove(Move Move) {
        this.move = Move;
    }

    public void executeMove(ObservableList<String> output) {
        move.move(output);
    }
}
