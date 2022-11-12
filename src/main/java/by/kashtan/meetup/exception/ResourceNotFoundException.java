package by.kashtan.meetup.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ResourceNotFoundException extends ExceptionWithHttpStatus {
    public ResourceNotFoundException(Long eventId) {
        super(BAD_REQUEST, String.format("Event with id=%d does not exists", eventId));
    }
}
