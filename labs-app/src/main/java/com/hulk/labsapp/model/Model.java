package com.hulk.labsapp.model;

import com.hulk.labsapp.entity.TheLab;
import com.hulk.labsapp.entity.LabsRunner;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.util.Optional;

public class Model {
    private final TheLab theLab;

    private final ObservableList<String> input;

    private final ObservableList<String> output;

    public Model() {
        this.theLab = new TheLab();
        this.input = FXCollections.observableArrayList();
        this.output = FXCollections.observableArrayList();
    }

    public void startLab(ObservableList<String> input) {
        theLab.startLab(input, output);
    }

    public Optional<LabsRunner> getLabsRunner() {
        return theLab.getLabsRunner();
    }

    public void setLabs(LabsRunner labsRunner) {
        theLab.setLabsRunner(labsRunner);
    }

    public ObservableList<String> getInput() {
        return input;
    }

    public ObservableList<String> getOutput() {
        return output;
    }

    public void stop() {
        theLab.stopLabs();
    }
}
