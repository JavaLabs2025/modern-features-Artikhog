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

    var ticket = manager.createTicket("Do backend", project, milestone, developer);

}

