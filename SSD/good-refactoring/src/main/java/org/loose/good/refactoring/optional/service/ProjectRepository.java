package org.loose.good.refactoring.optional.service;

import org.loose.good.refactoring.optional.model.Project;

public interface ProjectRepository {
    Project getProjectByID(String projectID);
}
