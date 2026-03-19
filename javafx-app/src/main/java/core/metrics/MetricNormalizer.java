package core.metrics;

public class MetricNormalizer {

    public NormalizedMetrics apply(NormalizedMetrics raw) {
        double boundedLatency = Math.max(0, raw.latencyMs());
        double boundedCrypto = Math.max(0, raw.cryptoTimeMs());
        double boundedPower = Math.max(0, raw.powerWatts());
        double boundedPayload = Math.max(0, raw.payloadBytes());
        return new NormalizedMetrics(boundedLatency, boundedCrypto, boundedPower, boundedPayload);
    }
}
