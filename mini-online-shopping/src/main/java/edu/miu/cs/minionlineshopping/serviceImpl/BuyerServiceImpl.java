package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.BuyerDao;
import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Seller;

@Service
public class BuyerServiceImpl {

	@Autowired
	BuyerDao buyerDao;

	public Buyer saveBuyer(Buyer buyer) {
		return buyerDao.save(buyer);
	}

	public Buyer updateBuyer(Buyer buyer) {
		return buyerDao.save(buyer);
	}

	public void deleteBuyer(Long id) {
		buyerDao.deleteById(id);
	}

	public Optional<Buyer> findABuyer(Long id) {
		return buyerDao.findById(id);
	}

	public List<Buyer> findAllBuyers() {
		return buyerDao.findAll();
	}
}
