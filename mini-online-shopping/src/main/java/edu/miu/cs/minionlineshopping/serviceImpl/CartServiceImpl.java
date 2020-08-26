package edu.miu.cs.minionlineshopping.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.miu.cs.minionlineshopping.dao.SellerDao;
import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.dao.CartItemDao;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.CartItem;
import edu.miu.cs.minionlineshopping.model.Product;
import edu.miu.cs.minionlineshopping.model.Seller;

@Service
public class CartServiceImpl {

	@Autowired
	CartDao CartDao;

	@Autowired
	CartItemDao cartItemDao;

	public Optional<Cart> findACart(Long id) {
		return CartDao.findById(id);
	}

	public List<Cart> findAllCarts() {
		return CartDao.findAll();
	}

	public CartItem addCartItem(Long cartId, CartItem cartItem) {
		Optional<Cart> cartOpt = findACart(cartId);

		if (cartOpt.isPresent()) {
			Cart cartObj = cartOpt.get();
			cartObj.addCartItem(cartItem);
			CartDao.save(cartObj);

			return cartItem;
		} else {
			return null;
		}
	}

	public void removeCartItem(Long cartId, CartItem cartItem) {
		Optional<Cart> cartOpt = findACart(cartId);

		if (cartOpt.isPresent()) {
			Cart cartObj = cartOpt.get();
			cartObj.removeCartItem(cartItem);
			CartDao.save(cartObj);
			cartItemDao.deleteById(cartItem.getId());
		}
	}
}
