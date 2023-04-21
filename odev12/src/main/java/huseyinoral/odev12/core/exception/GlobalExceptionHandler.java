package huseyinoral.odev12.core.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
 
    @ExceptionHandler(value = NullBookNameException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ErrorResponse
    handleException(NullBookNameException ex)
    {
        return new ErrorResponse(ex.getStatusCode(), ex.getDescription(),ex.getMessage());
    }
}