package core.metrics;

import org.json.JSONObject;

public class MetricIngestor {

    public NormalizedMetrics ingest(JSONObject json) {
        return new NormalizedMetrics(
                json.optDouble("latency_ms", 0.0),
                json.optDouble("crypto_time_ms", 0.0),
                json.optDouble("power_watts", 0.0),
                json.optDouble("payload_bytes", 0.0)
        );
    }
}
