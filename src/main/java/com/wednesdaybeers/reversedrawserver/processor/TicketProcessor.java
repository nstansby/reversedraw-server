package com.wednesdaybeers.reversedrawserver.processor;

import com.wednesdaybeers.reversedrawserver.creator.Ticket.TicketCreator;
import com.wednesdaybeers.reversedrawserver.creator.User.UserCreator;
import com.wednesdaybeers.reversedrawserver.dto.error.ErrorCode;
import com.wednesdaybeers.reversedrawserver.model.participant.Participant;
import com.wednesdaybeers.reversedrawserver.model.ticket.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class TicketProcessor {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketCreator ticketCreator;

    @Autowired
    private UserCreator userCreator;

    public void createTickets(List<String> names, int ticketsPerUser) throws WineDrawException
    {
        if (ticketRepository.count() != 0) {
            throw new WineDrawException(ErrorCode.TICKETS_ALREADY_CREATED, "Tickets already created");
        }

        for (String name : names) {
            Participant participant = userCreator.createUser(name);
            for (int i = 0; i < ticketsPerUser; i++) {
                ticketCreator.createTicket(participant);
            }
        }
    }
}
