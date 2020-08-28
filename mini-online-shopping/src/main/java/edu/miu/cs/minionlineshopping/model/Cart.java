package edu.miu.cs.minionlineshopping.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;

	@OneToMany(mappedBy = "cart", cascade = CascadeType.ALL)
	private List<CartItem> cartItems;

	public Cart() {

	}

	public void addCartItem(CartItem cartItem) {
		if (cartItems == null) {
			cartItems = new ArrayList<CartItem>();
			cartItems.add(cartItem);
		} else {
			cartItems.add(cartItem);
		}
	}

	public void removeCartItem(CartItem cartItem) {
		if (cartItems != null) {
			cartItems.remove(cartItem);
			System.out.println(cartItem);
			System.out.println(cartItems);
		}
	}

	public List<CartItem> getCartItems() {
		return cartItems;
	}

	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cart [id=" + id + ", cartItems=" + cartItems + "]";
	}
}
