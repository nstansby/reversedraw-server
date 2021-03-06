package com.wednesdaybeers.reversedraw.server.dto.ticket;

import com.wednesdaybeers.reversedraw.server.model.ticket.Ticket;
import com.wednesdaybeers.reversedraw.server.dto.RestResponse;

public class TicketDTO implements RestResponse {
    private int id;
    private Ticket.State state;
    private String name;

    // Autogen setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Ticket.State getState() {
        return state;
    }

    public void setState(Ticket.State state) {
        this.state = state;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
