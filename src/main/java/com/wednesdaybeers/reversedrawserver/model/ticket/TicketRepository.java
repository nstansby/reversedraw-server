package com.wednesdaybeers.reversedrawserver.model.ticket;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TicketRepository extends CrudRepository<Ticket, Integer> {
    List<Ticket> findByState(Ticket.State state);
}
