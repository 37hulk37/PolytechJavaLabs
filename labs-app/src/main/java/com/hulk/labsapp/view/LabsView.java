package com.hulk.labsapp.view;

import com.hulk.labsapp.controller.LabsController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;

import java.util.*;

public class LabsView implements View {
    private final LabsController labsController;
    private final ObservableList<String> inputList;
    private int startIdx = 0;
    private int endIdx = 0;
    private final Set<String> commands;

    public LabsView(LabsController labsController) {
        this.labsController = labsController;
        this.inputList = FXCollections.observableArrayList();
        this.commands = new HashSet<>();

        commands.add("fly");
        commands.add("ride");
        commands.add("walk");
    }

    @Override
    public Parent getView() {
        GridPane layout = new GridPane();

        Label inputLabel = new Label("input");
        TextArea inputArea = new TextArea();
        inputArea.setWrapText(true);

        Label outputLabel = new Label("output");
        Button startButton = new Button("Start");
        Button stopButton = new Button("Stop");
        ListView<String> outputView = new ListView<>();

        layout.setAlignment(Pos.CENTER);
        layout.setVgap(10);
        layout.setHgap(10);
        layout.setPadding(new Insets(10, 10, 10, 10));

        layout.add(inputLabel, 0, 0);
        layout.add(inputArea, 0, 1);
        layout.add(startButton, 1, 0);
        layout.add(stopButton, 2, 0);
        layout.add(outputLabel, 0, 2);
        layout.add(outputView, 0, 3);

        startButton.setOnAction(event -> {
            List<String> input = new ArrayList<>(Arrays.stream(inputArea
                            .getText()
                            .toLowerCase()
                            .split("\n"))
                    .toList());

            endIdx = input.size();
            if (input.size() > 0) {
                for (int i = startIdx; i < input.size(); i++) {
                    if ( !commands.contains(input.get(i)) ) {
                        Collections.swap(input, i, endIdx-1);
                        endIdx--;
                    }
                }

                inputList.addAll(
                        input.subList(startIdx, endIdx)
                );

                startIdx = input.size();
            }

            labsController.startLabs(inputList);
            inputList.clear();
        });

        outputView.setItems(labsController.getOutput());

        stopButton.setOnAction(event -> {
            inputArea.clear();
            outputView.getItems().clear();
            startIdx = 0;
            inputList.clear();

            outputView.setItems(labsController.getOutput());
        });

        return layout;
    }
}
