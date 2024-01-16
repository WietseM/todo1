package be.vdab.todo1.mensen;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
class MensNietGevondenException extends RuntimeException {
    MensNietGevondenException() {
        super("Mens niet gevonden.");
    }
}

