package edu.miu.cs.minionlineshopping.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Buyer extends User {

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart; 

	@OneToMany(mappedBy = "buyer")
	List<Order> orders;

	public Buyer() {

	}

	public Buyer(String name, int age, String userName, String passWord, Address address) {
		super(name, age, userName, passWord, address);
	}

	public void addOrders(Order order) {
		orders.add(order);
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<Order> getOrders() {
		return orders;
	}

	public void setOrders(List<Order> orders) {
		this.orders = orders;
	}

}
