package com.hello.contact_details.exceptions;

public class UnknownUserException extends RuntimeException {

    private static final String MESSAGE = "User [id=%d] is not found";

    public UnknownUserException(Integer userId) {
        super(MESSAGE.formatted(userId));
    }

}
