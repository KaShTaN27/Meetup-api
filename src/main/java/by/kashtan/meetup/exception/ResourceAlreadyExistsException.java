package by.kashtan.meetup.exception;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ResourceAlreadyExistsException extends ExceptionWithHttpStatus{
    public ResourceAlreadyExistsException(String eventDescription) {
        super(BAD_REQUEST, String.format("Event with description [%s] already exists", eventDescription));
    }
}
