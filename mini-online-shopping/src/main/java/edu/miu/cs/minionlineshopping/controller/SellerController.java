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

import edu.miu.cs.minionlineshopping.model.Seller;
import edu.miu.cs.minionlineshopping.serviceImpl.SellerServiceImpl;

@RestController
public class SellerController {

	@Autowired
	SellerServiceImpl sellerService;

	@PostMapping("/sellers")
	public ResponseEntity<Seller> createSeller(@RequestBody Seller seller) {
		Seller savedSeller = sellerService.createSeller(seller);

		return new ResponseEntity<Seller>(savedSeller, HttpStatus.CREATED);
	}

	@PostMapping("sellers/{id}")
	public void updateSeller(@RequestBody Seller seller) {
		sellerService.updateSeller(seller);
	}

	@GetMapping("/sellers")
	public List<Seller> findAllSellers() {
		return sellerService.findAllSellers();
	}

	@GetMapping("/sellers/{id}")
	public Optional<Seller> findASeller(@PathVariable Long id) {
		return sellerService.findSeller(id);
	}

	@DeleteMapping("/sellers/{id}")
	public void deleteSeller(@PathVariable Long id) {
		sellerService.deleteSeller(id);
	}
}
