package com.hulk.labsapp.labs.supervisor;

import com.hulk.labsapp.entity.LabsRunner;
import javafx.collections.ObservableList;

public class SupervisorRunner implements LabsRunner {
    private Thread thread;

    @Override
    public void start(ObservableList<String> input, ObservableList<String> output) {
        Supervisor supervisor = new Supervisor(output);

        this.thread = new Thread(supervisor, "Supervisor");
        thread.start();
    }

    @Override
    public void stop() {
    }
}
