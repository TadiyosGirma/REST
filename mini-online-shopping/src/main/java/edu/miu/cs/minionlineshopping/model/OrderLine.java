package edu.miu.cs.minionlineshopping.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class OrderLine {

	@Id
	@GeneratedValue
	private long id;

//	private List<Line> orerLines;

	@OneToOne
	@JoinColumn(name = "cart_id")
	private Cart cart;
	
	public OrderLine() {
		
	}

	public OrderLine(Cart cart) {
		this.cart = cart;
	}
	
//	public void createALine(Cart cart) {
//		List<Product> products = cart.getProducts();
//		
//		for(Product prod: products) {
//			Line line = new Line(prod., unitPrie)
//		}
//	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

//	public double getQuantity() {
//		return quantity;
//	}
//
//	public void setQuantity(double quantity) {
//		this.quantity = quantity;
//	}
//
//	public double getTotalPrice() {
//		return totalPrice;
//	}
//
//	public void setTotalPrice(double totalPrice) {
//		this.totalPrice = totalPrice;
//	}

	public Cart getCart() {
		return cart;
	}

	public void setCart(Cart cart) {
		this.cart = cart;
	}

	
}
