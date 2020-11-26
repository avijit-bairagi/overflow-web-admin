package com.overflow.adminportal.common.exception;

public class AlreadyExistsException extends Exception {

    private String code;

    public AlreadyExistsException(String code, String message) {
        super(message);
        this.code = code;
    }

    public String getCode() {
        return code;
    }
}
