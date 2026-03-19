package data.models;

import java.time.Instant;

public record MetricRecord(
        long id,
        String algorithm,
        double latencyMs,
        double cryptoTimeMs,
        double powerWatts,
        double payloadBytes,
        Instant recordedAt
) {}
