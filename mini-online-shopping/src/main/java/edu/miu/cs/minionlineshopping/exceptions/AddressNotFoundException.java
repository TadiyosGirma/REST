package edu.miu.cs.minionlineshopping.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


public class AddressNotFoundException extends NotFoundException {

	public AddressNotFoundException(String message) {
		super(message);
	}
}
