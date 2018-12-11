package com.wednesdaybeers.reversedraw.server.model.participant;

import com.wednesdaybeers.reversedraw.server.model.BaseEntity;

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
