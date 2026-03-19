package ui.controllers;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.FlowPane;
import javafx.scene.layout.VBox;
import ui.components.DeviceNode;

public class FloorplanController {

    public Parent createView() {
        FlowPane deviceCanvas = new FlowPane(12, 12,
                new DeviceNode("Temperature Sensor"),
                new DeviceNode("Door Lock"),
                new DeviceNode("Smart Plug")
        );

        VBox root = new VBox(12,
                new Label("Floorplan Editor (Tier 1)"),
                new Label("Drag-and-drop placeholder canvas for IoT nodes."),
                deviceCanvas
        );
        root.setPadding(new Insets(20));
        return root;
    }
}
