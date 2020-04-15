package com.gmo.constant;

import org.springframework.http.HttpStatus;

public enum StatusCode {
	
    SUCCESS(HttpStatus.OK.value()),
    NOT_FOUND(HttpStatus.NOT_FOUND.value()),
    BAD_REQUEST(HttpStatus.BAD_REQUEST.value()),
	CANNOT_INSERTED(900);

    private int value;

    StatusCode(int value) {
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
