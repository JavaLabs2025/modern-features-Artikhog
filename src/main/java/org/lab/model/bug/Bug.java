package org.lab.model.bug;

import org.lab.model.project.Project;

public value record Bug(String name, Project project, BugStatus status) {
    public Bug(String name, Project project) {
        this(name, project, BugStatus.NEW);
    }
}