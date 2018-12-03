package com.wednesdaybeers.reversedrawserver.dto.ticket;

import com.wednesdaybeers.reversedrawserver.dto.RestResponse;

import java.util.List;

public class TicketGetResponse implements RestResponse {

    private int numParticipants;
    private List<TicketDTO> tickets;

    // Autogen setters / getters

    public List<TicketDTO> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketDTO> tickets) {
        this.tickets = tickets;
    }

    public int getNumParticipants() {
        return numParticipants;
    }

    public void setNumParticipants(int numParticipants) {
        this.numParticipants = numParticipants;
    }
}
