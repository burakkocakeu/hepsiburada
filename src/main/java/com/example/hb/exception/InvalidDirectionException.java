package com.example.hb.exception;

import com.example.hb.enums.DirectionEnum;

public class InvalidDirectionException extends Exception {
    private static final String message = "invalid_direction_provided";

    public InvalidDirectionException(String element) {
        super(message + ": '" + element + "', expected value should be one of [" + DirectionEnum.values() + "]");
    }
}
