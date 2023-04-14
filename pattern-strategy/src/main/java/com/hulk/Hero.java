package com.hulk;

public class Hero {
    private Move move;

    public Move getMove() {
        return move;
    }

    public void setMove(Move Move) {
        this.move = Move;
    }

    public void executeMove() {
        move.move();
    }
}
