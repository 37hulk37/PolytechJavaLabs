package com.hulk.labsapp.entity;

import javafx.collections.ObservableList;

import java.util.Optional;

public class TheLab {
    private LabsRunner labsRunner;

    public Optional<LabsRunner> getLabsRunner() {
        return ( !(labsRunner == null) ? Optional.of(labsRunner) : Optional.empty());
    }

    public void setLabsRunner(LabsRunner labsRunner) {
        this.labsRunner = labsRunner;
    }

    public void startLab(ObservableList<String> input, ObservableList<String> output) {
        labsRunner.start(input, output);
    }

    public void stopLabs() {
        labsRunner.stop();
    }
}
