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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.dao.BuyerDao;
import edu.miu.cs.minionlineshopping.dao.CartDao;
import edu.miu.cs.minionlineshopping.model.Buyer;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.CartItem;
import edu.miu.cs.minionlineshopping.model.Product;
import edu.miu.cs.minionlineshopping.serviceImpl.BuyerServiceImpl;
import edu.miu.cs.minionlineshopping.serviceImpl.CartServiceImpl;

@RestController
public class CartController {

	@Autowired
	BuyerServiceImpl buyerService;
	@Autowired
	CartServiceImpl cartService;

	@GetMapping("/buyers/{id}/cart")
	public Optional<Cart> findAllItemsInCart(@PathVariable Long id) {
		Optional<Buyer> buyerOpt = buyerService.findABuyer(id);
		if (buyerOpt.isPresent()) {
			Buyer buyerObj = buyerOpt.get();
			Long cartId = buyerObj.getCart().getId();

			Optional<Cart> cart = cartService.findACart(cartId);
			if (cart.isPresent()) {
				return cartService.findACart(cartId);
			} else {
				return null;
			}
		} else {
			return null;
		}
	}

	@GetMapping("/buyers/cart")
	public List<Cart> findAllCarts() {
		return cartService.findAllCarts();
	}

	@PostMapping("/buyers/{id}/cart/{cartId}/cartitems")
	public CartItem addCartItemToCart(@RequestBody CartItem cartItem, @PathVariable Long cartId) {
		return cartService.addCartItem(cartId, cartItem);
	}

	@DeleteMapping("/buyers/{id}/cart/{cartId}/cartitems")
	public void removeProductFromCart(@RequestBody CartItem cartItem, @PathVariable Long cartId) {
		cartService.removeCartItem(cartId, cartItem);
	}

}
