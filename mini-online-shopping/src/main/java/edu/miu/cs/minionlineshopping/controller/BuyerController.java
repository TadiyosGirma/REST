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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.exceptions.UserNotFoundException;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.serviceImpl.BuyerServiceImpl;

@RestController
public class BuyerController {

	@Autowired
	BuyerServiceImpl buyerService;

	@PostMapping("/buyers")
	public ResponseEntity<Buyer> createBuyer(@RequestBody Buyer buyer) {
		Buyer savedBuyer = buyerService.createBuyer(buyer);

		return new ResponseEntity<Buyer>(savedBuyer, HttpStatus.CREATED);
	}

	@GetMapping("/buyers/{id}")
	public Optional<Buyer> retriveBuyer(@PathVariable Long id) {
		Optional<Buyer> buyerReturned = buyerService.findABuyer(id);

		if (!buyerReturned.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			return buyerReturned;
		}
	}

	@GetMapping("/buyers")
	public List<Buyer> retriveAllBuyers() {
		List<Buyer> buyerReturned = buyerService.findAllBuyers();

		if (buyerReturned.isEmpty()) {
			throw new UserNotFoundException("There are no registered Buyers");
		} else {
			return buyerReturned;
		}
	}

	@PostMapping("buyers/{id}")
	public void updateBuyer(@RequestBody Buyer buyer) {
		buyerService.updateBuyer(buyer);
	}

	@DeleteMapping("/buyers/{id}")
	public void deleteBuyer(@PathVariable Long id) {
		buyerService.deleteBuyer(id);
	}
}
