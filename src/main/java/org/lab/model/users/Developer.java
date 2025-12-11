package org.lab.model.users;

import org.lab.model.bug.Bug;
import org.lab.model.project.Project;

public final class Developer extends User {
    public Developer(String name) {
        if (name.contains("python")) throw new IllegalArgumentException("we can't create python developers");
        super(name);
    }

    public Bug createBug(Project project, String name) {
        var bug = new Bug(name, project);
        project.addBug(bug);
        this.bugs.addLast(bug);
        return bug;
    }

    public Bug resolveBug() {
        var bug = this.bugs.getFirst();
        bug = bug.withFixed();
        this.bugs.removeFirst();
        this.bugs.addFirst(bug);
        return bug;
    }
}
