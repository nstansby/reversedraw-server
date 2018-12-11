package com.wednesdaybeers.reversedraw.server.controller.ticket;

import com.wednesdaybeers.reversedraw.server.dto.RestResponse;
import com.wednesdaybeers.reversedraw.server.dto.ticket.TicketGetResponse;
import com.wednesdaybeers.reversedraw.server.model.participant.ParticipantRepository;
import com.wednesdaybeers.reversedraw.server.model.ticket.Ticket;
import com.wednesdaybeers.reversedraw.server.model.ticket.TicketRepository;
import com.wednesdaybeers.reversedraw.server.responseGenerator.ticket.TicketReponseGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketGetController {

    @Autowired
    ParticipantRepository participantRepository;

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketReponseGenerator ticketReponseGenerator;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getTickets() {

        int numParticipants = (int) participantRepository.count();
        List<Ticket> tickets = ticketRepository.findByState(Ticket.State.ACTIVE);
        TicketGetResponse reponse = ticketReponseGenerator.createTicketGetReponse(tickets, numParticipants);
        return new ResponseEntity<>(reponse, HttpStatus.OK);
    }

}
