package core.metrics;

public record NormalizedMetrics(
        double latencyMs,
        double cryptoTimeMs,
        double powerWatts,
        double payloadBytes
) {}
