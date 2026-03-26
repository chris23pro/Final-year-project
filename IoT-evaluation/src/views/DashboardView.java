package views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

import services.MQTTService;

public class DashboardView {

    public Scene createScene() {

        Label title = new Label("IoT Security Dashboard");
        Label dataLabel = new Label("No data yet");

        Button connectBtn = new Button("Connect to MQTT");

        MQTTService mqtt = new MQTTService();

        connectBtn.setOnAction(e -> {
            mqtt.connect(dataLabel);
        });

        VBox layout = new VBox(15);
        layout.getChildren().addAll(title, connectBtn, dataLabel);

        return new Scene(layout, 800, 600);
    }
}
