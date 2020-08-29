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
		return addressService.createAddress(address);
	}

	@GetMapping("/address/{id}")
	public Optional<Address> retriveAdress(@PathVariable Long id) {
		return addressService.findAnAddresses(id);
	}

	@GetMapping("/address")
	public List<Address> retriveAllAdresses() {
		return addressService.findAllAddresses();
	}

	@PutMapping("/address/{id}")
	public ResponseEntity<Address> updateAddress(@PathVariable Long id, @RequestBody Address address) {
		return addressService.updateAddress(id, address);
	}

	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
	}

}
