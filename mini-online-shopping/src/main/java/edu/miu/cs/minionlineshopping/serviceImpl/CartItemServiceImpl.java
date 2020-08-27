package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.dao.CartItemDao;
import edu.miu.cs.minionlineshopping.model.CartItem;

@Service
public class CartItemServiceImpl {

	@Autowired
	CartItemDao cartItemDao;

//	public CartItem createCartItem(CartItem cartItem) {
//		return cartItemDao.save(cartItem);
//	}
//
//	public List<CartItem> findAllCartItems() {
//		return cartItemDao.findAll();
//	}

	public Optional<CartItem> findACartItem(Long id) { 
		return cartItemDao.findById(id);
	}

	public void deleteCartItem(Long id) {
		cartItemDao.deleteById(id);
	}
	//START HERE
	public CartItem updateCartItem(CartItem cartItem) {
		return cartItemDao.save(cartItem);
	}
}
