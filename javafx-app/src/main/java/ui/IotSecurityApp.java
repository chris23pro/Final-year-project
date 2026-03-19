package ui;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.stage.Stage;
import ui.controllers.EncryptionController;
import ui.controllers.EvaluationController;
import ui.controllers.FloorplanController;
import ui.controllers.HomeController;
import ui.controllers.MetricsController;

public class IotSecurityApp extends Application {

    @Override
    public void start(Stage stage) {
        TabPane tabs = new TabPane(
                new Tab("Home", new HomeController().createView()),
                new Tab("Floorplan", new FloorplanController().createView()),
                new Tab("Encryption", new EncryptionController().createView()),
                new Tab("Metrics", new MetricsController().createView()),
                new Tab("Evaluation", new EvaluationController().createView())
        );

        tabs.getTabs().forEach(tab -> tab.setClosable(false));

        Scene scene = new Scene(tabs, 1100, 700);
        stage.setTitle("IoT Security Evaluation Framework");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
