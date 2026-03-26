package models;

public class AlgorithmResult {
    private String algorithmName;
    private double latency;
    private double energy;
    private String suitability;

    public AlgorithmResult(String algorithmName, double latency, double energy, String suitability) {
        this.algorithmName = algorithmName;
        this.latency = latency;
        this.energy = energy;
        this.suitability = suitability;
    }

    public String getAlgorithmName() { return algorithmName; }
    public double getLatency() { return latency; }
    public double getEnergy() { return energy; }
    public String getSuitability() { return suitability; }
}