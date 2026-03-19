package core.evaluation;

import core.metrics.NormalizedMetrics;
import data.models.EvaluationResult;
import data.models.ServiceProfile;

public class EvaluationEngine {

    public EvaluationResult evaluate(NormalizedMetrics metrics, ServiceProfile profile) {
        double security = SecurityComplianceChecker.check(metrics, profile);
        double energy = EnergyImpactCalculator.calculate(metrics);
        double cost = AffordabilityCalculator.calculate(metrics);

        boolean pass = security >= profile.minSecurityScore()
                && energy <= profile.maxEnergyUsage()
                && cost <= profile.maxCost();

        String reasoning = pass
                ? "Profile thresholds satisfied."
                : "One or more thresholds exceeded; tune encryption profile or reduce payload/latency.";

        return new EvaluationResult(pass, security, energy, cost, reasoning);
    }
}
