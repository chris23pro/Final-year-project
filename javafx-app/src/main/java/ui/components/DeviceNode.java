package ui.components;

import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;

public class DeviceNode extends StackPane {

    public DeviceNode(String deviceName) {
        Label label = new Label(deviceName);
        getChildren().add(label);
        setPadding(new Insets(16));
        setStyle("-fx-border-color: #336699; -fx-border-radius: 8; -fx-background-color: #eef6ff;");
    }
}
