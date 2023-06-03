package com.hulk.labsapp;

import com.hulk.labsapp.controller.LabsController;
import com.hulk.labsapp.controller.MainController;
import com.hulk.labsapp.model.Model;
import com.hulk.labsapp.view.LabsView;
import com.hulk.labsapp.view.MainView;

public class AppLauncher {
    private final MainView mainView;
    private final LabsView labsView;
    private final MainController mainController;
    private final LabsController labsController;
    private final Model model;

    public AppLauncher() {
        this.model = new Model();

        this.mainController = new MainController(model);
        this.labsController = new LabsController(model);

        this.labsView = new LabsView(labsController);

        this.mainView = new MainView(mainController, labsView);
    }

    public MainView getMainView() {
        return mainView;
    }
}
