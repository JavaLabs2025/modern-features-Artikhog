package org.lab.model.users;

import org.lab.model.milestone.Milestone;
import org.lab.model.milestone.MilestoneStatus;
import org.lab.model.project.Project;
import org.lab.model.ticket.Ticket;
import org.lab.model.ticket.TicketStatus;

import java.util.Date;

public final class Manager extends User {
    public Manager(String name) {
        super(name);
    }

    public void addLeader(Project project, Leader leader) {
        if (project.isManager(this)) {
            return;
        }
        project.addUser(leader);
        leader.addProject(project);
    }

    public void addDeveloper(Project project, Developer developer) {
        if (project.isManager(this)) {
            return;
        }
        project.addUser(developer);
        developer.addProject(project);
    }

    public void addTester(Project project, Tester tester) {
        if (project.isManager(this)) {
            return;
        }
        project.addUser(tester);
        tester.addProject(project);
    }

    public Milestone createMilestone(String name, Date date, Project project) {
        var milestone = new Milestone(name, date, project);
        IO.println("Manager " + this.getName() + " create milestone " + milestone.getName());
        return milestone;
    }

    public void setMilestoneStatus(Milestone milestone, MilestoneStatus status) {
        StringBuilder sb = new StringBuilder();
        sb.append("Manager ").append(this.getName());
        sb.append(" milestone ").append(milestone.getName());
        sb.append(" switch status from ").append(milestone.getStatus());
        milestone.setStatus(status);
        sb.append(" to ").append(milestone.getStatus());
        String result = sb.toString();
        System.out.println(result);
    }

    public Ticket createTicket(String name, Project project, Milestone milestone, Developer developer) {
        var ticket = new Ticket(name, project, developer, milestone);
        developer.addTicket(ticket);
        milestone.addTicket(ticket);
        IO.println("Manager " + this.getName() + " create ticket " + ticket.name());
        return ticket;
    }

    public boolean checkTicketSuccess(Ticket ticket) {
        return ticket.status() == TicketStatus.COMPLETED;
    }
}
