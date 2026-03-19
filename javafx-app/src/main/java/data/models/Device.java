package data.models;

public record Device(
        long id,
        String name,
        String type,
        String encryptionProfile,
        double estimatedCost
) {}
