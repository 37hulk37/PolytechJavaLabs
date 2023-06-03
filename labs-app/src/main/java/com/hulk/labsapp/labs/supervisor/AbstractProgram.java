package com.hulk.labsapp.labs.supervisor;

import java.util.Random;

public class AbstractProgram implements Runnable {
    private State state;
    private static Random random;
    private boolean valueSet;

    public AbstractProgram() {
        this.state = State.UNKNOWN;
        random = new Random();
        this.valueSet = false;
    }

    @Override
    public synchronized void run() {
        try {
            while (!Thread.currentThread().isInterrupted()) {
                synchronized (this) {
                    while (valueSet) {
                        wait();
                    }
                }
                changeState();
                valueSet = true;
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }

    public synchronized State getState() {
        valueSet = false;
        notify();

        return state;
    }

    private void changeState() {
        int idx = random.nextInt(1, 4);
        state = State.values()[idx];
    }
}