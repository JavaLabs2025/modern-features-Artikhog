package org.lab.model.users;

import org.lab.model.bug.Bug;
import org.lab.model.project.Project;
import org.lab.model.ticket.Ticket;

import java.util.*;

public sealed class User permits Developer, Tester, Manager, Leader {
    protected final String name;
    protected final Set<Project> projects = new HashSet<>();
    protected final SequencedCollection<Ticket> tickets = new ArrayList<>();
    protected final SequencedCollection<Bug> bugs = new ArrayList<>();

    public User(String name) {
        this.name = name;
    }

    public Project createProject(String name) {
        var project = new Project(name);
        this.projects.add(project);
        return project;
    }

    public void removeProject(Project project) {
        this.projects.remove(project);
    }

    public void addProject(Project project) {
        this.projects.add(project);
    }

    public List<Project> getAllProjects() {
        return this.projects.stream().toList();
    }

    public void addTicket(Ticket ticket) {
        this.tickets.addLast(ticket);
    }

    public Ticket getFirstTicket() {
        return this.tickets.getFirst();
    }

    public List<Ticket> getAllTickets() {
        return this.tickets.stream().toList();
    }

    public void addBug(Bug bug) {
        this.bugs.addLast(bug);
    }

    public Bug getFirstBug() {
        return this.bugs.getFirst();
    }

    public List<Bug> getAllBugs() {
        return this.bugs.stream().toList();
    }

    public String getName() {
        return this.name;
    }
}
