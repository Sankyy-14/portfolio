package com.sanket.portfolio;

import java.util.List;

public class Project {

    private String title;
    private String description;
    private List<String> tags;

    public Project(String title, String description, List<String> tags) {
        this.title = title;
        this.description = description;
        this.tags = tags;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public List<String> getTags() {
        return tags;
    }
}
