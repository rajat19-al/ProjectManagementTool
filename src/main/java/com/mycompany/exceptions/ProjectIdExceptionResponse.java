package com.mycompany.exceptions;

public class ProjectIdExceptionResponse {

    private String ProjectIdentifier;

    public ProjectIdExceptionResponse() {
    }

    public ProjectIdExceptionResponse(String projectIdentifier) {
        ProjectIdentifier = projectIdentifier;
    }

    public String getProjectIdentifier() {
        return ProjectIdentifier;
    }

    public void setProjectIdentifier(String projectIdentifier) {
        ProjectIdentifier = projectIdentifier;
    }
}
