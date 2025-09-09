package com.core;


@SuppressWarnings("serial")
public class InvalidAmountException extends Exception {
    public InvalidAmountException(String message) {
        super(message);
    }
}