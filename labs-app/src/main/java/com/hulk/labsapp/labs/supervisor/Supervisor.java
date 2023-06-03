package com.hulk.labsapp.labs.supervisor;

import javafx.application.Platform;
import javafx.collections.ObservableList;

public class Supervisor implements Runnable {
    private final AbstractProgram abstractProgram;
    private Thread thread;
    private final ObservableList<String> output;

    public Supervisor(ObservableList<String> output) {
        this.output = output;
        this.abstractProgram = new AbstractProgram();
        this.thread = new Thread(abstractProgram, "AbstractProgram");
        thread.start();
    }

    @Override
    public void run() {
        try {
            while (!thread.isInterrupted()) {
                State state = abstractProgram.getState();
                Platform.runLater(() ->
                    output.add(state.toString())
                );

                switch (state) {
                    case FATAL_ERROR -> {
                        thread.interrupt();
                    }

                    case STOPPING -> {
                        thread.interrupt();
                        thread = new Thread(abstractProgram, "AbstractProgram");
                        thread.start();
                    }
                }
                Thread.sleep(1000);
            }
        } catch (InterruptedException ex) {
            thread.interrupt();
        }
    }
}