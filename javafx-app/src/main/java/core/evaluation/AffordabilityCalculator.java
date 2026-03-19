package core.evaluation;

import core.metrics.NormalizedMetrics;

public final class AffordabilityCalculator {
    private AffordabilityCalculator() {}

    public static double calculate(NormalizedMetrics metrics) {
        return (metrics.payloadBytes() / 256.0) + (metrics.cryptoTimeMs() * 0.1);
    }
}
