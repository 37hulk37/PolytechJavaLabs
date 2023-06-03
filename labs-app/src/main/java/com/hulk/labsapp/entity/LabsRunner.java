package com.hulk.labsapp.entity;

import javafx.collections.ObservableList;

import java.util.List;

public interface LabsRunner {
    void start(ObservableList<String> input, ObservableList<String> output);

    void stop();
}
