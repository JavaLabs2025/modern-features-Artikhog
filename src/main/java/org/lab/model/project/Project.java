package org.lab.model.project;

import org.lab.model.bug.Bug;
import org.lab.model.milestone.Milestone;
import org.lab.model.users.*;

import java.util.*;

public class Project {
    String name;
    Leader leader;
    Manager manager;
    List<Developer> developers = new ArrayList<>();
    List<Tester> testers = new ArrayList<>();

    List<Milestone> milestones = new ArrayList<>();
    SequencedCollection<Bug> bugs = new ArrayList<>();

    public Project(String name) {
        this.name = name;
    }

    public void addManager(Manager manager) {
        if (this.manager != null) {
            this.removeUser(manager);
        }
        this.manager = manager;
        manager.addProject(this);
    }
    
    public void removeUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Remove ");
        switch (user) {
            case Developer developer -> {
                this.developers.remove(developer);
                developer.removeProject(this);
                sb.append("developer ").append(developer.getName());
            }
            case Tester tester -> {
                this.testers.remove(tester);
                tester.removeProject(this);
                sb.append("tester ").append(tester.getName());
            }
            case Manager manager -> {
                this.manager = null;
                manager.removeProject(this);
                sb.append("manager ").append(manager.getName());
            }
            case Leader leader -> {
                this.leader = null;
                leader.removeProject(this);
                sb.append("leader ").append(leader.getName());
            }
            default -> throw new IllegalStateException("Unexpected value: " + user);
        }
        sb.append(" from project ").append(this.getName());
        String result = sb.toString();
        System.out.println(result);
    }

    public void addUser(User user) {
        StringBuilder sb = new StringBuilder();
        sb.append("Add ");
        switch (user) {
            case Developer developer -> {
                this.developers.add(developer);
                developer.addProject(this);
                sb.append("developer ").append(developer.getName());
            }
            case Tester tester -> {
                this.testers.add(tester);
                tester.addProject(this);
                sb.append("tester ").append(tester.getName());
            }
            case Manager manager -> {
                if (this.manager != null) {
                    this.removeUser(manager);
                }
                this.manager = manager;
                manager.addProject(this);
                sb.append("manager ").append(manager.getName());
            }
            case Leader leader -> {
                if (this.leader != null) {
                    this.removeUser(this.leader);
                }
                this.leader = leader;
                leader.addProject(this);
                sb.append("leader ").append(leader.getName());
            }
            default -> throw new IllegalStateException("Unexpected value: " + user);
        }
        sb.append(" to project ").append(this.getName());
        String result = sb.toString();
        System.out.println(result);
    }

    public boolean isManager(Manager manager) {
        return this.manager == manager;
    }

    public String getName() {
        return this.name;
    }
}
