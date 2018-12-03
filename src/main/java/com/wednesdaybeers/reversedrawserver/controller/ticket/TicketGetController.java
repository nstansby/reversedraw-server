package com.wednesdaybeers.reversedrawserver.controller.ticket;

import com.wednesdaybeers.reversedrawserver.model.ticket.Ticket;
import com.wednesdaybeers.reversedrawserver.dto.RestResponse;
import com.wednesdaybeers.reversedrawserver.dto.ticket.TicketGetResponse;
import com.wednesdaybeers.reversedrawserver.model.participant.ParticipantRepository;
import com.wednesdaybeers.reversedrawserver.model.ticket.TicketRepository;
import com.wednesdaybeers.reversedrawserver.responseGenerator.ticket.TicketReponseGenerator;
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
