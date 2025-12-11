import org.lab.model.bug.Bug;
import org.lab.model.bug.BugStatus;
import org.lab.model.milestone.MilestoneStatus;
import org.lab.model.users.Developer;
import org.lab.model.users.Manager;

import java.util.Date;

void main() {
    Manager manager = new Manager("Manager");
    var project =  manager.createProject("Lab 4");
    IO.println("Manager " + manager.getName() + " create project " + project.getName());

    var developer = new Developer("Backend");
    manager.addDeveloper(project, developer);

    var milestone = manager.createMilestone("MVP", new Date(), project);
    manager.setMilestoneStatus(milestone, MilestoneStatus.ACTIVE);

    var _ = manager.createTicket("Do backend", project, milestone, developer);

    var bug = developer.createBug(project, "can't start backend");
    var newBug = new Bug("can't start backend", project, BugStatus.NEW);
    IO.println(bug == newBug);

    Bug[] bugs = new Bug[2];
    bugs[0] = bug;
    bugs[1] = newBug;

    var fixedBug = developer.resolveBug();
    IO.println(bug == fixedBug);
    IO.println(developer.getFirstBug() == fixedBug);
    IO.println(developer.getFirstBug() == bug);

    Object[] closedBugs = Arrays.stream(bugs).map(Bug::withFixed).map(Bug::withTested).map(Bug::withClosed).toArray();
    IO.println(closedBugs[0] == closedBugs[1]);

    var _ = new Developer("python backend");
}

