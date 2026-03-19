package data.repositories;

import data.models.Project;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

public class ProjectRepository {
    private final AtomicLong idSequence = new AtomicLong(1);
    private final Map<Long, Project> projects = new HashMap<>();

    public long save(Project project) {
        long id = project.id() > 0 ? project.id() : idSequence.getAndIncrement();
        projects.put(id, new Project(id, project.name(), project.selectedService(), project.floorplanJson()));
        return id;
    }

    public Optional<Project> findById(long id) {
        return Optional.ofNullable(projects.get(id));
    }
}
