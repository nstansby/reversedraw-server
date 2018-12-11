package com.wednesdaybeers.reversedraw.server.creator.User;

import com.wednesdaybeers.reversedraw.server.model.participant.Participant;
import com.wednesdaybeers.reversedraw.server.model.participant.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserCreator {

    @Autowired
    private ParticipantRepository participantRepository;

    public Participant createUser(String name) {
        Participant participant = new Participant();
        participant.setName(name);

        return participantRepository.save(participant);
    }
}
