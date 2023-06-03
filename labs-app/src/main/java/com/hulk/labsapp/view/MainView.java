package com.hulk.labsapp.view;

import com.hulk.labsapp.controller.MainController;
import com.hulk.labsapp.entity.Labs;
import com.hulk.labsapp.labs.annotations.AnnotationsRunner;
import com.hulk.labsapp.labs.pattern_strategy.PatternStrategyRunner;
import com.hulk.labsapp.labs.streamapi.StreamAPIRunner;
import com.hulk.labsapp.labs.supervisor.SupervisorRunner;
import com.hulk.labsapp.labs.thirdlab.ThirdLabRunner;
import com.hulk.labsapp.labs.translator.TranslatorRunner;
import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class MainView implements View {
    private final MainController mainController;
    private final LabsView labsView;
    private final ChoiceBox<Labs> labsChoiceBox;
    private final Button enterButton;

    public MainView(MainController mainController, LabsView labsView) {
        this.mainController = mainController;
        this.labsView = labsView;
        this.labsChoiceBox = new ChoiceBox<>(
                FXCollections.observableArrayList(
                        Labs.PATTERN_STRATEGY,
                        Labs.ANNOTATIONS,
                        Labs.THIRD_LAB,
                        Labs.TRANSLATOR,
                        Labs.STREAM_API,
                        Labs.SUPERVISOR
                )
        );
        this.enterButton = new Button("Choose");
    }

    @Override
    public Parent getView() {
        BorderPane layout = new BorderPane();

        HBox menu = new HBox();
        menu.setPadding(new Insets(20, 20, 20, 20));
        menu.setSpacing(10);

        menu.getChildren().addAll(labsChoiceBox, enterButton);
        layout.setTop(menu);

        labsChoiceBox.setOnAction(event -> {
            Labs lab = labsChoiceBox.getValue();

            switch (lab) {
                case PATTERN_STRATEGY -> mainController.openLabs(new PatternStrategyRunner());

                case ANNOTATIONS -> mainController.openLabs(new AnnotationsRunner());

                case THIRD_LAB -> mainController.openLabs(new ThirdLabRunner());

                case TRANSLATOR -> mainController.openLabs(new TranslatorRunner());

                case STREAM_API -> mainController.openLabs(new StreamAPIRunner());

                case SUPERVISOR -> mainController.openLabs(new SupervisorRunner());
            }
        });

        enterButton.setOnAction(event -> {
            if ( !mainController.getLabsRunner().isEmpty() ) {
                layout.setCenter(labsView.getView());
            } else {
                throw new RuntimeException("Select lab to run");
            }
        });

        return layout;
    }
}
