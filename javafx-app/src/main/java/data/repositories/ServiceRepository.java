package data.repositories;

import data.models.ServiceProfile;

import java.util.List;

public class ServiceRepository {

    public List<ServiceProfile> findAll() {
        return List.of(ServiceProfile.serviceA(), ServiceProfile.serviceB(), ServiceProfile.serviceC());
    }
}
