package com.hulk.labsapp.controller;

import com.hulk.labsapp.model.Model;
import javafx.collections.ObservableList;

import java.util.List;
import java.util.Optional;

public class LabsController {
    private final Model model;

    public LabsController(Model model) {
        this.model = model;
    }

    public void startLabs(ObservableList<String> input) {
        model.startLab(input);
    }

    public ObservableList<String> getOutput() {
        return model.getOutput();
    }

    public void stop() {
        model.stop();
    }
}
