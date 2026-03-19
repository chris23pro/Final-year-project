package core.evaluation;

import core.metrics.NormalizedMetrics;

public final class EnergyImpactCalculator {
    private EnergyImpactCalculator() {}

    public static double calculate(NormalizedMetrics metrics) {
        return metrics.powerWatts() * (1.0 + metrics.cryptoTimeMs() / 100.0);
    }
}
