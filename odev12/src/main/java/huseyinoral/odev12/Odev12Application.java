package huseyinoral.odev12;

import huseyinoral.odev12.core.exception.NullBookNameException;
import huseyinoral.odev12.core.exception.ProblemDetails;
import huseyinoral.odev12.core.exception.ValidationProblemsDetails;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import huseyinoral.odev12.core.properties.ErrorProperties;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;


@SpringBootApplication
@RestControllerAdvice
public class Odev12Application {

	public static void main(String[] args) {
		SpringApplication.run(Odev12Application.class, args);
	}

}
