package org.example.itautest.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)

public class Exception extends RuntimeException {
    public Exception(String s) {
        super(s);
    }
}
