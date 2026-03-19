package data.models;

public record ServiceProfile(
        String name,
        double minSecurityScore,
        double maxEnergyUsage,
        double maxCost
) {
    public static ServiceProfile serviceA() {
        return new ServiceProfile("Service A", 60, 2.2, 3.0);
    }

    public static ServiceProfile serviceB() {
        return new ServiceProfile("Service B", 70, 2.8, 4.5);
    }

    public static ServiceProfile serviceC() {
        return new ServiceProfile("Service C", 80, 3.5, 6.0);
    }
}
