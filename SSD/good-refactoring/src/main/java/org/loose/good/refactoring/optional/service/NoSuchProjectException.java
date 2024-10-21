package org.loose.good.refactoring.optional.service;

public class NoSuchProjectException extends RuntimeException {
    public NoSuchProjectException(String projectID) {
        super(String.format("The project with id %s does not exist!", projectID));
    }
}
