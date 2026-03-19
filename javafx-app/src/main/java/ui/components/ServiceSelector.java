package ui.components;

import javafx.scene.control.ComboBox;

public class ServiceSelector extends ComboBox<String> {

    public ServiceSelector() {
        getItems().addAll("Service A", "Service B", "Service C");
        getSelectionModel().selectFirst();
    }
}
