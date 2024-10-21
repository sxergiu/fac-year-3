package org.loose.good.refactoring.optional.service;

import org.loose.good.refactoring.optional.model.Commit;
import org.loose.good.refactoring.optional.model.Project;

import java.util.ArrayList;
import java.util.List;

public class ProjectService {
    private ProjectRepository projectRepository;

    public void printProjectDetails(String projectID) {
        Project project = findProject(projectID);
        if (project != null) {
            System.out.printf("Project ID: %s\nProject name: %s", project.getId(), project.getName());
        }
    }

    public List<String> getCommitNamesForProject(String projectID) {
        Project project = findProject(projectID);
        if (project == null) {
            throw new NoSuchProjectException(projectID);
        }

        List<String> commitNames = new ArrayList<>();
        for (Commit commit : project.getCommits()) {
            commitNames.add(commit.getName());
        }

        return commitNames;
    }

    public String getFirstAuthorNameForProject(String projectID) {
        Project project = findProject(projectID);
        if (project == null) {
            throw new NoSuchProjectException(projectID);
        }

        return project.getCommits().get(0).getAuthor().getName();
    }

    public int getNumberOfFilesInProject(String projectID) {
        Project project = findProject(projectID);
        if (project != null) {
            return project.getFiles().size();
        }

        return -1;
    }

    private Project findProject(String projectID) {
        return projectRepository.getProjectByID(projectID);
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
