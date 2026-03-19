package data.models;

public record EvaluationResult(
        boolean pass,
        double securityScore,
        double energyImpact,
        double costImpact,
        String reasoning
) {}
