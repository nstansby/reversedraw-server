package com.wednesdaybeers.reversedraw.server.dto.error;

import com.wednesdaybeers.reversedraw.server.dto.RestResponse;

public class Error implements RestResponse {
    private int code;
    private String developerMessage;

    // Autogen contructors

    public Error(int code, String developerMessage) {
        this.code = code;
        this.developerMessage = developerMessage;
    }

    // Autogen setters and getters

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDeveloperMessage() {
        return developerMessage;
    }

    public void setDeveloperMessage(String developerMessage) {
        this.developerMessage = developerMessage;
    }
}
