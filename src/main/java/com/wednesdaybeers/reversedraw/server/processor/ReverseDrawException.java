package com.wednesdaybeers.reversedraw.server.processor;

import com.wednesdaybeers.reversedraw.server.dto.error.Error;

public class ReverseDrawException extends Exception {
    private int errorCode;
    private String developerMessage;

    public ReverseDrawException(int errorCode, String developerMessage) {
        super(String.format("Error code %d: %s", errorCode, developerMessage));
        this.errorCode = errorCode;
        this.developerMessage = developerMessage;
    }

    @Override
    public String toString() {
        return String.format("Error code %d: %s", errorCode, developerMessage);
    }

    public Error toErrorDTO() {
        return new Error(errorCode, developerMessage);
    }
}
