package org.loose.good.refactoring.optional.model;

public class File {
    private String path;
    private String name;
    private String extension;

    public File(String path) {
        this.path = path;
        this.name = path.substring(path.lastIndexOf('/'));
        this.extension = path.substring(path.lastIndexOf('.'));
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
        this.name = path.substring(path.lastIndexOf('/'));
        this.extension = path.substring(path.lastIndexOf('.'));
    }

    public String getName() {
        return name;
    }

    public String getExtension() {
        return extension;
    }
}
