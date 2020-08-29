package edu.miu.cs.minionlineshopping.exceptions;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestController
@ControllerAdvice
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<Object> handleAddressNotFoundException(NotFoundException ex, WebRequest request) {

		if (ex instanceof NotFoundException) {
			ExceptionResponseFormat exceptionResponseFormat = new ExceptionResponseFormat(new Date(), ex.getMessage(),
					request.getDescription(false));

			return new ResponseEntity<Object>(exceptionResponseFormat, HttpStatus.NOT_FOUND);
		}

		else {
			ExceptionResponseFormat exceptionResponseFormat = new ExceptionResponseFormat(new Date(), ex.getMessage(),
					request.getDescription(false));

			return new ResponseEntity<Object>(exceptionResponseFormat, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
