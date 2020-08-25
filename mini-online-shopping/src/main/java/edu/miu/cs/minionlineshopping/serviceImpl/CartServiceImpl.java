package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.Seller;

@Service
public class CartServiceImpl {

	@Autowired
	CartDao CartDao;

	public Optional<Cart> findACart(Long id) {
		return CartDao.findById(id);
	}

	public List<Cart> findAllBuyers() {
		return CartDao.findAll();
	}
}
