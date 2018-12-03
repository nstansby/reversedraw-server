package com.wednesdaybeers.reversedrawserver.model.participant;

import com.wednesdaybeers.reversedrawserver.model.BaseEntity;

import javax.persistence.Entity;

@Entity(name = "participants")
public class Participant extends BaseEntity {
    private String name;

    // Autogen setters and getters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
