package com.overflow.adminportal.common.utils;

public enum ResponseStatus {

    SUCCESSFUL("1000", "Successful"),
    ALREADY_EXISTS("1409", "Entity already exists"),
    NOT_FOUND("1404", "Entity not found");

    private final String value;
    private final String description;

    ResponseStatus(String value, String description) {
        this.value = value;
        this.description = description;
    }

    public String value() {
        return value;
    }

    public String description() {
        return description;
    }

}
