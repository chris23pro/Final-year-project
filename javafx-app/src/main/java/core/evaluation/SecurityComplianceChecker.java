package core.evaluation;

import core.metrics.NormalizedMetrics;
import data.models.ServiceProfile;

public final class SecurityComplianceChecker {
    private SecurityComplianceChecker() {}

    public static double check(NormalizedMetrics metrics, ServiceProfile profile) {
        double latencyPenalty = Math.min(20, metrics.latencyMs() / 10.0);
        double cryptoPenalty = Math.min(20, metrics.cryptoTimeMs() / 2.0);
        return Math.max(0, profile.minSecurityScore() + 20 - latencyPenalty - cryptoPenalty);
    }
}
