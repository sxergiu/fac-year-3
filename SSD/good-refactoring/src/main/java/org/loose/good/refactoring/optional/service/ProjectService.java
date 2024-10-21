package org.loose.good.refactoring.optional.service;

import org.loose.good.refactoring.optional.model.Commit;
import org.loose.good.refactoring.optional.model.Project;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ProjectService {
    private ProjectRepository projectRepository;

    public void printProjectDetails(String projectID) {
        findProject(projectID).ifPresent( project ->
            System.out.printf("Project ID: %s\nProject name: %s", project.getId(), project.getName())
        );
    }

    public List<String> getCommitNamesForProject(String projectID) {
        Project project = findProject(projectID).orElseThrow(() -> new NoSuchProjectException(projectID));

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

        Project project =
                findProject(projectID).orElseThrow( () -> new NoSuchProjectException(projectID) );
        return project.getCommits().get(0).getAuthor().getName();
    }

    public int getNumberOfFilesInProject(String projectID) {

        Optional<Project> optionalProject = findProject(projectID);
        if( optionalProject.isPresent() ) {
            return optionalProject.get().getFiles().size();
        }
        return -1;
    }

    private Optional<Project> findProject(String projectID) {

        Project project = projectRepository.getProjectByID(projectID);
        return Optional.ofNullable(project);
    }

    public void setProjectRepository(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }
}
