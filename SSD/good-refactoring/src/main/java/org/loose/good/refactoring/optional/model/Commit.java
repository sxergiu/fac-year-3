package org.loose.good.refactoring.optional.model;

import java.util.Date;

public class Commit {

    private String name;
    private Date date;
    private Author author;

    public Commit(String name, Date date, Author author) {
        this.name = name;
        this.date = date;
        this.author = author;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
