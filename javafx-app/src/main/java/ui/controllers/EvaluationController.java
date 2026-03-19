package ui.controllers;

import core.evaluation.EvaluationEngine;
import core.metrics.NormalizedMetrics;
import data.models.EvaluationResult;
import data.models.ServiceProfile;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import ui.components.EvaluationSummaryCard;

public class EvaluationController {

    public Parent createView() {
        ServiceProfile profile = ServiceProfile.serviceA();
        NormalizedMetrics metrics = new NormalizedMetrics(85, 12, 1.2, 256);
        EvaluationResult result = new EvaluationEngine().evaluate(metrics, profile);

        VBox root = new VBox(10,
                new Label("Evaluation Results (FR7)"),
                new EvaluationSummaryCard(result)
        );
        root.setPadding(new Insets(20));
        return root;
    }
}
