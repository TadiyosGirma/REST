package edu.miu.cs.minionlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.exceptions.AddressNotFoundException;
import edu.miu.cs.minionlineshopping.model.Address;
import edu.miu.cs.minionlineshopping.serviceImpl.AddressServiceImpl;

@RestController
public class AddressController {

	@Autowired
	AddressServiceImpl addressService;

	@PostMapping("/address")
	public ResponseEntity<Address> createAddress(@RequestBody Address address) {
		Address savedAddress = addressService.createAddress(address);
		return new ResponseEntity<Address>(savedAddress, HttpStatus.CREATED);
	}

	@GetMapping("/address/{id}")
	public Optional<Address> retrivedress(@PathVariable Long id) {
		Optional<Address> addressReturned = addressService.findAnAddresses(id);

		if (!addressReturned.isPresent()) {
			throw new AddressNotFoundException("id: " + id);
		} else {
			return addressReturned;
		}
	}

	@GetMapping("/address")
	public List<Address> retriveAllAdresses() {
		List<Address> addressesReturned = addressService.findAllAddresses();

		if (addressesReturned.isEmpty()) {
			throw new AddressNotFoundException("There are no registered addresses");
		} else {
			return addressesReturned;
		}
	}

	@PutMapping("/address/{id}")
	public Address updateAddress(@RequestBody Address address) {
		return addressService.updateAddress(address);
	}

	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
	}

}
