package com.hulk.labsapp;

import com.hulk.labsapp.view.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class LabsApplication extends Application {
    private AppLauncher appLauncher;

    @Override
    public void init() throws Exception {
        this.appLauncher = new AppLauncher();
    }

    @Override
    public void start(Stage stage) throws IOException {
        MainView mainView = appLauncher.getMainView();

        BorderPane layout = new BorderPane();

        layout.setCenter(mainView.getView());

        Scene view = new Scene(layout, 600, 600);

        stage.setScene(view);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}