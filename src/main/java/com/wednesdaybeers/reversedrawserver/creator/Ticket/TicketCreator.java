package com.wednesdaybeers.reversedrawserver.creator.Ticket;

import com.wednesdaybeers.reversedrawserver.model.participant.Participant;
import com.wednesdaybeers.reversedrawserver.model.ticket.Ticket;
import com.wednesdaybeers.reversedrawserver.model.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TicketCreator {

    @Autowired
    private TicketRepository ticketRepository;

    public Ticket createTicket(Participant participant) {
        Ticket ticket = new Ticket();
        ticket.setParticipant(participant);
        ticket.setState(Ticket.State.ACTIVE);

        return ticketRepository.save(ticket);
    }
}
