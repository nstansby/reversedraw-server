package com.wednesdaybeers.reversedrawserver.dto.ticket;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import java.util.List;

public class TicketPostRequest {
    @NotEmpty
    private List<String> names;

    @Min(value = 1, message = "numTickets parameter must be a positive integer")
    private int numTickets;

    // Autogen setters and getters

    public List<String> getNames() {
        return names;
    }

    public void setNames(List<String> names) {
        this.names = names;
    }

    public int getNumTickets() {
        return numTickets;
    }

    public void setNumTickets(int numTickets) {
        this.numTickets = numTickets;
    }
}
