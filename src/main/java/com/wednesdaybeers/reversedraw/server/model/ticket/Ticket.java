package com.wednesdaybeers.reversedraw.server.model.ticket;


import com.wednesdaybeers.reversedraw.server.model.participant.Participant;
import com.wednesdaybeers.reversedraw.server.model.BaseEntity;

import javax.persistence.*;
import java.util.Date;

@Entity(name = "tickets")
public class Ticket extends BaseEntity {

    public enum State {
        ACTIVE,
        DRAWN
    }

    @ManyToOne
    Participant participant;

    @Column(name = "state", nullable = false, columnDefinition = "enum()")
    @Enumerated(EnumType.STRING)
    private State state;

    @Column(name = "drawn_date", nullable = true)
    private Date drawnDate;

    // Autogen setters and getters

    public Participant getParticipant() {
        return participant;
    }

    public void setParticipant(Participant participant) {
        this.participant = participant;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Date getDrawnDate() {
        return drawnDate;
    }

    public void setDrawnDate(Date drawnDate) {
        this.drawnDate = drawnDate;
    }
}
