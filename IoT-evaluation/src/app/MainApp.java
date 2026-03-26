package app;

import javafx.application.Application;
import javafx.stage.Stage;
import views.DashboardView;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {

        DashboardView view = new DashboardView();

        stage.setTitle("IoT Security Evaluation Tool");
        stage.setScene(view.createScene());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
