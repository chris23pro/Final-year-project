package core.evaluation;

import data.models.MetricRecord;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CryptoBenchmarkAnalyzer {

    public Map<String, Double> averageByAlgorithm(List<MetricRecord> records) {
        return records.stream()
                .collect(Collectors.groupingBy(MetricRecord::algorithm,
                        Collectors.averagingDouble(MetricRecord::cryptoTimeMs)));
    }

    public String bestAlgorithm(List<MetricRecord> records) {
        return averageByAlgorithm(records).entrySet().stream()
                .min(Comparator.comparingDouble(Map.Entry::getValue))
                .map(Map.Entry::getKey)
                .orElse("UNKNOWN");
    }
}
