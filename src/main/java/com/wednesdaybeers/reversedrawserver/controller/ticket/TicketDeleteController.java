package com.wednesdaybeers.reversedrawserver.controller.ticket;

import com.wednesdaybeers.reversedrawserver.model.ticket.Ticket;
import com.wednesdaybeers.reversedrawserver.responseGenerator.ticket.TicketReponseGenerator;
import com.wednesdaybeers.reversedrawserver.dto.RestResponse;
import com.wednesdaybeers.reversedrawserver.dto.ticket.TicketDTO;
import com.wednesdaybeers.reversedrawserver.model.ticket.TicketRepository;
import com.wednesdaybeers.reversedrawserver.processor.WineDrawException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static com.wednesdaybeers.reversedrawserver.dto.error.ErrorCode.INVALID_TICKET_IDENTIFIER;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketDeleteController {

    @Autowired
    TicketRepository ticketRepository;

    @Autowired
    TicketReponseGenerator ticketReponseGenerator;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> getTickets(@RequestParam Integer id) throws WineDrawException {
        if (id == null) {
            throw new WineDrawException(INVALID_TICKET_IDENTIFIER, "No ticket specified.");
        }

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() ->
                 new WineDrawException(INVALID_TICKET_IDENTIFIER, "ticket with ID " + id + " does not exist"));

        if (ticket.getState() != Ticket.State.ACTIVE) {
            throw new WineDrawException(INVALID_TICKET_IDENTIFIER, "ticket with ID " + id + " has already been drawn.");
        }

        ticket.setState(Ticket.State.DRAWN);

        ticketRepository.save(ticket);

        TicketDTO response = TicketReponseGenerator.createTicketDTO(ticket);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
