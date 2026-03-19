package ui.controllers;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.components.MetricsChart;

public class MetricsController {

    public Parent createView() {
        VBox root = new VBox(12,
                new Label("Live Metrics Dashboard (FR4)"),
                new MetricsChart()
        );
        root.setPadding(new Insets(20));
        return root;
    }
}
