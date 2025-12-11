package org.lab.model.bug;

import org.lab.model.project.Project;

public value record Bug(String name, Project project, BugStatus status) {
    public Bug(String name, Project project) {
        this(name, project, BugStatus.NEW);
    }

    public Bug withProject(Project project) {
        return new Bug(this.name, project, this.status);
    }

    public Bug withFixed() {
        return new Bug(this.name, this.project, BugStatus.FIXED);
    }

    public Bug withTested() {
        return new Bug(this.name, this.project, BugStatus.FIXED);
    }

    public Bug withClosed() {
        return new Bug(this.name, this.project, BugStatus.CLOSED);
    }
}