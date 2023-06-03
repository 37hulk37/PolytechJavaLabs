package com.hulk.labsapp.controller;

import com.hulk.labsapp.entity.LabsRunner;
import com.hulk.labsapp.model.Model;

import java.util.Optional;

public class MainController {
    private final Model model;

    public MainController(Model model) {
        this.model = model;
    }

    public Optional<LabsRunner> getLabsRunner() {
        return model.getLabsRunner();
    }

    public void openLabs(LabsRunner labsRunner) {
        model.setLabs(labsRunner);
    }
}
