package org.loose.good.refactoring.optional.model;

import java.util.List;

public class Project {
    private String id;
    private String name;
    private List<Author> authors;
    private List<Commit> commits;
    private List<File> files;

    public Project(String id, String name, List<Author> authors, List<Commit> commits, List<File> files) {
        this.id = id;
        this.name = name;
        this.authors = authors;
        this.commits = commits;
        this.files = files;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public List<Commit> getCommits() {
        return commits;
    }

    public List<File> getFiles() {
        return files;
    }
}
