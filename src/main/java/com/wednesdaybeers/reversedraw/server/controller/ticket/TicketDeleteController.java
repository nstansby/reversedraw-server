package com.wednesdaybeers.reversedraw.server.controller.ticket;

import com.wednesdaybeers.reversedraw.server.dto.RestResponse;
import com.wednesdaybeers.reversedraw.server.dto.error.ErrorCode;
import com.wednesdaybeers.reversedraw.server.dto.ticket.TicketDTO;
import com.wednesdaybeers.reversedraw.server.model.ticket.Ticket;
import com.wednesdaybeers.reversedraw.server.model.ticket.TicketRepository;
import com.wednesdaybeers.reversedraw.server.responseGenerator.ticket.TicketReponseGenerator;
import com.wednesdaybeers.reversedraw.server.processor.ReverseDrawException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketDeleteController {

    @Autowired
    private TicketRepository ticketRepository;

    @Autowired
    private TicketReponseGenerator ticketReponseGenerator;

    @RequestMapping(method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> getTickets(@RequestParam Integer id) throws ReverseDrawException {
        if (id == null) {
            throw new ReverseDrawException(ErrorCode.INVALID_TICKET_IDENTIFIER, "No ticket specified.");
        }

        Ticket ticket = ticketRepository.findById(id).orElseThrow(() ->
                 new ReverseDrawException(ErrorCode.INVALID_TICKET_IDENTIFIER, "ticket with ID " + id + " does not exist"));

        if (ticket.getState() != Ticket.State.ACTIVE) {
            throw new ReverseDrawException(ErrorCode.INVALID_TICKET_IDENTIFIER, "ticket with ID " + id + " has already been drawn.");
        }

        ticket.setState(Ticket.State.DRAWN);
        ticket.setDrawnDate(new Date());

        ticketRepository.save(ticket);

        TicketDTO response = TicketReponseGenerator.createTicketDTO(ticket);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

}
