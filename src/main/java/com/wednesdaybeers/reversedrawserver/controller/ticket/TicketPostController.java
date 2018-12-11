package com.wednesdaybeers.reversedrawserver.controller.ticket;

import com.wednesdaybeers.reversedrawserver.dto.RestResponse;
import com.wednesdaybeers.reversedrawserver.dto.ticket.TicketPostRequest;
import com.wednesdaybeers.reversedrawserver.processor.TicketProcessor;
import com.wednesdaybeers.reversedrawserver.processor.ReverseDrawException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketPostController {

    @Autowired
    private TicketProcessor ticketProcessor;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<RestResponse> createTickets(@RequestBody @Valid TicketPostRequest request)
            throws ReverseDrawException {

        ticketProcessor.createTickets(request.getNames(), request.getNumTickets());

        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
