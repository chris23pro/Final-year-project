package ui.controllers;

import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EncryptionController {

    public Parent createView() {
        ComboBox<String> algorithms = new ComboBox<>();
        algorithms.getItems().addAll("AES-128", "AES-256", "ChaCha20", "ECC");
        algorithms.getSelectionModel().selectFirst();

        VBox root = new VBox(10,
                new Label("Encryption Profile Selector (FR2)"),
                new Label("Select encryption method for service simulation."),
                algorithms
        );
        root.setPadding(new Insets(20));
        return root;
    }
}
