package ui.controllers;

import data.models.Project;
import data.repositories.ProjectRepository;

import java.util.Optional;

public class ProjectController {
    private final ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    public long save(Project project) {
        return projectRepository.save(project);
    }

    public Optional<Project> load(long id) {
        return projectRepository.findById(id);
    }
}
