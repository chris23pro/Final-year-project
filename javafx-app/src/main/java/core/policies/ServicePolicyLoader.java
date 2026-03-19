package core.policies;

import data.models.ServiceProfile;

import java.util.Map;

public class ServicePolicyLoader {
    private final Map<String, ServiceProfile> profiles = Map.of(
            "Service A", ServiceProfile.serviceA(),
            "Service B", ServiceProfile.serviceB(),
            "Service C", ServiceProfile.serviceC()
    );

    public ServiceProfile load(String serviceName) {
        return profiles.getOrDefault(serviceName, ServiceProfile.serviceA());
    }
}
