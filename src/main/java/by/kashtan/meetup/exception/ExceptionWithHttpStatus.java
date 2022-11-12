package by.kashtan.meetup.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ExceptionWithHttpStatus extends RuntimeException {
    private final HttpStatus httpStatus;
    private final String message;
}
