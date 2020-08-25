package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.dao.UserDao;
import edu.miu.cs.minionlineshopping.model.Seller;
import edu.miu.cs.minionlineshopping.model.User;

@Service
public class SellerServiceImpl {

	@Autowired
	SellerDao sellerDao;

	public Seller saveSeller(Seller seller) {
		return sellerDao.save(seller);
	}

	public Seller updateSeller(Seller seller) {
		return sellerDao.save(seller);
	}

	public void deleteSeller(Long id) {
		sellerDao.deleteById(id);
	}

	public Optional<Seller> findSeller(Long id) {
		return sellerDao.findById(id);
	}

	public List<Seller> findAllSellers() {
		return sellerDao.findAll();
	}
}
