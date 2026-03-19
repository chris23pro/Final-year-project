package data.repositories;

import data.models.EvaluationResult;

import java.util.ArrayList;
import java.util.List;

public class EvaluationRepository {
    private final List<EvaluationResult> results = new ArrayList<>();

    public void save(EvaluationResult result) {
        results.add(result);
    }

    public List<EvaluationResult> findAll() {
        return List.copyOf(results);
    }
}
