package edu.miu.cs.minionlineshopping.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.model.Address;
import edu.miu.cs.minionlineshopping.serviceImpl.AddressServiceImpl;

@RestController
public class AddressController {

	@Autowired
	AddressServiceImpl addressService;

	@GetMapping("/address")
	public List<Address> getAllAdresses() {
		return addressService.findAllAddresses();
	}

	@GetMapping("/address/{id}")
	public Optional<Address> getAllAdresses(@PathVariable Long id) {
		return addressService.findAnAddresses(id);
	}

	@PostMapping("/address")
	public Address createAddress(@RequestBody Address address) {
		return addressService.createAddress(address);
	}

	@PutMapping("/address/{id}")
	public Address updateAddress(@RequestBody Address address) {
		System.out.println("here");
		return addressService.updateAddress(address);
	}

	@DeleteMapping("/address/{id}")
	public void deleteAddress(@PathVariable Long id) {
		addressService.deleteAddress(id);
	}

}
