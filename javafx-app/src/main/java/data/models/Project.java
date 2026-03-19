package data.models;

public record Project(
        long id,
        String name,
        String selectedService,
        String floorplanJson
) {}
