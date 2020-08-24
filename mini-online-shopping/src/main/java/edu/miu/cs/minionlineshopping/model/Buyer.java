package edu.miu.cs.minionlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Buyer extends User {

	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "cart_id")
	private Cart cart;

	@OneToMany(mappedBy = "buyer", cascade = CascadeType.ALL)
	List<CustomerOrder> customerOrders;

	public Buyer() {

	}

	public Buyer(String name, int age, String userName, String passWord, Address address) {
		super(name, age, userName, passWord, address);
	}

	public void addOrders(CustomerOrder customerOrder) {
		customerOrders.add(customerOrder);
	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	public List<CustomerOrder> getOrders() {
		return customerOrders;
	}

	public void setOrders(List<CustomerOrder> customerOrders) {
		this.customerOrders = customerOrders;
	}

}
