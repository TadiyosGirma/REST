package edu.miu.cs.minionlineshopping.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.miu.cs.minionlineshopping.exceptions.CartItemNotFoundException;
import edu.miu.cs.minionlineshopping.model.Cart;
import edu.miu.cs.minionlineshopping.model.CartItem;
import edu.miu.cs.minionlineshopping.serviceImpl.CartItemServiceImpl;
import edu.miu.cs.minionlineshopping.serviceImpl.CartServiceImpl;

@RestController
public class CartItemController {

	@Autowired
	CartItemServiceImpl cartItemServiceImpl;

	@GetMapping("/buyers/{id}/carts/{cartId}/cartItems/{cartItemId}")
	public Optional<CartItem> retriveCartItem(@PathVariable Long cartItemId) {
		return cartItemServiceImpl.findOneCartItem(cartItemId);
	}

	@PatchMapping("/buyers/{id}/carts/{cartId}/cartItems/{cartItemId}")
	public ResponseEntity<CartItem> updateCartItem(@PathVariable Long cartItemId, @RequestBody CartItem cartItem) {
		return cartItemServiceImpl.updateCartItem(cartItemId, cartItem);
	}
}
