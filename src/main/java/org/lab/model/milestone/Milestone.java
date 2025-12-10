package org.lab.model.milestone;

import org.lab.model.project.Project;
import org.lab.model.ticket.Ticket;

import java.util.ArrayList;
import java.util.Date;
import java.util.SequencedCollection;

public class Milestone {
    private final String name;
    private final Date date;
    private final Project project;
    private final SequencedCollection<Ticket> tickets = new ArrayList<>();
    private MilestoneStatus status = MilestoneStatus.OPEN;

    public Milestone(String name, Date date, Project project) {
        this.name = name;
        this.date = date;
        this.project = project;
    }

    public void setStatus(MilestoneStatus status) {
        this.status = status;
    }

    public void addTicket(Ticket ticket) {
        this.tickets.addFirst(ticket);
    }

    public SequencedCollection<Ticket> getTickets() {
        return this.tickets;
    }

    public Date getDate() {
        return date;
    }

    public Project getProject() {
        return project;
    }

    public MilestoneStatus getStatus() {
        return status;
    }

    public String getName() {
        return this.name;
    }
}
