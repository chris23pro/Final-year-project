package ui.components;

import data.models.EvaluationResult;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class EvaluationSummaryCard extends VBox {

    public EvaluationSummaryCard(EvaluationResult result) {
        super(8,
                new Label("Pass: " + result.pass()),
                new Label(String.format("Security Score: %.2f", result.securityScore())),
                new Label(String.format("Energy Impact: %.2f", result.energyImpact())),
                new Label(String.format("Cost Impact: %.2f", result.costImpact())),
                new Label("Reasoning: " + result.reasoning())
        );
        setPadding(new Insets(16));
        setStyle("-fx-border-color: #2f6b2f; -fx-background-color: #f4fff4;");
    }
}
