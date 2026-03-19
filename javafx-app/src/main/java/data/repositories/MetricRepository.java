package data.repositories;

import data.models.MetricRecord;

import java.util.ArrayList;
import java.util.List;

public class MetricRepository {
    private final List<MetricRecord> inMemoryMetrics = new ArrayList<>();

    public void save(MetricRecord record) {
        inMemoryMetrics.add(record);
    }

    public List<MetricRecord> findAll() {
        return List.copyOf(inMemoryMetrics);
    }
}
