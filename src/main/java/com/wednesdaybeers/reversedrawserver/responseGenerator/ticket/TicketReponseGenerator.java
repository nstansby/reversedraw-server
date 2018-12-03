package com.wednesdaybeers.reversedrawserver.responseGenerator.ticket;

import com.wednesdaybeers.reversedrawserver.model.ticket.Ticket;
import com.wednesdaybeers.reversedrawserver.dto.ticket.TicketDTO;
import com.wednesdaybeers.reversedrawserver.dto.ticket.TicketGetResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TicketReponseGenerator {

    public static TicketDTO createTicketDTO(Ticket ticket) {
        TicketDTO result = new TicketDTO();
        result.setId(ticket.getId());
        result.setState(ticket.getState());
        result.setName(ticket.getParticipant().getName());
        return result;
    }

    public TicketGetResponse createTicketGetReponse(List<Ticket> tickets, int numParticipants) {
        TicketGetResponse result = new TicketGetResponse();
        List<TicketDTO> ticketDTOs = tickets.stream()
                .map(TicketReponseGenerator::createTicketDTO)
                .collect(Collectors.toList());
        result.setTickets(ticketDTOs);
        result.setNumParticipants(numParticipants);
        return result;
    }
}
