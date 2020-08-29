package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.BuyerDao;
import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.exceptions.UserNotFoundException;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Seller;

@Service
public class BuyerServiceImpl {

	@Autowired
	BuyerDao buyerDao;

	public ResponseEntity<Buyer> createBuyer(Buyer buyer) {
		Buyer savedBuyer = buyerDao.save(buyer);
		return new ResponseEntity<Buyer>(savedBuyer, HttpStatus.CREATED);
	}

	public Optional<Buyer> findOneBuyer(Long id) {
		Optional<Buyer> buyerReturned = buyerDao.findById(id);

		if (!buyerReturned.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			return buyerReturned;
		}
	}

	public List<Buyer> findAllBuyers() {
		List<Buyer> buyerReturned = buyerDao.findAll();

		if (buyerReturned.isEmpty()) {
			throw new UserNotFoundException("There are no registered Buyers");
		} else {
			return buyerReturned;
		}
	}

	public ResponseEntity<Buyer> updateBuyer(Long id, Buyer buyer) {
		Optional<Buyer> buyerExisting = buyerDao.findById(id);

		if (!buyerExisting.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			Buyer buyerUpdated = buyerDao.save(buyer);
			return new ResponseEntity<Buyer>(buyerUpdated, HttpStatus.CREATED);
		}
	}

	public void deleteBuyer(Long id) {
		Optional<Buyer> buyerExisting = buyerDao.findById(id);

		if (!buyerExisting.isPresent()) {
			throw new UserNotFoundException("id: " + id);
		} else {
			buyerDao.deleteById(id);
		}
	}
}
