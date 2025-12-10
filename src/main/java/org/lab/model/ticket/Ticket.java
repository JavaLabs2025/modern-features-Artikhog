package org.lab.model.ticket;

import org.lab.model.milestone.Milestone;
import org.lab.model.project.Project;
import org.lab.model.users.Developer;

public record Ticket(String name, Project project, Developer developer, Milestone milestone, TicketStatus status) {
    public Ticket(String name, Project project, Developer developer, Milestone milestone) {
        this(name, project, developer, milestone, TicketStatus.NEW);
    }
}