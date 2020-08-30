package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.dao.CartItemDao;
import edu.miu.cs.minionlineshopping.exceptions.CartItemNotFoundException;
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

	public Optional<CartItem> findOneCartItem(Long id) {
		Optional<CartItem> cartItemReturnded = cartItemDao.findById(id);

		if (!cartItemReturnded.isPresent()) {
			throw new CartItemNotFoundException("id: " + id);
		} else {
			return cartItemReturnded;
		}
	}

	public ResponseEntity<CartItem> updateCartItem(Long id, CartItem cartItem) {
		Optional<CartItem> cartItemExisting = cartItemDao.findById(id);

		if (!cartItemExisting.isPresent()) {
			throw new CartItemNotFoundException("id: " + id);
		} else {
			CartItem cartItemUpdated = cartItemDao.save(cartItem);
			return new ResponseEntity<CartItem>(cartItemUpdated, HttpStatus.CREATED);
		}
	}

	public void deleteCartItem(Long id) {
		cartItemDao.deleteById(id);
	}

}
