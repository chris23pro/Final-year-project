package ui.controllers;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.components.ServiceSelector;

public class HomeController {

    public Parent createView() {
        ServiceSelector selector = new ServiceSelector();
        VBox root = new VBox(10,
                new Label("IoT Security Evaluation Dashboard"),
                new Label("Choose service profile and begin project setup."),
                selector,
                new Button("Create Project"),
                new Button("Load Project")
        );
        root.setPadding(new Insets(20));
        return root;
    }
}
