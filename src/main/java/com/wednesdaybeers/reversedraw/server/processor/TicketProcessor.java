package com.wednesdaybeers.reversedraw.server.processor;

import com.wednesdaybeers.reversedraw.server.creator.Ticket.TicketCreator;
import com.wednesdaybeers.reversedraw.server.creator.User.UserCreator;
import com.wednesdaybeers.reversedraw.server.dto.error.ErrorCode;
import com.wednesdaybeers.reversedraw.server.model.participant.Participant;
import com.wednesdaybeers.reversedraw.server.model.ticket.TicketRepository;
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

    public void createTickets(List<String> names, int ticketsPerUser) throws ReverseDrawException
    {
        if (ticketRepository.count() != 0) {
            throw new ReverseDrawException(ErrorCode.TICKETS_ALREADY_CREATED, "Tickets already created");
        }

        for (String name : names) {
            Participant participant = userCreator.createUser(name);
            for (int i = 0; i < ticketsPerUser; i++) {
                ticketCreator.createTicket(participant);
            }
        }
    }
}
